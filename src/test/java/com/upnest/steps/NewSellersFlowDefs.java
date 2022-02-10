package com.upnest.steps;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.upnest.utils.PageHelper;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class NewSellersFlowDefs extends PageHelper {
    private ElementsCollection getPriceLink() {
        return $$x(".//div[contains(@class,'choice-button')]");
    }
    private SelenideElement getHowSoonToSellLink(String text) {
        return $x(".//span[text()='" + text + "']");
    }

    @When("Into New Seller Flow step: How much do you think your home will sell for, choose {string}")
    public void choosePriceOfHome(String price) {
        if (price.equalsIgnoreCase("Max price")) {
            clickButton(getPriceLink().get(getPriceLink().size() - 1));
        } else if (price.equalsIgnoreCase("Min price")) {
            clickButton(getPriceLink().get(0));
        } else {
            clickButton(getPriceLink().get(rnd(1, getPriceLink().size() - 2)));
        }

    }

    @When("Into New Seller Flow step: How soon are you looking to sell, choose {string}")
    public void chooseHowSoonToSell(String text) {
        clickButton(getHowSoonToSellLink(text));
    }

    public static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
