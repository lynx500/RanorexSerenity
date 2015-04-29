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
public class AddUserStory {

    @Managed
    public WebDriver webDriver;

    @ManagedPages(defaultUrl = "http://ranorex.com/web-testing-examples/vip/")
    public Pages pages;

    @Steps
    public EndUserSteps endUserSteps;

    @Test
    public void canAddUser() {
        endUserSteps.isHomePage();
        endUserSteps.addUser("sdfdsf", "sfsdf");
        endUserSteps.shouldChangeVipCount("Vip count after addition return incorrect value!", "VIP count: 1");
    }

}
