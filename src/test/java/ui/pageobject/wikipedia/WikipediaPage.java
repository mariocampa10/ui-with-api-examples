package ui.pageobject.wikipedia;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.pageobject.BasePage;

public class WikipediaPage extends BasePage {

    @FindBy(xpath = "//tr[19]//li")
    private WebElement labelLaunchDate;

    public WikipediaPage(WebDriver driver) {
        super.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getLaunchDate() {
        waitForVisibility(labelLaunchDate);
        return labelLaunchDate.getText();
    }
}
