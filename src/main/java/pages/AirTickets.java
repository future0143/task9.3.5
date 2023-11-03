package pages;

import elements.FormForAirTickets;

public class AirTickets {

    private final FormForAirTickets formForAirTickets;
    private final SearchResultsOfAviaTickets searchResultsOfAviaTickets;

    public AirTickets() {
        this.formForAirTickets = new FormForAirTickets();
        this.searchResultsOfAviaTickets = new SearchResultsOfAviaTickets();
    }
}