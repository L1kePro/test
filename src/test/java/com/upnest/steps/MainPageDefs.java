package com.upnest.steps;

import com.codeborne.selenide.SelenideElement;
import com.upnest.utils.PageHelper;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPageDefs extends PageHelper {
    private final By howItWorksLink = By.xpath(".//ul[contains(@class, 'nav navbar-nav hidden-xs')]/li[1]/a");
    private final By mobileHowItWorksLink = By.xpath(".//ul[contains(@class, 'nav sidebar-nav')]/li[1]/a");
    private final By agentSignupLink = By.xpath(".//ul[contains(@class, 'nav navbar-nav hidden-xs')]/li[2]/a");
    private final By mobileAgentSignupLink = By.xpath(".//ul[contains(@class, 'nav sidebar-nav')]/li[2]/a");
    private final By logInButton = By.xpath(".//ul[contains(@class, 'nav navbar-nav hidden-xs')]//a[contains(@class, 'login-button')]");
    private final By mobileNavbarButton = By.xpath(".//nav[contains(@class, 'navbar')]//amp-img");
    private final By mobileLogInButton = By.xpath(".//ul[contains(@class, 'nav sidebar-nav')]//a[contains(@class, 'login-button')]");
    private final By inputCompareLocationSell = By.id("buysellHeroFormLocation");
    private final By inputCompareLocationBuy = By.id("buysellHeroFormLocationBuy");
    private SelenideElement newUserRoleTab(String role) {
        return $x(".//div[text()='" + role + "']");
    }

    public void openMobileDropMenu() {
        if ($(mobileNavbarButton).isDisplayed()) {
            $(mobileNavbarButton).click();
        }
    }

    public void clickLoginButton() {
        clickMenuButton(logInButton, mobileLogInButton);
    }

    public void clickMenuButton(By desktopElement, By mobileElement) {
        if (isDesktopPlatform()) {
            $(desktopElement).click();
        } else {
            openMobileDropMenu();
            $(mobileElement).click();
        }
    }

    @When("Click Log in button")
    public void logIn() {
        clickLoginButton();
        }

    @When("Click {string} tab and input {string} into compare field")
    public void clickTabAndInputIntoCompareField(String role, String location) {
        clickButton(newUserRoleTab(role));
        if (role.equalsIgnoreCase("Buy")) {
            $(inputCompareLocationBuy).setValue(location).sendKeys(Keys.ENTER);
        } else {
            $(inputCompareLocationSell).setValue(location).sendKeys(Keys.ENTER);
        }
    }
}
