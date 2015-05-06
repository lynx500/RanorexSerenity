package com.ranorex.features;

import com.ranorex.steps.EndUserSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.Collection;

@RunWith(SerenityParameterizedRunner.class)
@Concurrent
public class RanorexMainPageStory {

    @Managed
    public WebDriver webDriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public EndUserSteps endUserSteps;

    public RanorexMainPageStory(String fname, String lname, String gender) {
        this.fname = fname;
        this.lname = lname;
        this.gender = gender;
    }

    @TestData
    public static Collection<Object[]> testData(){
        return Arrays.asList(new Object[][]{
                {"Nika", "Renaud", "female"},
                {"36563", "#$%^&*", "male"}
        });
    }

    private final String fname;
    private final String lname;
    private final String gender;

    @Test
    public void userCanAddPersonToRanorex() {
        endUserSteps.openHomePage();
        endUserSteps.setCategory("Music");
        endUserSteps.addUser(fname, lname, gender);
        endUserSteps.shouldChangeVipCount("VIP count: 1");
        endUserSteps.shouldAddRowInTheUserTable(fname);
    }

    @Test
    public void userCanDeleteUser() {
        endUserSteps.openHomePage();
        endUserSteps.addUser(fname, lname, gender);
        endUserSteps.clickDelete();
        endUserSteps.shouldChangeVipCount("VIP count: 0");
    }

    @Test
    public void userCanClearDatabase() {
        endUserSteps.openHomePage();
        endUserSteps.addUser(fname, lname, gender);
        endUserSteps.addUser(fname, lname, gender);
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
