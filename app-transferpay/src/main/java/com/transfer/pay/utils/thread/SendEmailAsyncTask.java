package com.transfer.pay.utils.thread;

import android.os.AsyncTask;

import com.transfer.pay.utils.email.GMailSender;

/**
 * @author e.fetskovich on 9/12/17.
 */

public class SendEmailAsyncTask extends AsyncTask<Void, Void, Void> {

    private String message;
    private String email;

    public SendEmailAsyncTask(String message, String email) {
        this.message = message;
        this.email = email;
    }

    @Override
    protected Void doInBackground(Void... params) {
        GMailSender sender = new GMailSender("rpbafiatskovich@gmail.com", "!Q@w3e4r5");
        try {
            sender.sendMail("TransferPay code",
                    "Your auth code: " + message,
                    "rpbafiatskovich@gmail.com",
                    email);
         //   viewHelper.showToast(R.string.registration_aml_code_send_successfully, Toast.LENGTH_SHORT);
        } catch (Exception e) {
          //  viewHelper.showToast(R.string.registration_aml_code_send_failed, Toast.LENGTH_SHORT);
        }
        return null;
    }
}
