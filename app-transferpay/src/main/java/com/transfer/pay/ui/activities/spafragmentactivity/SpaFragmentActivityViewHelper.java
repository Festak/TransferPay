package com.transfer.pay.ui.activities.spafragmentactivity;

import android.support.v7.widget.Toolbar;

import com.istatkevich.cmvp.core.viewhelper.ViewHelper;
import com.transfer.pay.R;
import com.transfer.pay.databinding.ActivitySpaBaseLayoutBinding;


/**
 * @author Created by i.statkevich on 16.01.2017.
 */

public class SpaFragmentActivityViewHelper extends ViewHelper<SpaFragmentActivityPresenter, ActivitySpaBaseLayoutBinding> {
    private Toolbar toolbar;

    public void setActionBarTitle(String title) {
        if (toolbar == null || title == null) {
            return;
        }

        toolbar.setTitle(title);
    }

    @Override
    protected void onBindVariables(ActivitySpaBaseLayoutBinding binding) {
        // do nothing
    }

    @Override
    protected void onInitView() {
      //  initActionBar();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_spa_base_layout;
    }

    private void initActionBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (toolbar == null) {
            return;
        }
/*

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white);
        toolbar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                getPresenter().onHomeButtonClick();
                return false;
            }
        });
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().onHomeButtonClick();
            }
        });
*/


     /*   toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().onHomeButtonClick();
            }
        });*/
    }
}
