package com.upnest.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.function.Supplier;

import static com.codeborne.selenide.Selenide.open;

public interface GlobalConfig {

    String BASE_URL = System.getProperty("upnest.base.url", "https://staging.upnest.com");

    Platform REMOTE_PLATFORM = Platform.valueOf(System.getProperty("upnest.selenium.platform", Platform.CHROME_DESKTOP.toString()));

    String BUILD = System.getProperty("upnest.selenium.build",
            ((Supplier<String>) (() -> {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm");
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("PST"));
                return "Build " + simpleDateFormat.format(new Date()) + " for " + REMOTE_PLATFORM;
            })).get());

//    boolean IS_REMOTE = Boolean.valueOf(System.getProperty("upnest.selenium.remote", "false"));
    boolean IS_REMOTE = Boolean.valueOf(System.getProperty("upnest.selenium.remote", "true"));

    static void signInByUrl(String email, String password) {
        open(BASE_URL + "/re/loginuser?email=" + email + "&passwd=" + password);
    }

    String REMOTE_USER = System.getProperty("upnest.selenium.remote.user", "aleksei");

    String REMOTE_ACCESS_KEY = System.getProperty("upnest.selenium.remote.accessKey", "R9ayB9jMcp7boadrtO1ZREz7puoQQPq1tLeIgROpSWgAnPNxCa");

    String AGENT_EMAIL = "agentdemo6@gmail.com";

    String PASSWORD = "lessthan6";

    String ADVISOR_EMAIL = "jon@upnest.com";
}
