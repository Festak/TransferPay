package com.transfer.pay.ui;

import com.istatkevich.cmvp.core.container.FragmentContainer;
import com.istatkevich.cmvp.core.presenter.Presenter;
import com.istatkevich.cmvp.core.viewhelper.ViewHelper;
import com.istatkevich.cmvp.core.viewmodel.ViewModel;

/**
 * @author Created by i.statkevich on 5/10/17.
 */

public abstract class TransferPayBaseFragment<VD extends ViewModel, VH extends ViewHelper<P, ?>, P extends Presenter> extends FragmentContainer<VD, VH, P> {

}
