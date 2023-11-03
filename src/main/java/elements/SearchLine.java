package elements;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.SearchResultsAfterInput;

import static com.codeborne.selenide.Selenide.$;

public class SearchLine {

    private static final By searchLineSelector = By.id("searchInput");
    private static final By buttonSearchBarClear = By.cssSelector(".search-catalog__btn--clear");

    public SearchResultsAfterInput inputTextInSearchLine(String textForInput) {
        $(searchLineSelector).sendKeys(textForInput);
        $(searchLineSelector).sendKeys(Keys.ENTER);

        return new SearchResultsAfterInput();
    }

    public void clearSearchLine() {
        $(buttonSearchBarClear).click();
    }

    public void checkSearchLineIsEmpty() {
        $(searchLineSelector).shouldBe(Condition.empty);
    }
}