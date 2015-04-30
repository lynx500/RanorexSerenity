package com.ranorex.features;

import com.ranorex.steps.EndUserSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class RanorexMainPageStory {

    @Managed
    public WebDriver webDriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public EndUserSteps endUserSteps;

    @Test
    public void userCanAddPersonToRanorex() {
        endUserSteps.openHomePage();
        endUserSteps.addUser("Nika", "Renaud", "female");
        endUserSteps.shouldChangeVipCount("VIP count: 1");
        endUserSteps.shouldAddRowInTheUserTable("Nika");
    }

    @Test
    public void userCanDeleteUser() {
        endUserSteps.openHomePage();
        endUserSteps.addUser("4556", "$%^&*", "male");
        endUserSteps.clickDelete();
        endUserSteps.shouldChangeVipCount("VIP count: 0");
    }

    @Test
    public void userCanClearDatabase() {
        endUserSteps.openHomePage();
        endUserSteps.addUser("4556", "$%^&*", "female");
        endUserSteps.addUser("Nika", "Renaud", "male");
        endUserSteps.clickClear();
        endUserSteps.shouldChangeVipCount("VIP count: 0");
    }

    @Test
    public void userCanDisconnectDatabase() {
        endUserSteps.openHomePage();
        endUserSteps.clickDisconnect();
        endUserSteps.shouldCheckTextOnDisconectButton("Connect...");
    }
}
