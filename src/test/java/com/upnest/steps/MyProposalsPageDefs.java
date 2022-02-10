package com.upnest.steps;

import com.codeborne.selenide.Condition;
import com.upnest.utils.PageHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static junit.framework.TestCase.assertTrue;

public class MyProposalsPageDefs {
    private final By buttonSkipForNow = By.xpath(".//button[text()='Skip for now']");
    private final By agentName = By.xpath(".//div[contains(@class, 'agent-name')]");

    @When("Click Skip for now")
    public void clickSkipForNow() {
        PageHelper.waitForPageComplete();
        PageHelper.waitForJQuery();
        $(buttonSkipForNow).shouldBe(Condition.enabled, Duration.ofSeconds(30)).click();
    }

    @Then("Check than we have more {string} agent for new customer")
    public void checkThanWeHaveMoreAgentForNewCustomer(String num) {
        assertTrue($$(agentName).size() > Integer.parseInt(num));
    }
}
