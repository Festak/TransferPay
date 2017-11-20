package com.transfer.pay.ui.customviews.authresult;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.transfer.pay.R;


public class AuthResultLayout extends RelativeLayout implements View.OnClickListener {
    private ProgressBar progressBar;
    private ImageView authIcon;
    private TextView text;
    private View buttonClose;

    public AuthResultLayout(Context context) {
        this(context, null);
    }

    public AuthResultLayout(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public AuthResultLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public AuthResultLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public void switchState(AuthStatus state) {
        switch(state) {
            case SUCCESSFUL:
                switchToAuthResultState(R.string.auth_result_text_approved, R.drawable.ic_checked, R.color.authLabelBackgroundSuccess);
                break;
            case UNSUCCESSFUL:
                switchToAuthResultState(R.string.auth_result_text_not_approved, R.drawable.ic_cross, R.color.authLabelBackgroundFailed);
                break;
            case TIMEOUT:
                switchToAuthResultState(R.string.auth_result_text_timeout, R.drawable.ic_cross, R.color.authLabelBackgroundFailed);
                break;
            case ERROR:
                switchToAuthResultState(R.string.auth_result_text_error, R.drawable.ic_cross, R.color.authLabelBackgroundFailed);
                break;
            case NO_INTERNET_CONNECTION:
                switchToAuthResultState(R.string.auth_result_text_no_internet_connection, R.drawable.ic_cross, R.color.authLabelBackgroundFailed);
                break;
            default:
                // do nothing
        }
    }

    public void switchToWaitingState() {
        authIcon.setVisibility(View.GONE);
        buttonClose.setVisibility(View.GONE);

        progressBar.setVisibility(View.VISIBLE);

        text.setText(R.string.auth_result_text_waiting);
        text.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.authLabelBackgroundSuccess));
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.auth_button_close) {
            this.setVisibility(View.GONE);
        }
    }

    private void init() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.layout_auth_result, this, false);
        addView(view);

        initViews();
        switchToWaitingState();
    }

    private void initViews() {
        progressBar = (ProgressBar) findViewById(R.id.auth_progress);
        authIcon = (ImageView) findViewById(R.id.auth_icon);
        text = (TextView) findViewById(R.id.auth_text);
        buttonClose = findViewById(R.id.auth_button_close);

        buttonClose.setOnClickListener(this);
    }

    private void switchToAuthResultState(int messageId, int iconId, int colorId) {
        authIcon.setVisibility(View.VISIBLE);
        buttonClose.setVisibility(View.VISIBLE);

        progressBar.setVisibility(View.GONE);

        text.setText(messageId);
        text.setBackgroundColor(ContextCompat.getColor(getContext(), colorId));

        authIcon.setImageResource(iconId);
    }
}

