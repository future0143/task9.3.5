package stepDefinitions;

import elements.FormForAirTickets;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AirTickets;
import validator.ValidateAirTickets;

public class StepDefAirTickets extends AirTickets {

    private final ValidateAirTickets validateAirTickets = new ValidateAirTickets();
    private final FormForAirTickets formForAirTickets = new FormForAirTickets();

    @Then("происходит переход на страницу с авиабилетами")
    public void checkGoToAirTicketsPage() {
        validateAirTickets.checkUrl();
    }

    @When("пользователь вводит в поле “Откуда” - {string}")
    public void enterCityFromInField(String cityFrom) {
        formForAirTickets.enterCityFrom(cityFrom);
    }

    @And("вводит в поле “Куда” - {string}")
    public void enterCityWhereInField(String cityWhere) {
        formForAirTickets.enterCityWhere(cityWhere);
    }

    @And("вводит в поле “Дата” - указать дату - Сегодняшний день + {int} дня")
    public void enterDateInField(int days) {
        formForAirTickets.chooseDateInField(days);
    }

    @And("выбирает {int} взрослых пассажира")
    public void chooseAdultsPassengers(int countClick) {
        formForAirTickets.clickPassengers(countClick);
    }

    @And("нажимает “Найти билеты”")
    public void clickButtonSearchTickets() {
        formForAirTickets.clickSearchTickets().checkVisibleListTickets().checkResultsOfTicketsSearch();
    }
}