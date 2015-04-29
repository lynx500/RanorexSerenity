package com.ranorex.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DefaultUrl("http://ranorex.com/web-testing-examples/vip/")
public class RanorexMainPage extends PageObject {

    @FindBy(id = "FirstName")
    private WebElementFacade fieldFirstName;

    @FindBy(id = "LastName")
    private WebElementFacade fieldLastName;

    @FindBy(id = "Add")
    private WebElementFacade btnAdd;

    @FindBy(id = "Delete")
    private WebElementFacade btnDelete;

    @FindBy(id = "count")
    private WebElementFacade vipCount;

    @FindBy(id = "Gender")
    private List<WebElementFacade> gender;

    @FindBy(id = "Clear")
    private WebElementFacade btnClear;

    @FindBy(id = "connect")
    private WebElementFacade btnDisconnect;

    public void setFirstName(String firstName) {
        fieldFirstName.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        fieldLastName.sendKeys(lastName);
    }

    public String getVipCount() {
        return vipCount.getText();
    }

    public void clickAdd() {
        btnAdd.click();
    }

    public void clickDelete() {
        btnDelete.click();
    }

    public void clickClear() {
        btnClear.click();
    }
}