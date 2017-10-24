package com.transfer.pay.ui.fragments.beneficiaries;

import com.istatkevich.cmvp.core.viewhelper.ViewHelper;
import com.transfer.pay.R;
import com.transfer.pay.TempDataManager;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.databinding.BeneficiariesBinding;
import com.transfer.pay.databinding.BeneficiaryItemBankAccountBinding;
import com.transfer.pay.databinding.BeneficiaryItemCreditAccountCardBinding;
import com.transfer.pay.factories.LayoutManagerFactory;
import com.transfer.pay.models.BankAccountModel;
import com.transfer.pay.models.CreditCardAccountModel;
import com.transfer.pay.ui.UiConfigurator;
import com.transfer.pay.ui.activities.home.HomePresenter;
import com.transfer.pay.ui.fragments.TransferPayFragmentFactory;
import com.transfer.pay.ui.list.adapter.RecyclerAdapter;
import com.transfer.pay.ui.list.binder.BeneficiaryBankAccountBinder;
import com.transfer.pay.ui.list.binder.CreditCardAccountBinder;
import com.transfer.pay.ui.list.binder.ViewHolderBinder;
import com.transfer.pay.ui.list.listener.OnClickedItemListener;

import java.util.Collection;
import java.util.LinkedList;

public class BeneficiariesViewHelper extends ViewHelper<BeneficiariesPresenter, BeneficiariesBinding> {

    private RecyclerAdapter<BeneficiaryItemCreditAccountCardBinding, CreditCardAccountModel> cardsAdapter;
    private RecyclerAdapter<BeneficiaryItemBankAccountBinding, BankAccountModel> accountsAdapter;

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

    public void updateCardsData(Collection<CreditCardAccountModel> list) {
        cardsAdapter.updateData(list);
    }

    public void updateAccountsData(Collection<BankAccountModel> list){
        accountsAdapter.updateData(list);
    }

    private void initRecyclerView() {
        ViewHolderBinder<BeneficiaryItemCreditAccountCardBinding, CreditCardAccountModel> binder = new CreditCardAccountBinder(new OnClickedItemListener() {
            @Override
            public void onClickedItem(int position) {
                CreditCardAccountModel model = cardsAdapter.getItemByPosition(position);
                TempDataManager.getDataManager().setCreditCardAccountModel(model);
                openTransactionScreen();
            }
        },
                new OnClickedItemListener() {
                    @Override
                    public void onClickedItem(int position) {
                        // TODO: FINISH EDIT LOGIC
                    }
                }
        );

        cardsAdapter = UiConfigurator.initRecyclerAndGetAdapter(
                new LinkedList<CreditCardAccountModel>(),
                binder,
                getRoot(),
                LayoutManagerFactory.createLinearLayoutManager(getRoot().getContext()),
                R.id.creditCardList
        );

        ViewHolderBinder<BeneficiaryItemBankAccountBinding, BankAccountModel> binderAccount = new BeneficiaryBankAccountBinder(new OnClickedItemListener() {
            @Override
            public void onClickedItem(int position) {
                BankAccountModel model = accountsAdapter.getItemByPosition(position);
                TempDataManager.getDataManager().setBankAccountModel(model);
                openTransactionScreen();
            }
        },
                new OnClickedItemListener() {
                    @Override
                    public void onClickedItem(int position) {
                        // TODO: FINISH EDIT LOGIC
                    }
                }
        );

        accountsAdapter = UiConfigurator.initRecyclerAndGetAdapter(
                new LinkedList<BankAccountModel>(),
                binderAccount,
                getRoot(),
                LayoutManagerFactory.createLinearLayoutManager(getRoot().getContext()),
                R.id.bankAccountList
        );



    }

}
