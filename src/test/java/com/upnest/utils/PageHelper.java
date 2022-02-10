package com.upnest.utils;

import com.codeborne.selenide.SelenideElement;
import com.google.common.base.Stopwatch;
import org.apache.hc.core5.util.Timeout;

import java.util.concurrent.TimeUnit;
import java.util.function.BooleanSupplier;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PageHelper {
    private static Platform RP = GlobalConfig.REMOTE_PLATFORM;

    public static boolean isDesktopPlatform() {
        return (RP.name().equalsIgnoreCase("CHROME_DESKTOP"));
    }

    public static void delay(final int timeOutInMs) {
        try {
            Thread.sleep(timeOutInMs);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    }

    public static boolean waitUntil(final BooleanSupplier condition, final int waitTimeOutMs,
                                    final int waitIntervalMs) {
        final Stopwatch waitTimer = Stopwatch.createStarted();
        while (waitTimer.elapsed(TimeUnit.MILLISECONDS) < waitTimeOutMs) {
            delay(waitIntervalMs);
            if (condition.getAsBoolean()) {
                waitTimer.stop();
                return true;
            }
        }
        waitTimer.stop();
        return false;
    }

    public static void waitForPageComplete() {
        waitUntil(() -> "complete".equals(executeJavaScript("return document.readyState")), 5000, 200);
    }

    public static void waitForJQuery() {
        if (executeJavaScript("return 'undefined' !== typeof window.jQuery")) {
            waitUntil(() -> executeJavaScript("return jQuery.active == 0"), 5000, 200);
        }
    }

    public static void clickButton(SelenideElement element) {
        waitForPageComplete();
        waitForJQuery();
        if (element.isDisplayed()) {
            element.click();
        }
    }
}
