package com.udemy.selenium.decorator;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.udemy.selenium.decorator.enums.Role;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private SelenideElement roleSelect = $("#role");
    private ElementsCollection guestComponents = $$("div[class*='guest']");
    private ElementsCollection superUserComponents = $$("div[class*='superuser']");
    private ElementsCollection adminComponents = $$("div[class*='admin']");


    public void goTo() {
        Selenide.open("https://vins-udemy.s3.amazonaws.com/ds/decorator.html");
    }

    public void selectRole(Role role) {
        Select select = new Select(roleSelect);
        select.selectByValue(role.getName());
    }

    public ElementsCollection getGuestComponents() {
        return guestComponents;
    }

    public ElementsCollection getSuperUserComponents() {
        return superUserComponents;
    }

    public ElementsCollection getAdminComponents() {
        return adminComponents;
    }
}