package com.transfer.pay.ui.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.transfer.pay.R;

/**
 * @author e.fetskovich on 6/29/17.
 */

public class AdaptiveButtonLayout extends LinearLayout {

    public static final int AGREEMENT_BUTTONS = 10;
    public static final int BACK_NEXT_BUTTONS = 20;
    public static final int ONE_BUTTON = 30;
    public static final int NOTHING = -1;

    private Button backButton;
    private Button nextButton;

    public AdaptiveButtonLayout(Context context) {
        super(context);
        init(context, null);
    }

    public AdaptiveButtonLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public AdaptiveButtonLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public void setOnBackButtonClickListener(OnClickListener listener) {
        backButton.setOnClickListener(listener);
    }

    public void setOnNextButtonClickListener(OnClickListener listener) {
        nextButton.setOnClickListener(listener);
    }

    public void setType(int type) {
        switch (type) {
            case AGREEMENT_BUTTONS:
                switchButtonsToAgreement();
                break;
            case BACK_NEXT_BUTTONS:
                switchButtonsToBackNext();
                break;
            case ONE_BUTTON:
                switchToOneButton();
                break;
            case NOTHING:
                hideAllButtons();
                break;
            default:
                // do nothing
        }
    }

    public void setFirstButtonText(int stringId) {
        backButton.setText(stringId);
    }

    public void setSecondButtonText(int stringId) {
        nextButton.setText(stringId);
    }

    public void performSecondButtonClick() {
        nextButton.performClick();
    }

    private void switchButtonsToAgreement() {
        backButton.setVisibility(View.VISIBLE);
        nextButton.setVisibility(View.VISIBLE);
        backButton.setBackground(getResources().getDrawable(R.drawable.button_primary_gray));
        backButton.setText(getResources().getString(R.string.registration_aml_button_disagree));
        nextButton.setText(getResources().getString(R.string.registration_aml_button_agree));
    }

    private void switchButtonsToBackNext() {
        backButton.setVisibility(View.VISIBLE);
        nextButton.setVisibility(View.VISIBLE);

        backButton.setBackground(getResources().getDrawable(R.drawable.button_primary));
        nextButton.setBackground(getResources().getDrawable(R.drawable.button_primary));

        backButton.setText(getResources().getString(R.string.registration_aml_button_back));
        nextButton.setText(getResources().getString(R.string.registration_aml_button_next));
    }

    private void switchToOneButton() {
        backButton.setVisibility(View.GONE);
        nextButton.setVisibility(View.VISIBLE);
    }

    private void hideAllButtons() {
        backButton.setVisibility(View.GONE);
        nextButton.setVisibility(View.GONE);
    }

    private void init(Context context, AttributeSet attrs) {
        View.inflate(context, R.layout.button_adaptive, this);
        setDescendantFocusability(FOCUS_BLOCK_DESCENDANTS);
        backButton = (Button) findViewById(R.id.buttonBack);
        nextButton = (Button) findViewById(R.id.buttonNext);
        initAttrs(context, attrs);
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = context.getTheme().obtainStyledAttributes(
                    attrs,
                    R.styleable.AdaptiveButtonLayout,
                    0, 0);
            backButton.setText(a.getString(R.styleable.AdaptiveButtonLayout_firstButtonText));
            nextButton.setText(a.getString(R.styleable.AdaptiveButtonLayout_secondButtonText));
        }
    }
}
