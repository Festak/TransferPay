package com.transfer.pay.ui.fragments.beneficiaries;

import com.istatkevich.cmvp.core.viewhelper.ViewHelper;
import com.transfer.pay.data.DataStorage;
import com.transfer.pay.R;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.databinding.BeneficiariesBinding;
import com.transfer.pay.ui.UiConfigurator;
import com.transfer.pay.ui.activities.home.HomePresenter;
import com.transfer.pay.ui.fragments.TransferPayFragmentFactory;
import com.transfer.pay.ui.list.ListItemData;
import com.transfer.pay.ui.list.adapter.MultiTypeRecyclerAdapter;
import com.transfer.pay.ui.list.binder.ViewHolderBinderFactory;
import com.transfer.pay.ui.list.listener.OnClickedItemListener;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by i.statkevich on 5/25/17.
 */


public class BeneficiariesViewHelper extends ViewHelper<BeneficiariesPresenter, BeneficiariesBinding> {

    private MultiTypeRecyclerAdapter adapter;

    public void changeFragment(int fragmentId) {
        HomePresenter homePresenter = (HomePresenter) getActivityContainer().getPresenter(ContainerId.Activity.HOME, HomePresenter.class);
        homePresenter.changeContainerFragment(fragmentId);
    }

    public void openTransactionScreen() {
        changeFragment(TransferPayFragmentFactory.ID_TRANSACTION_OVERVIEW);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.beneficiaries;
    }

    @Override
    protected void onInitView() {
        initRecyclerView();
    }

    @Override
    protected void onBindVariables(BeneficiariesBinding binding) {
        binding.setPresenter(getPresenter());
    }

    public void updateData(List<ListItemData> list) {
        adapter.updateData(list);
    }

    public void notifyDataInRecyclerChanged(){
        adapter.notifyDataSetChanged();
    }

    private void initRecyclerView() {
        adapter = new MultiTypeRecyclerAdapter(new LinkedList<ListItemData>(),
                new ViewHolderBinderFactory(new OnClickedItemListener() {
                    @Override
                    public void onClickedItem(int position) {
                        ListItemData itemData = adapter.getItemByPosition(position);
                        DataStorage.getInstance().saveBeneficiary(itemData);
                        openTransactionScreen();

                    }
                }, new OnClickedItemListener() {
                    @Override
                    public void onClickedItem(int position) {
                        // TODO: FINISH THIS
                    }
                }));

        UiConfigurator.initRecyclerView(adapter, getRoot(), R.id.beneficiariesList);
    }

}
