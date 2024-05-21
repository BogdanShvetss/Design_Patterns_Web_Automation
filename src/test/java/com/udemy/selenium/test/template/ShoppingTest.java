package com.udemy.selenium.test.template;

import com.udemy.selenium.template.AmazonShopping;
import com.udemy.selenium.template.EBayShopping;
import com.udemy.selenium.template.ShoppingTemplate;
import com.udemy.selenium.template.enums.Product;
import com.udemy.selenium.test.base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;

public class ShoppingTest extends BaseTest {
    @Test(dataProvider = "getData")
    public void shoppingTest(ShoppingTemplate shoppingTemplate) {
        shoppingTemplate.shop();
    }

    @DataProvider(name = "getData")
    public Iterator<Object[]> getData() {
        return Arrays.asList(
                        new AmazonShopping(Product.WATCH.getName()),
                        new EBayShopping(Product.WATCH.getName())
                ).stream()
                .map(p -> new Object[]{p})
                .iterator();
    }
}