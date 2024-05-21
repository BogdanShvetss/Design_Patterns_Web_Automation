package com.udemy.selenium.test.strategy;


import com.udemy.selenium.strategy.payment.PaymentObjectFactory;
import com.udemy.selenium.strategy.payment.PaymentOption;
import com.udemy.selenium.strategy.payment.PaymentScreen;
import com.udemy.selenium.strategy.payment.enums.PaymentType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class PaymentScreenTest {
    private PaymentScreen paymentScreen;

    @BeforeTest
    public void setPaymentScreen() {
        this.paymentScreen = new PaymentScreen();
    }

    @Test(dataProvider = "getData")
    public void paymentTest(PaymentType paymentType, Map<String, String> paymentDetails) throws Exception {
        this.paymentScreen.goTo();
        this.paymentScreen.getUserInformation().enterDetails("Bohdan", "Shvets", "email@gmail.com");

        PaymentOption paymentOption = PaymentObjectFactory.getPaymentOption(paymentType);

        this.paymentScreen.setPaymentOption(paymentOption);
        this.paymentScreen.pay(paymentDetails);
        String orderNumber = this.paymentScreen.getOrder().placeOrder();
        System.out.println(orderNumber);
    }

    @DataProvider(name = "getData")
    public Object[][] getData() {
        Map<String, String> creditCardInfo = Map.of("cc", "123", "year", "2025", "cvv", "522");
        Map<String, String> netBankingInfo = Map.of("bank", "BOFA", "accountNumber", "1", "pin", "1111");

        Object[][] data = new Object[][]{
                {PaymentType.CC, creditCardInfo},
                {PaymentType.NET_BANKING, netBankingInfo}
        };

        return data;
    }
}