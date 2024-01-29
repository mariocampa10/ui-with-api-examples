package ui.pageobject.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.pageobject.BasePage;

public class GoogleResultsPage extends BasePage {

    @FindBy(xpath = "//a[@class='ruhjFe NJLBac fl']//span[text() = 'Wikipedia']")
    private WebElement linkWikipedia;

    public GoogleResultsPage(WebDriver driver) {
        super.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickWikipediaLink() {
        waitForPageLoaded();
        waitForElementClickable(linkWikipedia);
        linkWikipedia.click();
    }
}
