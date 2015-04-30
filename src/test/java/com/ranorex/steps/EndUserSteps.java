package com.ranorex.steps;

import com.ranorex.pages.RanorexMainPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.yecht.Data;

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
    public void setGender(String gender) {
        ranorexMainPage.setGender(gender);
    }

    @Step
    public void openHomePage() {
        ranorexMainPage.open();
    }

    @Step
    public void clickAdd() {
        ranorexMainPage.clickAdd();
    }

    @Step
    public void clickDelete() {
        ranorexMainPage.clickDelete();
    }

    @Step
    public void clickClear() {
        ranorexMainPage.clickClear();
    }

    @Step
    public void clickDisconnect() {
        ranorexMainPage.clickDisconnect();
    }

    @Step
    public void shouldChangeVipCount(String vipCount) {
        assertEquals(vipCount, ranorexMainPage.getVipCount());
    }

    @Step
    public void shouldAddRowInTheUserTable(String firstName) {
        assertEquals(firstName, ranorexMainPage.getFirstNameFromTheTable());
    }

    @Step
    public void shouldCheckTextOnDisconectButton(String text) {
        assertEquals(text, ranorexMainPage.getTextConnectButton());
    }

    @Step
    public void addUser(String firstName, String lastName, String gender) {
        setFirstName(firstName);
        setLastName(lastName);
        setGender(gender);
        clickAdd();
    }


}
