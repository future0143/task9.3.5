package pages;

import org.openqa.selenium.By;

public class SearchResultsOfAviaTickets {

    public static By listOfTicketsSelector = By.cssSelector("div[class*='_tickets-module__tickets']");

    public static By fieldWithTextNoTickets = By.cssSelector("h1[class*='_heading-module__heading']");
}