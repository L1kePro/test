package com.upnest.steps;

import com.upnest.utils.AbstractTests;
import com.upnest.utils.GlobalConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.codeborne.selenide.Selenide.*;

public class Hooks extends AbstractTests {
    @Before
    public void openUrl() {
        open(GlobalConfig.BASE_URL);
    }

    @After
    public static void closeDriver() {
        closeWebDriver();
    }
}
