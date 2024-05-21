package com.udemy.selenium.test.decorator;

import com.codeborne.selenide.ElementsCollection;
import com.udemy.selenium.decorator.DashboardPage;
import com.udemy.selenium.decorator.enums.Role;
import org.testng.Assert;

import java.util.function.Consumer;

public class Decorators {
    private static void shouldDisplay(ElementsCollection elements) {
        elements.forEach(e -> Assert.assertTrue(e.isDisplayed()));
    }

    private static void shouldNotDisplay(ElementsCollection elements) {
        elements.forEach(e -> Assert.assertFalse(e.isDisplayed()));
    }

    private static final Consumer<DashboardPage> adminComponentPresent = (dp) -> shouldDisplay(dp.getAdminComponents());
    private static final Consumer<DashboardPage> adminComponentNotPresent = (dp) -> shouldNotDisplay(dp.getAdminComponents());
    private static final Consumer<DashboardPage> superUserComponentPresent = (dp) -> shouldDisplay(dp.getSuperUserComponents());
    private static final Consumer<DashboardPage> superUserComponentNotPresent = (dp) -> shouldNotDisplay(dp.getSuperUserComponents());
    private static final Consumer<DashboardPage> guestComponentPresent = (dp) -> shouldDisplay(dp.getGuestComponents());
    private static final Consumer<DashboardPage> guestComponentNotPresent = (dp) -> shouldNotDisplay(dp.getGuestComponents());

    private static final Consumer<DashboardPage> adminSelection = (dp) -> dp.selectRole(Role.ADMIN);
    private static final Consumer<DashboardPage> superUserSelection = (dp) -> dp.selectRole(Role.SUPER_USER);
    private static final Consumer<DashboardPage> guestSelection = (dp) -> dp.selectRole(Role.GUEST);

    public static final Consumer<DashboardPage> guestPage = guestSelection
            .andThen(guestComponentPresent)
            .andThen(superUserComponentNotPresent)
            .andThen(adminComponentNotPresent);

    public static final Consumer<DashboardPage> superUserPage = superUserSelection
            .andThen(guestComponentPresent)
            .andThen(superUserComponentPresent)
            .andThen(adminComponentNotPresent);

    public static final Consumer<DashboardPage> adminUserPage = adminSelection
            .andThen(guestComponentPresent)
            .andThen(superUserComponentPresent)
            .andThen(adminComponentPresent);
}