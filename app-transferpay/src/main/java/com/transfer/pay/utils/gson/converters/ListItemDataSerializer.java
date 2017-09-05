package com.transfer.pay.utils.gson.converters;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.transfer.pay.models.BankAccountModel;
import com.transfer.pay.models.CreditCardModel;
import com.transfer.pay.ui.list.ListItemData;
import com.transfer.pay.ui.list.ListItemType;

import java.lang.reflect.Type;

/**
 * Created by e.fetskovich on 6/15/17.
 */

public class ListItemDataSerializer implements JsonDeserializer<ListItemData> {

    // Because if observable field is empty, it's returns {} value.
    private String isNull = "{}";

    @Override
    public ListItemData deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject listItemDataJson = json.getAsJsonObject();
        ListItemType listItemType = ListItemType.valueOf(listItemDataJson.get("type").getAsString());
        JsonObject data = listItemDataJson.getAsJsonObject("data");

        ListItemData listItemData = new ListItemData();
        listItemData.setType(listItemType);

        if (listItemType == ListItemType.BENEFICIARY_BANK_ACCOUNT) {
            listItemData.setData(deserializeBankAccountModel(data));
        } else if (listItemType == ListItemType.BENEFICIARY_CREDIT_CARD) {
            listItemData.setData(deserializeCreditCardModel(data));
        }

        return listItemData;
    }

    private BankAccountModel deserializeBankAccountModel(JsonObject data) {
        BankAccountModel model = new BankAccountModel();

        model.accountNo.set(convertTypeToString(data.getAsJsonObject("accountNo")));
        model.chooseBank.set(convertTypeToString(data.getAsJsonObject("chooseBank")));
        model.country.set(convertTypeToString(data.getAsJsonObject("country")));
        model.name.set(convertTypeToString(data.getAsJsonObject("name")));
        return model;
    }

    private CreditCardModel deserializeCreditCardModel(JsonObject data) {
        CreditCardModel creditCardModel = new CreditCardModel();

        creditCardModel.creditCardNumber.set(convertTypeToString(data.getAsJsonObject("creditCardNumber")));
        creditCardModel.cardHolderName.set(convertTypeToString(data.getAsJsonObject("cardHolderName")));
        creditCardModel.CVV.set(convertTypeToString(data.getAsJsonObject("CVV")));
        creditCardModel.validDate.set(convertTypeToString(data.getAsJsonObject("validDate")));
        creditCardModel.cardType.set(convertTypeToString(data.getAsJsonObject("cardType")));

        return creditCardModel;
    }

    private String convertTypeToString(JsonObject observableField) {
        String text = observableField.toString();
        if (!text.equals(isNull)) {
            return observableField.get("mValue").getAsString();
        } else {
            return null;
        }
    }

}
