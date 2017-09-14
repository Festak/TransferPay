package com.transfer.pay.ui.activities.brand;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.tbuonomo.materialsquareloading.MaterialSquareLoading;
import com.transfer.pay.R;
import com.transfer.pay.TransferPayRouter;
import com.transfer.pay.UserManager;
import com.transfer.pay.utils.FileUtils;

public class BrandActivity extends AppCompatActivity {
    private static final int DELAY_NEXT_ACTIVITY = 4000;
    private Handler handler;
    private MaterialSquareLoading materialSquareLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.brand);

        materialSquareLoading = (MaterialSquareLoading) findViewById(R.id.material_square_loading_view);
        materialSquareLoading.show();
        initApplicationLogo();

        postponeNextActivity();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isFinishing()) {
            cancelPostponedRunnable();
        }
    }

    private void initApplicationLogo() {
        String fileName = UserManager.getInstance().getCurrentLogo();
        ImageView imageView = (ImageView) findViewById(R.id.applicationLogo);

        if (fileName != null) {
            Bitmap bitmap = FileUtils.loadBitmapFromFile(FileUtils.LOGO_PATH, fileName);
            imageView.setImageBitmap(bitmap);
        }
    }

    private void postponeNextActivity() {
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                TransferPayRouter router = new TransferPayRouter(BrandActivity.this);
                router.openLoginActivity();
            }
        }, DELAY_NEXT_ACTIVITY);
    }

    private void cancelPostponedRunnable() {
        handler.removeCallbacksAndMessages(null);
    }
}
