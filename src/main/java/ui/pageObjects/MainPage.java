package ui.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    @FindBy(css = "span.gh-eb-Geo-txt")
    protected WebElement languageLocator;
    @FindBy(xpath = "//span[contains(.,'English')]")
    protected WebElement englishSelect;


    @FindBy(id = "gh-ac")
    protected WebElement homePageSearchBox;
    @FindBy(id = "gh-btn")
    protected WebElement homePageSearchButton;


    public MainPage(WebDriver driver) {
        super( driver );
        //PageFactory.initElements(driver,this);
    }

    public void setToEnglish() throws InterruptedException {

        waitForElementToBeLoaded(languageLocator);
        if (!(languageLocator.getText()).equals("English")) {
            languageLocator.click();
            englishSelect.click();
        }
        Thread.sleep( 7000 );
     //   return languageLocator.getText();
    }

    public void searchItem(String item) {
        waitForElementToBeLoaded(homePageSearchBox);
        homePageSearchBox.click();
        homePageSearchBox.sendKeys(item);
        homePageSearchButton.click();
    }
}
