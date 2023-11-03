package stepDefinitions;

import config.ConfigSetup;
import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.SiteNavigation;

public class StepDefSiteNavigation extends SiteNavigation implements ConfigSetup {

    private TestContext testContext;

    public StepDefSiteNavigation() {
    }

    public StepDefSiteNavigation(TestContext testContext) {
        this.testContext = testContext;
    }

    @When("пользователь переходит в категорию {string}")
    public void goToOneCategory(String category) {
        goToCategory(category);
    }

    @And("выбирает “Бытовая техника - Техника для дома - Пылесосы и пароочистители")
    public void chooseCategoryAppliances() {
        hoverOnAppliances()
                .hoverAndClickOnHomeAppliances()
                .clickOnVacuumAndSteamCleaners();
    }

    @And("выбирает “Путешествия” - “Авиабилеты”")
    public void chooseCategoryTrips() {
        hoverOnTrips().clickOnAirTickets();
    }

    @And("выбирает “Электроника” - “Ноутбуки и компьютеры” - “Ноутбуки”")
    public void chooseCategoryElectronic() {
        hoverOnElectronic()
                .hoverAndClickOnLaptopAndPC()
                .clickOnLaptops();
    }
}