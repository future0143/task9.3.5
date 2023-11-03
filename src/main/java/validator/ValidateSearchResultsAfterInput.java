package validator;

import org.junit.jupiter.api.Assertions;
import pages.SearchResultsAfterInput;

import static com.codeborne.selenide.Selenide.$;

public class ValidateSearchResultsAfterInput extends SearchResultsAfterInput {

    public ValidateSearchResultsAfterInput checkTextOnPage(String expectedText) {
        String actualText = $(pathNameOfCatalog).getText();
        Assertions.assertEquals(expectedText, actualText);

        return this;
    }

    public ValidateSearchResultsAfterInput checkTextOfFirstFilter(String expectedText) {
        String actualText = $(firstFilter).getText();
        Assertions.assertEquals(expectedText, actualText);

        return this;
    }

    public ValidateSearchResultsAfterInput checkTextOfSorterFilter(String expectedText) {
        String actualText = $(filterOfSorter).getText();
        Assertions.assertEquals(expectedText, actualText);

        return this;
    }

    public ValidateSearchResultsAfterInput checkBrandOfFirstProduct(String expectedText) {
        String actualText = findBrandOfFirstProduct();
        Assertions.assertEquals(expectedText, actualText);

        return this;
    }
}