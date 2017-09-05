package com.transfer.pay.ui.list.binder;

import com.transfer.pay.R;
import com.transfer.pay.UserManager;
import com.transfer.pay.databinding.LogoItemBinding;
import com.transfer.pay.models.Logo;
import com.transfer.pay.ui.list.listener.OnClickedItemListener;
import com.transfer.pay.ui.list.listener.OnItemClickListener;

/**
 * Created by e.fetskovich on 6/16/17.
 */

public class LogoBinder implements ViewHolderBinder<LogoItemBinding, Logo> {

    private OnClickedItemListener listener;

    public LogoBinder(OnClickedItemListener listener) {
        this.listener = listener;
    }

    @Override
    public int getLayoutId() {
        return R.layout.logo_item;
    }

    @Override
    public void bindHolder(LogoItemBinding binding, Logo item, int position) {
        binding.setLogo(item);
        binding.setCurrentUserLogoName(UserManager.getInstance().getCurrentLogo());

        OnItemClickListener itemClickedListener = new OnItemClickListener(listener, position);
        binding.setListener(itemClickedListener);
    }
}
