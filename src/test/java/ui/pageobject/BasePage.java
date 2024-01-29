package ui.pageobject;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class BasePage {

    protected WebDriver driver;
    private final int timeout = 30;

    public void waitForVisibility(WebElement webElement) {
        waitForCondition(ExpectedConditions.visibilityOf(webElement), timeout);
    }

    public void waitForElementClickable(WebElement webElement) {
        waitForCondition(ExpectedConditions.elementToBeClickable(webElement), timeout);
    }

    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };
        waitForConditionBoolean(jsLoad, timeout);
    }

    public void takeScreenshot() {
        String fileName = "Screenshot";
        try {
            synchronized (driver) {
                fileName += "_" + new SimpleDateFormat("yyyyMMddhhmmssSSS").format(new Date());
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenshot, new File("screenshots/" + fileName + ".png"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void waitForCondition(ExpectedCondition<WebElement> condition, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(condition);
    }

    private boolean waitForConditionBoolean(ExpectedCondition<Boolean> condition, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(condition);
    }
}
