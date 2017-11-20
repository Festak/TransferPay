package com.transfer.pay.ui;

import com.istatkevich.cmvp.core.container.FragmentContainer;
import com.istatkevich.cmvp.core.presenter.Presenter;
import com.istatkevich.cmvp.core.viewhelper.ViewHelper;
import com.istatkevich.cmvp.core.viewmodel.ViewModel;

public abstract class TransferPayBaseFragment<VD extends ViewModel, VH extends ViewHelper<P, ?>, P extends Presenter> extends FragmentContainer<VD, VH, P> {

}
