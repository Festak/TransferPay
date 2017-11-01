package com.transfer.pay.ui.fragments.addcard;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.TempDataManager;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.ui.TransferPayBaseFragment;

/**
 * Created by e.fetskovich on 6/6/17.
 */

public class AddCardFragment extends TransferPayBaseFragment<EmptyViewModel, AddCardViewHelper, AddCardPresenter> {
    @Override
    protected EmptyViewModel createViewData() {
        return new EmptyViewModel();
    }

    @Override
    protected AddCardPresenter createPresenter() {
        return new AddCardPresenter();
    }

    @Override
    protected AddCardViewHelper createViewHelper() {
        return new AddCardViewHelper();
    }

    @Override
    public String getContainerId() {
        return ContainerId.Fragment.ADD_CARD;
    }

    @Override
    public void onDestroy() {
        TempDataManager.getDataManager().getCreditCardModel();
        super.onDestroy();
    }
}
