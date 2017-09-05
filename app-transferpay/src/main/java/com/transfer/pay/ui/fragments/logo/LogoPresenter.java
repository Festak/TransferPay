package com.transfer.pay.ui.fragments.logo;

import android.Manifest;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.UserManager;
import com.transfer.pay.models.Logo;
import com.transfer.pay.ui.TransferPayBasePresenter;
import com.transfer.pay.utils.FileNameGenerator;
import com.transfer.pay.utils.FileUtils;
import com.transfer.pay.utils.thread.HandlerThreadExecutor;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by e.fetskovich on 6/16/17.
 */

public class LogoPresenter extends TransferPayBasePresenter<EmptyViewModel, LogoViewHelper> {

    private final String HANDLER_THREAD_NAME = "FILE_THREAD";

    private final int START_PROCESS = 10;
    private final int STOP_PROCESS = 20;

    private List<Logo> logoList;
    private HandlerThreadExecutor handlerThreadExecutor;
    private Handler handler;


    @Override
    public String[] getRequiredPermissions() {
        return new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.READ_PHONE_STATE
        };
    }

    @Override
    public void onPermissionDenied(String[] permissionsAllowed, String[] permissionsDenied, String[] permissionsDontAskAgain) {
        super.onPermissionDenied(permissionsAllowed, permissionsDenied, permissionsDontAskAgain);
        getScreen().closeScreen();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handlerThreadExecutor.quit();
    }

    @Override
    protected void onPresenterReady() {
        logoList = new LinkedList<>();
        initHandlerThread();
        initHandlerForShowingProgressDialog();
        loadLogosFromFile();
    }

    public void onNewLogoClick() {
        getViewHelper().pickImage();
    }

    public void setLogoToUser(Logo logo) {
        UserManager.getInstance().setLogoName(logo.fileName.get());
        UserManager.getInstance().saveUser();
    }

    public void loadLogosFromFile() {
        handlerThreadExecutor.postTask(loadLogosFromFileRunnable());
    }

    public void saveBitmapToFileAndUpdateLogos(final Bitmap bitmap) {
        handlerThreadExecutor.postTask(saveBitmapAndUpdateLogosRunnable(bitmap));
    }

    private Logo initLogoFromFile(File file) {
        String fileName = file.getName();
        Bitmap bitmap = FileUtils.loadBitmapFromFile(FileUtils.LOGO_PATH, fileName, getViewHelper().getImageWidth());
        return initLogo(bitmap, fileName);
    }

    private Logo initLogo(Bitmap bitmap, String fileName) {
        Logo logo = new Logo();
        logo.bitmap.set(bitmap);
        logo.fileName.set(fileName);
        return logo;
    }


    private Runnable loadLogosFromFileRunnable() {
        return new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(START_PROCESS);

                loadLogos();

                handler.sendEmptyMessage(STOP_PROCESS);
            }
        };
    }

    private void loadLogos() {
        File[] files = FileUtils.getAllFilesFromCurrentPath(FileUtils.LOGO_PATH);
        if (files != null) {
            for (File file : files) {
                logoList.add(initLogoFromFile(file));
            }
        }
    }

    private Runnable saveBitmapAndUpdateLogosRunnable(final Bitmap bitmap) {
        return new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(START_PROCESS);

                String fileName = FileNameGenerator.generateImageFileName("");
                FileUtils.writeBitmapToFile(FileUtils.LOGO_PATH, fileName, bitmap);

                Logo logo = initLogo(bitmap, fileName);
                logoList.add(logo);

                handler.sendEmptyMessage(STOP_PROCESS);
            }
        };
    }

    private void initHandlerForShowingProgressDialog() {
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case START_PROCESS:
                        getViewHelper().showProgress();
                        break;
                    case STOP_PROCESS:
                        getViewHelper().updateData(logoList);
                        getViewHelper().hideProgress();
                        break;
                }
            }
        };
    }

    private void initHandlerThread() {
        handlerThreadExecutor = new HandlerThreadExecutor(HANDLER_THREAD_NAME);
        handlerThreadExecutor.start();
        handlerThreadExecutor.prepareHandler();
    }

}
