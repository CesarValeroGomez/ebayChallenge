package uiTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import ui.pageObjects.FilterSectionPage;
import ui.pageObjects.MainPage;
import ui.pageObjects.SearchResultPage;

public abstract class BaseTest {

    private String url = "https://www.ebay.com/";
    protected WebDriver driver;
    protected MainPage mainPage;
    protected FilterSectionPage filterSectionPage;
    protected SearchResultPage searchResultPage;

    @BeforeClass
    public void beforeClass() {
        mainPage = new MainPage(driver);
        driver = mainPage.browserDriverConnection("CHROME"); //Could be: CHROME, FIREFOX, IE
        mainPage.visit(url);
    }

    @BeforeMethod
    public void setEnglish() throws InterruptedException {
        mainPage.setToEnglish();
      //  Assert.assertEquals(mainPage.setToEnglish(),"English");
    }


    @AfterMethod
    public void afterMethod() {
        System.out.println("After the Method Test Search Producto");
    }

    @AfterClass
    public void afterClass() {
        driver.close();
        driver.quit();
    }
}
