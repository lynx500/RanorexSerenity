package com.ranorex.steps;

import com.ranorex.pages.RanorexMainPage;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class EndUserSteps extends ScenarioSteps {

    RanorexMainPage ranorexMainPage;

    @Step
    public void setFirstName(String firstName) {
        ranorexMainPage.setFirstName(firstName);
    }

    @Step
    public void setLastName(String lastName) {
        ranorexMainPage.setLastName(lastName);
    }

    @Step
    public void isHomePage() {
        ranorexMainPage.open();
    }

    @Step
    public void clickAdd() {
        ranorexMainPage.clickAdd();
    }

    @Step
    public void shouldChangeVipCount(String message, String vipCount) {
        assertEquals(message, vipCount, ranorexMainPage.getVipCount());
    }

    @Step
    public void addUser(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
        clickAdd();
    }


}
