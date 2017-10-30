package com.transfer.pay.utils;

import com.transfer.pay.models.Currency;
import com.transfer.pay.models.Role;
import com.transfer.pay.ormlite.Dao.CurrencyDao;
import com.transfer.pay.ormlite.ORMLiteFactcory;

import java.sql.SQLException;

/**
 * @author e.fetskovich on 10/30/17.
 */

public class FirstStart {

    private FirstStart() {
        // do nothing
    }

    public static void firstStart() {
        generateSomeRoles();
        generateCurrencies();
    }

    public static void generateSomeRoles() {
        Role user = new Role();
        user.setName("user");
        Role admin = new Role();
        admin.setName("admin");

        try {
            ORMLiteFactcory.getHelper().getRolesDao().create(user);
            ORMLiteFactcory.getHelper().getRolesDao().create(admin);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void generateCurrencies() {
        Currency usd = new Currency();
        usd.setName("USD");
        usd.setFormatToUsd(1.0);
        Currency eur = new Currency();
        eur.setName("EUR");
        eur.setFormatToUsd(0.86);
        Currency blr = new Currency();
        blr.setName("BLR");
        blr.setFormatToUsd(1.96);

        try {
            CurrencyDao currencies = ORMLiteFactcory.getHelper().getCurrencyDao();
            currencies.create(usd);
            currencies.create(eur);
            currencies.create(blr);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
