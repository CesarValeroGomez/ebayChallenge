package uiTests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ui.pageObjects.FilterSectionPage;
import ui.pageObjects.SearchResultPage;

public class SearchProductTest extends BaseTest {

    @Test
    public void searchingProduct() throws InterruptedException {

        mainPage.searchItem("PS4");
        filterSectionPage = new FilterSectionPage(driver);
        filterSectionPage.filterByDecision("Condition", "New");
        filterSectionPage.filterByPrice("200000", "600000");
        searchResultPage = new SearchResultPage(driver);
        searchResultPage.validateConditionFilters();
        searchResultPage.validatePriceFilters();
       // SoftAssert softAssertion= new SoftAssert();
        System.out.println("primer probe");
    }
}
