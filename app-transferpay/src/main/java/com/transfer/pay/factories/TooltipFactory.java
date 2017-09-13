package com.transfer.pay.factories;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

import com.transfer.pay.R;
import com.transfer.pay.constants.Constants;
import com.transfer.pay.ui.customviews.Tooltip;
import com.transfer.pay.utils.UiUtils;

/**
 * @author Created by e.fetskovich on 5/22/17.
 */

public class TooltipFactory {

    private TooltipFactory() {
        // do nothing
    }

    public static Tooltip create(View view, int stringId) {
        UiUtils.expandTouchArea(view, Constants.TOOLTIP_TOUCH_AREA_PX);
        Context context = view.getContext();

        String mainText = context.getString(stringId);
        String actionLinkText = context.getString(R.string.need_help_additional_information);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(Constants.ADDITIONAL_INFO_URL));

        return new Tooltip(context, intent, mainText, actionLinkText, R.layout.tooltip);
    }

}
