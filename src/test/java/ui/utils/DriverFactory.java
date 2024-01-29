package ui.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    public static WebDriver getDriver(BrowserType browserType) {
        switch (browserType) {
            case FIREFOX:
                return new FirefoxDriver();
            case SAFARI:
                return new SafariDriver();
            default:
                return new ChromeDriver();
        }
    }
}