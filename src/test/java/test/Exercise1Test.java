package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.pageobject.google.GoogleResultsPage;
import ui.pageobject.google.GoogleSearchPage;
import ui.pageobject.wikipedia.WikipediaPage;
import ui.utils.BrowserType;
import ui.utils.DriverFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class Exercise1Test {

    //Driver
    protected WebDriver driver;

    //Pages
    private GoogleSearchPage googleSearchPage;
    private GoogleResultsPage googleResultsPage;
    private WikipediaPage wikipediaPage;

    //Test data
    private static final String SEARCH_TEXT = "automation";
    //We suppose our browser is in Spanish language
    private static final String LAUNCH_DATE = " 12 de marzo de 2015 ";

    @BeforeMethod
    public void setUp() {
        // Change BrowserType to execute in different browsers
        driver = DriverFactory.getDriver(BrowserType.FIREFOX);
        googleSearchPage = new GoogleSearchPage(driver);
        googleResultsPage = new GoogleResultsPage(driver);
        wikipediaPage = new WikipediaPage(driver);
    }

    @Test
    public void navigateToWikipediaWithScreenshot() {
        googleSearchPage.navigateToGoogleSearchPage();
        googleSearchPage.clickAcceptCookies();
        googleSearchPage.setTextToSearch(SEARCH_TEXT);
        googleSearchPage.clickSearch();
        // Searching for 'automation' shows a videogame as wikipedia result
        googleResultsPage.clickWikipediaLink();
        // Check the launch date
        assertThat(wikipediaPage.getLaunchDate(), containsString(LAUNCH_DATE));
        wikipediaPage.takeScreenshot();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
