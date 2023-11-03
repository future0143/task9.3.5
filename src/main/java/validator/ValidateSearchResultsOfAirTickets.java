package validator;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.Assertions;
import pages.SearchResultsOfAviaTickets;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ValidateSearchResultsOfAirTickets extends SearchResultsOfAviaTickets {

    public ValidateSearchResultsOfAirTickets checkResultsOfTicketsSearch() {
        String expectedText = "Мы не нашли билеты по вашему запросу";

        ElementsCollection listOfTickets = $$(listOfTicketsSelector);

        if (listOfTickets.size() == 0) {
            $(fieldWithTextNoTickets).shouldHave(Condition.text(expectedText));
        } else {
            Assertions.assertFalse(listOfTickets.isEmpty());
        }
        return this;
    }

    public ValidateSearchResultsOfAirTickets checkVisibleListTickets() {
        $(listOfTicketsSelector).shouldBe(Condition.visible);

        return this;
    }
}