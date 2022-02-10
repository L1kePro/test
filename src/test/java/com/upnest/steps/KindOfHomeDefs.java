package com.upnest.steps;

import com.codeborne.selenide.SelenideElement;
import com.upnest.utils.PageHelper;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.$x;

public class KindOfHomeDefs extends PageHelper {
    private SelenideElement getKindOfHomeLink(String text) {
        return $x(".//span[text()='" + text + "']");
    }

    @When("Into New Seller Flow step: What kind of home are you looking to sell, choose {string}")
    public void chooseKindOfHome(String text) {
        clickButton(getKindOfHomeLink(text));
    }
}
