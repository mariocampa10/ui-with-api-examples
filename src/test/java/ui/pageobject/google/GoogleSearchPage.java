package ui.pageobject.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.data.Url;
import ui.pageobject.BasePage;

public class GoogleSearchPage extends BasePage {

    @FindBy(id = "APjFqb")
    private WebElement inputSearch;

    @FindBy(name = "btnK")
    private WebElement buttonSearch;

    @FindBy(id = "L2AGLb")
    private WebElement buttonAcceptCookies;

    public GoogleSearchPage(WebDriver driver) {
        super.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToGoogleSearchPage() {
        driver.get(Url.UI_BASE_URL);
    }

    public void setTextToSearch(String text) {
        waitForVisibility(inputSearch);
        inputSearch.sendKeys(text);
    }

    public void clickAcceptCookies() {
        waitForPageLoaded();
        waitForElementClickable(buttonAcceptCookies);
        buttonAcceptCookies.click();
    }

    public void clickSearch() {
        waitForElementClickable(buttonSearch);
        buttonSearch.click();
    }
}
