package com.upnest.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import java.util.function.Supplier;

public enum Platform {

    CHROME_DESKTOP(DesiredCapabilities::chrome, "Windows 10", "chrome","1920x1080"),
    CHROME_MOBILE(DesiredCapabilities::chrome, "Android", AndroidDriver.class.getName(), null) {
        @Override
        public MutableCapabilities getCapabilities() {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", os);
            capabilities.setCapability("platformVersion", "9");
            capabilities.setCapability("deviceName", "Galaxy S10");
            return capabilities;
        }
    },
    SAFARI_DESKTOP(DesiredCapabilities::safari, "MacOS Big sur", "safari", "1920x1080"),
    SAFARI_MOBILE(DesiredCapabilities::safari, "iOS 12", SafariDriver.class.getName(), null) {
        @Override
        public MutableCapabilities getCapabilities() {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability("deviceName", "iPhone 12");
            capabilities.setCapability("platformVersion","14.2");
            return capabilities;
        }
    },
    EDGE_DESKTOP(DesiredCapabilities::edge,  "Windows 10",  "edge", "1920x1080");

    protected final Supplier<MutableCapabilities> capabilitiesSupplier;
    protected final String os;
    protected final String browser;
    protected final String resolution;

    Platform(Supplier<MutableCapabilities> capabilitiesSupplier, String os, String browser, String resolution) {
        this.capabilitiesSupplier = capabilitiesSupplier;
        this.os = os;
        this.browser = browser;
        this.resolution = resolution;
    }

    public MutableCapabilities getCapabilities() {
        MutableCapabilities capabilities = capabilitiesSupplier.get();
        capabilities.setCapability("resolution", resolution);
        capabilities.setCapability("platform", os);
        return capabilities;
    }

    public String getBrowser() {
        return browser;
    }
}
