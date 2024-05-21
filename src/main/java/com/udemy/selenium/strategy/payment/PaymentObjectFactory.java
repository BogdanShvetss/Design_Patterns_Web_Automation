package com.udemy.selenium.strategy.payment;

import com.udemy.selenium.strategy.payment.enums.PaymentType;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PaymentObjectFactory {
    private static final Supplier<PaymentOption> CC = () -> new CreditCard();
    private static final Supplier<PaymentOption> NB = () -> new NetBanking();

    private static final Map<PaymentType, Supplier<PaymentOption>> MAP = new HashMap<>();

    static {
        MAP.put(PaymentType.CC, CC);
        MAP.put(PaymentType.NET_BANKING, NB);
    }

    public static PaymentOption getPaymentOption(PaymentType paymentType) {
        return MAP.get(paymentType).get();
    }
}