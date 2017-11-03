package com.transfer.pay.ui.fragments.logo;

import android.content.Intent;

import com.istatkevich.cmvp.core.viewhelper.ViewHelper;
import com.transfer.pay.R;
import com.transfer.pay.constants.Constants;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.databinding.LogoBinding;
import com.transfer.pay.databinding.LogoItemBinding;
import com.transfer.pay.factories.LayoutManagerFactory;
import com.transfer.pay.models.Logo;
import com.transfer.pay.ui.UiConfigurator;
import com.transfer.pay.ui.list.adapter.RecyclerAdapter;
import com.transfer.pay.ui.list.binder.LogoBinder;
import com.transfer.pay.ui.list.binder.ViewHolderBinder;
import com.transfer.pay.ui.list.listener.OnClickedItemListener;
import com.transfer.pay.utils.ImagePicker;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by e.fetskovich on 6/16/17.
 */

public class LogoViewHelper extends ViewHelper<LogoPresenter, LogoBinding> {

    private static final int COLUMNS = 2;

    private RecyclerAdapter<LogoItemBinding, Logo> adapter;

    @Override
    protected void onInitView() {
        initRecyclerView();
    }

    public void updateData(List<Logo> list) {
        adapter.updateData(list);
    }

    public void notifyDataChanged() {
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onBindVariables(LogoBinding binding) {
        binding.setPresenter(getPresenter());
    }


    public void startIntent(Intent intent, int requestCode) {
        LogoFragment fragment = (LogoFragment) getActivityContainer().
                getSupportFragmentManager().
                findFragmentByTag(ContainerId.Fragment.LOGO);
        fragment.startActivityForResult(intent, requestCode);
    }

    public void pickImage() {
        Intent chooseImageIntent = ImagePicker.getPickImageIntent(getRoot().getContext());
        startIntent(chooseImageIntent, Constants.PICK_IMAGE_ID);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.logo;
    }

    public int getImageWidth() {
        return (int) getRoot().getResources().getDimension(R.dimen.logo_image_width);
    }

    private void initRecyclerView() {
        final ViewHolderBinder<LogoItemBinding, Logo> binder = new LogoBinder(new OnClickedItemListener() {
            @Override
            public void onClickedItem(final int position) {
                Logo logo = adapter.getItemByPosition(position);
                getPresenter().setLogoToUser(logo);
                adapter.notifyDataSetChanged();
                getPresenter().performFakeAsyncOperation(new Runnable() {
                    @Override
                    public void run() {

                    }
                }, 500);
            }
        });

        adapter = UiConfigurator.initRecyclerAndGetAdapter(
                new LinkedList<Logo>(),
                binder,
                getRoot(),
                LayoutManagerFactory.createGridLayoutManager(getRoot().getContext(), COLUMNS),
                R.id.logoList
        );

    }
}
