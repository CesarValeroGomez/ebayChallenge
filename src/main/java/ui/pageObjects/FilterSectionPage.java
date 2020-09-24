package ui.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilterSectionPage extends BasePage {

    @FindBy(xpath = "//h2[contains(text(),'All Listings')]")
    protected WebElement allListingsLabel;
    @FindBy(xpath = "//h3[contains(.,'Price')]")
    protected WebElement priceLabel;
    @FindBy(xpath = "//div[3]/div/div/div/input")
    protected WebElement priceMin;
    @FindBy(xpath = "//div[2]/div/input")
    protected WebElement priceMax;
    @FindBy(css = ".btn--states > span")
    protected WebElement priceButton;

    protected WebElement filerLocator;
    protected WebElement optionLocator;

    public FilterSectionPage(WebDriver driver) {
        super( driver );
        PageFactory.initElements(driver,this);
    }

    public void filterByPrice(String minPrice, String maxPrice) {
        waitForElementToBeLoaded(allListingsLabel);
        priceLabel.click();
        priceMin.sendKeys(minPrice);
        priceMax.sendKeys(maxPrice);
        priceMax.sendKeys(Keys.ENTER);

        waitForElementToBeLoaded(allListingsLabel);
    }

    public void filterByDecision(String filter, String option) {

        waitForElementToBeLoaded(allListingsLabel);
        filerLocator = driver.findElement(By.xpath(String.format("//h3[starts-with(.,'%s')]",filter)));
        optionLocator = driver.findElement(By.xpath(String.format("//input[@aria-label='%s']",option)));

        if(!optionLocator.isEnabled()) {
            filerLocator.click();
        }
        optionLocator.click();
    }
}
