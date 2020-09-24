package ui.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//h2[contains(text(),'All Listings')]")
    protected WebElement allListingsLabel;
    @FindBy(xpath = "//span[@class='SECONDARY_INFO']")
    protected List<WebElement> conditionList;
    @FindBy(xpath = "//span[@class='s-item__price']")
    protected List<WebElement> priceList;


    public SearchResultPage(WebDriver driver) {
        super( driver );
        PageFactory.initElements(driver,this);
    }

    public void validateConditionFilters()
    {
        waitForElementToBeLoaded(allListingsLabel);
        try {
            for(int i=1; i<conditionList.size(); i++) {
                String condition = conditionList.get(i).getText();
                validateCondition(condition, i);
            }
        }	catch(StringIndexOutOfBoundsException e1) {
            System.out.println("Invalid Index " + e1.toString());
        }
        takeScreenShot("filtersApplied");
    }
    public void validateCondition(String condition, int i)
    {
        if(!condition.equals("Brand New")) {
            System.out.println("The item in the position "+i+" is not New");
        }
    }

    public void validatePriceFilters()
    {
        waitForElementToBeLoaded(allListingsLabel);
        try {
            for(int i=1; i<conditionList.size(); i++) {
                String stringPrice = priceList.get(i).getText().replace("COP $","")
                        .replace(",","");
                validateRangePrice(stringPrice, i);
            }
        }	catch(StringIndexOutOfBoundsException e1) {
            System.out.println("Invalid Index " + e1.toString());
        }

        System.out.println("The Conditions were fulfilled in all items");
    }
    public void validateRangePrice(String stringPrice, int i)
    {
        double price, rangePrice;
        if(stringPrice.contains(" to ")) {
            String[] pricesSubstrings = stringPrice.split(" to ");
            price = Double.parseDouble(pricesSubstrings[0]);
            rangePrice = Double.parseDouble(pricesSubstrings[1]);
            if (price < Double.parseDouble( "200000" ) || price > Double.parseDouble( "600000" )) {
                if(rangePrice < Double.parseDouble( "200000" ) || rangePrice > Double.parseDouble( "600000" )) {
                    System.out.println( "The item in the position " + i + " is Out of the Price Range"+
                            price+" to "+rangePrice);
                }
            }
        }
        else {
            price = Double.parseDouble(stringPrice);
            if (price < Double.parseDouble( "200000" ) || price > Double.parseDouble( "600000" )) {
                System.out.println( "The item in the position " + i + " is Out of the Price Range" );
            }
        }
    }
}
