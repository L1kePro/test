package com.upnest.steps;

import com.codeborne.selenide.commands.WaitUntil;
import com.upnest.utils.FunctionsForTests;
import com.upnest.utils.PageHelper;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPageDefs extends PageHelper {
    private final By getStartedLink = By.xpath(".//a[@href='register']");
    private final By inputName = By.id("name");
    private final By inputPropertyAddress = By.id("address");
    private final By continueButtonFromMainPage = By.xpath(".//input[@value='CONTINUE']");
    private final By continueButtonFromFlow = By.xpath(".//button[text()='Continue']");
    private final By inputEmail = By.id("email");
    private final By inputPhone = By.id("phone");

    public void clickStartedLink() {
        clickButton($(getStartedLink));
    }

    public void setNewUserName(String name) {
        if ($(inputName).isDisplayed()) {
            $(inputName).setValue(name);
        }
    }

    public void setPropertyAddress(String address) {
        if ($(inputPropertyAddress).isDisplayed()) {
            $(inputPropertyAddress).setValue(address);
        }
    }

    public void clickContinueButton() {
        if ($(continueButtonFromMainPage).isDisplayed()) {
            $(continueButtonFromMainPage).click();
        } else if ($(continueButtonFromFlow).isDisplayed()) {
            $(continueButtonFromFlow).click();
        }
    }

    public void setEmail(String email) {
        if ($(inputEmail).isDisplayed()) {
            $(inputEmail).setValue(email);
        }
    }

    public void setPhone(String phone) {
        if ($(inputPhone).isDisplayed()) {
            $(inputPhone).setValue(phone);
        }
    }

    @When("Get Started")
    public void getStarted() {
        clickStartedLink();
    }

    @When("Enter predefined USER NAME and {string}")
    public void enteredData(String address) {
        setPropertyAddress(address);
        setNewUserName(FunctionsForTests.getPredefinedName());
    }

    @When("Enter predefined EMAIL")
    public void inputPredefinedEmail() {
        PageHelper.waitForPageComplete();
        PageHelper.waitForJQuery();
        setEmail(FunctionsForTests.getPredefinedEmail());
    }

    @When("Click continue")
    public void clickContinue() {
        clickContinueButton();
    }

    @When("Enter phone {string}")
    public void enterPhone(String phone) {
        PageHelper.waitForJQuery();
        setPhone(phone);
    }
}
