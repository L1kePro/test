package com.upnest.utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Collections;

import static com.codeborne.selenide.Configuration.*;

public abstract class AbstractTests {

    @Rule
    public final TestWatcher testWatcher = new TestWatcher() {

        @Override
        protected void starting(Description description) {
            timeout = 12000;
            startMaximized = true;
//            browserSize = "412x869";
            screenshots = false;
            savePageSource = false;
            pageLoadStrategy = "eager";

            if (GlobalConfig.IS_REMOTE) {
                Configuration.remote = "https://hub.lambdatest.com/wd/hub";
            }

            MutableCapabilities capabilities = GlobalConfig.IS_REMOTE ?
                    GlobalConfig.REMOTE_PLATFORM.getCapabilities() :
                    DesiredCapabilities.chrome();
            capabilities.setCapability("build", GlobalConfig.BUILD);
            capabilities.setCapability("name", getDisplayName(description));

            if (GlobalConfig.IS_REMOTE) {
                capabilities.setCapability("user", GlobalConfig.REMOTE_USER);
                capabilities.setCapability("accessKey", GlobalConfig.REMOTE_ACCESS_KEY);
                Configuration.browser = GlobalConfig.REMOTE_PLATFORM.getBrowser();
                capabilities.setCapability("unexpectedAlertBehaviour","dismiss");
                capabilities.setCapability("autoAcceptAlerts",true);
            }

            Configuration.browserCapabilities = capabilities;
        }

        @Override
        protected void succeeded(Description description) {
            Selenide.closeWebDriver();
        }

        @Override
        protected void failed(Throwable e, Description description) {
            try {
                if (GlobalConfig.IS_REMOTE) {
                    Selenide.executeJavaScript("lambda-status=failed");
                    Selenide.executeJavaScript("lambda-exceptions", Collections.singletonList(e.getMessage()));
                }
            } finally {
                Selenide.closeWebDriver();
            }
        }
    };

    private String getDisplayName(Description description) {
        DisplayName annotation = description.getAnnotation(DisplayName.class);
        String testName = annotation != null ? annotation.value() : description.getMethodName();
        return description.getTestClass().getSimpleName() + ": " + testName;
    }
}
