package com.upnest.steps;

import com.upnest.utils.FunctionsForTests;
import com.upnest.utils.GlobalConfig;
import io.cucumber.java.en.Given;

public class PredefineDefs {
    @Given("Predefine USER NAME, EMAIL, PASSWORD, PHONE")
    public void predefinedData() {
        FunctionsForTests.setPredefinedName();
        FunctionsForTests.setPredefinedEmail();
        final String PHONE = "(999) 322-2332";
        final String PASSWORD = GlobalConfig.PASSWORD;
    }
}
