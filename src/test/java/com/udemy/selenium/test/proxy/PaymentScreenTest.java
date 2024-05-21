package com.udemy.selenium.test.proxy;


import com.udemy.selenium.proxy.PaymentObjectFactory;
import com.udemy.selenium.proxy.PaymentOption;
import com.udemy.selenium.proxy.PaymentScreen;
import com.udemy.selenium.proxy.enums.PaymentType;
import com.udemy.selenium.test.base.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class PaymentScreenTest extends BaseTest {
    private PaymentScreen paymentScreen;

    @BeforeTest
    public void setPaymentScreen() {
        System.setProperty("env", "PROD"); //IT CAN BE PASSED FROM A PIPELINE
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