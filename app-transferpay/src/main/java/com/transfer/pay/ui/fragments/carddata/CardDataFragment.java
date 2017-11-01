package com.transfer.pay.ui.fragments.carddata;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.ui.TransferPayBaseFragment;

/**
 * @author e.fetskovich on 11/1/17.
 */

public class CardDataFragment extends TransferPayBaseFragment<EmptyViewModel, CardDataViewHelper, CardDataPresenter> {
    @Override
    protected EmptyViewModel createViewData() {
        return new EmptyViewModel();
    }

    @Override
    protected CardDataPresenter createPresenter() {
        return new CardDataPresenter();
    }

    @Override
    protected CardDataViewHelper createViewHelper() {
        return new CardDataViewHelper();
    }

    @Override
    public String getContainerId() {
        return ContainerId.Fragment.CARD_DATA;
    }
}
