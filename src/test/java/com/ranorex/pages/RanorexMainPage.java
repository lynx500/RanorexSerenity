package com.ranorex.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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

    @FindBy(xpath = "//table[@id='VIPs']/tbody/tr[2]/td[2]")
    private WebElementFacade rowFirstNameInTheTable;

    @FindBy(id = "Category")
    private WebElementFacade category;

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

    public String getFirstNameFromTheTable() {
        return rowFirstNameInTheTable.getText();
    }

    public String getTextConnectButton() {
        return btnDisconnect.getAttribute("value");
    }

    public void clickDelete() {
        btnDelete.click();
    }

    public void clickClear() {
        btnClear.click();
    }

    public void clickDisconnect() {
        btnDisconnect.click();
    }

    public void setGender(String strGender) {
        for (WebElementFacade el : gender) {
            if (el.getAttribute("value").equals(strGender)) {
                el.click();
            }
        }
    }

    public void setCategory(String strCategory) {
        Select cat = new Select(category);
        cat.selectByVisibleText(strCategory);
    }
}
