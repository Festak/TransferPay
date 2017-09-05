package com.transfer.pay.ui.activities.home;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.R;
import com.transfer.pay.UserManager;
import com.transfer.pay.models.User;
import com.transfer.pay.ui.TransferPayBasePresenter;
import com.transfer.pay.ui.menu.navigator.Navigator;
import com.transfer.pay.utils.FileUtils;
import com.transfer.pay.utils.UserNameCombiner;

/**
 * Created by i.statkevich on 6/1/17.
 */

public class HomePresenter extends TransferPayBasePresenter<EmptyViewModel, HomeViewHelper> implements Navigator {

    private Navigator mainMenuNavigator;
    private Navigator containerNavigator;
    private int defaultNavigationDestination;

    public HomePresenter(Navigator navigator, Navigator containerNavigator, int defaultNavigationDestination) {
        this.mainMenuNavigator = navigator;
        this.containerNavigator = containerNavigator;
        this.defaultNavigationDestination = defaultNavigationDestination;
    }

    public void changeContainerFragment(int fragmentId) {
        changeContainerFragment(null, fragmentId);
    }

    public void changeContainerFragment(Bundle bundle, int fragmentId) {
        containerNavigator.navigate(bundle, fragmentId);
    }

    @Override
    public void onActivityResume() {
        changeApplicationLogo();
    }

    @Override
    protected void onPresenterReady() {
        mainMenuNavigator.navigate(null, defaultNavigationDestination);
    }

    @Override
    public void navigate(Bundle bundle, int menuItemId) {
        mainMenuNavigator.navigate(null, menuItemId);
    }

    public void setUserFullNameToText(TextView textView) {
        User user = UserManager.getInstance().getUser();
        String name = UserNameCombiner.combine(user);
        textView.setText(name);
    }

    public void changeApplicationLogo() {
        performFakeAsyncOperation(new Runnable() {
            @Override
            public void run() {
                ImageView imageView = (ImageView) getViewHelper().getBinding().navView.getHeaderView(0).findViewById(R.id.userLogo);
                String fileName = UserManager.getInstance().getCurrentLogo();
                Bitmap bitmap = loadBitmap(fileName);
                imageView.setImageBitmap(bitmap);
            }
        });
    }

    private Bitmap loadBitmap(String fileName) {
        if (fileName != null && FileUtils.isFileExists(FileUtils.LOGO_PATH, fileName)) {
            return FileUtils.loadBitmapFromFile(FileUtils.LOGO_PATH, fileName, 400);
        } else {
            return BitmapFactory.decodeResource(getViewHelper().getRoot().getResources(), R.drawable.logo_dark);
        }
    }

}
