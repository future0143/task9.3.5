package validator;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.Assertions;
import pages.SearchResultsAfterNavigation;

import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static elements.ListOfProducts.listProductsAfterFiltersSelector;
import static util.WorkWithDataOfElements.getListOfTextsFromListOfElements;

public class ValidateSearchResultsAfterNavigation extends SearchResultsAfterNavigation {

    public ValidateSearchResultsAfterNavigation checkTitleOfCatalog(String expectedText) {
        $(catalogTitleElement).shouldHave(Condition.text(expectedText));

        return this;
    }

    public void checkPathOfFilters() {
        $(homeLinkPath).shouldHave(Condition.text("Главная"));
        $(appliancesLinkPath).shouldHave(Condition.text("Бытовая техника"));
        $(homeAppliancesLinkPath).shouldHave(Condition.text("Техника для дома"));
        $(vacuumCleanersLinkPath).shouldHave(Condition.text("Пылесосы и пароочистители"));
    }

    public void checkCountOfProductsInBasket(int expectedCount) {
        $(countOfProductsInBasket).shouldHave(Condition.text(String.valueOf(expectedCount)));
    }

    public ValidateSearchResultsAfterNavigation checkSelectedFiltersIsVisible() {
        $(listOfSelectedFilters).shouldBe(Condition.visible);

        return this;
    }

    public ValidateSearchResultsAfterNavigation checkCountOfProducts(int countOfProducts) {
        $$(listProductsAfterFiltersSelector).shouldHave(CollectionCondition.size(countOfProducts));

        return this;
    }

    public ValidateSearchResultsAfterNavigation checkSelectedFiltersOnPage(List<String> listOfFiltersTextExpected) {
        ElementsCollection listOfFiltersActual = $$(tagNameOfFiltersList);

        List<String> listOfFiltersTextActual = getListOfTextsFromListOfElements(listOfFiltersActual);

        Assertions.assertFalse(Collections.disjoint(listOfFiltersTextActual, listOfFiltersTextExpected));

        return this;
    }

    public ValidateSearchResultsAfterNavigation checkButtonToResetFilterIsVisible() {
        $(buttonToResetFilters).shouldBe(Condition.visible);

        return this;
    }
}