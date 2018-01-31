package com.transfer.pay;

import com.cooltechworks.creditcarddesign.CreditCardUtils;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author e.fetskovich on 1/31/18.
 */

public class CreditCardTests {

    @Test
    public void checkOnCardLengthLimit(){
        int amexLengthLimit = CreditCardUtils.selectCardLength(CreditCardUtils.CardType.AMEX_CARD);
        assertEquals(amexLengthLimit, CreditCardUtils.MAX_LENGTH_CARD_NUMBER_AMEX);

        int masterCardLengthLimit = CreditCardUtils.selectCardLength(CreditCardUtils.CardType.MASTER_CARD);
        assertEquals(masterCardLengthLimit, CreditCardUtils.MAX_LENGTH_CARD_NUMBER);
    }

    @Test
    public void handleExpiration(){
      String expiration = CreditCardUtils.handleExpiration("2", "2003");
      assertNotNull(expiration);
    }

    @Test
    public void checkCardTypeTest(){
        String visaCardNumber = "4516203121234141";
        CreditCardUtils.CardType cardType = CreditCardUtils.selectCardType(visaCardNumber);
        assertEquals(cardType, CreditCardUtils.CardType.VISA_CARD);

        String masterCardNumber = "5612561256125612";
        CreditCardUtils.CardType cardType1 = CreditCardUtils.selectCardType(masterCardNumber);
        assertEquals(cardType1, CreditCardUtils.CardType.MASTER_CARD);
    }



}
