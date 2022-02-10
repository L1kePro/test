package com.upnest.utils;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Given;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.time.Duration.ofSeconds;

public class FunctionsForTests {
    private static String predefinedName = "";
    private static String predefinedEmail = "";

   public static String getRandomWord(int length) {
        String r = "";
        for(int i = 0; i < length; i++) {
            r += (char)(Math.random() * 26 + 97);
        }
        return r;
    }

    public int getRandomNumber() {
        int a = (int) (Math.random()*(1000000));
        if (String.valueOf(a).length() != 6) {
            a = (int) (Math.random()*(1000000));
        }
        return a;
    }

    public void checkPopUpAllowAll() {
//        if (GlobalConfig.IS_REMOTE) {
//            try {
//                $("#adroll_allow_all div").click();
//            } catch (ElementNotFound e) {
//                return;
//            }
//        }

    }

    public void checkPopUpSkipForNow() {
        if ($x(".//div[@class='modal-footer']/button").shouldBe(Condition.exist, ofSeconds(17)).isEnabled()) {
            $x(".//div[@class='modal-footer']/button").shouldBe(Condition.exist, ofSeconds(17)).click();
        }
    }

    public void getDoItLater() {
                $("[class='btn btn-transparent']").click();
        }

    public void clickBlockPopUpAlerts() {
        if ($("[class='pushcrew-chrome-style-notification-btn pushcrew-btn-close']").isDisplayed()) {
            $("[class='pushcrew-chrome-style-notification-btn pushcrew-btn-close']").shouldBe(enabled).click();
        }
    }

    public static String getRandomUserName() {
       return (getRandomWord(5) + " " + getRandomWord(4));
    }

    public static String getRandomEmail() {
       return (getRandomWord(5) + "@gmail.com");
    }

    public static String getPredefinedName() {
        return predefinedName;
    }

    public static void setPredefinedName() {
        predefinedName = getRandomUserName();
    }

    public static String getPredefinedEmail() {
        return predefinedEmail;
    }

    public static void setPredefinedEmail() {
        predefinedEmail = getRandomEmail();
    }

    //    //Verification code
//    getBlankElements().get(4).setValue(WebDriverRunner.getWebDriver().manage()
//                .getCookieNamed("agentVerificationCode").toString().substring(22,28));
}
