package stepDefinitions;

import io.cucumber.java.en.Then;
import validator.ValidateSearchResultsOfAirTickets;

public class StepDefSearchResultsOfAviaTickets {

    private final ValidateSearchResultsOfAirTickets validateSearchResultsOfAirTickets = new ValidateSearchResultsOfAirTickets();

    @Then("если билеты найдены: есть хотя бы один билет в списке с результатами поиска отображается сообщение о том, что билеты не найдены.")
    public void checkTicketsFound() {
        validateSearchResultsOfAirTickets.checkResultsOfTicketsSearch();
    }
}