package pages;

import org.openqa.selenium.By;
import validator.ValidateSearchResultsAfterNavigation;

import static com.codeborne.selenide.Selenide.$;
import static pages.HomePage.buttonFiltersCssSelector;

public class SiteNavigation {

    public static By filterTripsSelector = By.linkText("Путешествия");
    public static By filterFlightsSelector = By.linkText("Авиабилеты");
    protected static By filterAppliances = By.linkText("Бытовая техника");
    protected static By homeAppliances = By.xpath("//span[contains(text(), 'Техника для дома')]");
    protected static By vacuumAndSteamCleaners = By.linkText("Пылесосы и пароочистители");
    protected static By filterElectronicsSelector = By.linkText("Электроника");
    protected static By filterLaptopsAndPC = By.xpath("//span[contains(text(), 'Ноутбуки и компьютеры')]");
    protected static By filterLaptops = By.linkText("Ноутбуки");

    public SiteNavigation hoverOnAppliances() {
        $(filterAppliances).hover();

        return this;
    }

    public SiteNavigation hoverAndClickOnHomeAppliances() {
        $(homeAppliances).hover().click();

        return this;
    }

    public ValidateSearchResultsAfterNavigation clickOnVacuumAndSteamCleaners() {
        $(vacuumAndSteamCleaners).click();

        return new ValidateSearchResultsAfterNavigation();
    }

    public SiteNavigation hoverOnTrips() {
        $(filterTripsSelector).scrollIntoView(true).hover();

        return this;
    }

    public AirTickets clickOnAirTickets() {
        $(filterFlightsSelector).click();

        return new AirTickets();
    }

    public SiteNavigation hoverOnElectronic() {
        $(filterElectronicsSelector).scrollIntoView(true).hover();

        return this;
    }

    public SiteNavigation hoverAndClickOnLaptopAndPC() {
        $(filterLaptopsAndPC).hover().click();

        return this;
    }

    public ValidateSearchResultsAfterNavigation clickOnLaptops() {
        $(filterLaptops).click();

        return new ValidateSearchResultsAfterNavigation();
    }

    public SearchResultsAfterNavigation goToCategory(String category) {
        $(buttonFiltersCssSelector).click();
        $(By.linkText(category)).click();

        return new SearchResultsAfterNavigation();
    }
}