package stepDefinitions;

import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.And;
import pages.Filters;

public class StepDefFilters extends Filters {

    private TestContext testContext;

    public StepDefFilters() {
    }

    public StepDefFilters(TestContext testContext) {
        this.testContext = testContext;
    }

    @And("Цена: От {int} до {int}")
    public void chooseRangeOfPrices(int minPrice, int maxPrice) {
        setMinPrice(String.valueOf(minPrice));
        setMaxPrice(String.valueOf(maxPrice), String.valueOf(minPrice));
    }

    @And("Срок доставки: до 3 дней")
    public void deliveryTimeThreeDaysMax() {
        applyDeliveryTimeBeforeThreeDays();
    }

    @And("Бренд: Apple")
    public void chooseBrandApple() {
        applyBrandApple();
    }

    @And("Диагональ экрана: 13.3”")
    public void screenDiagonal() {
        applyScreenDiagonal_13_3();
    }

    @And("пользователь нажимает на кнопку “Показать”")
    public void clickButtonToShowResults() {
        testContext.scenarioContext.setContext(Context.LIST_OF_FILTERS, listOfFilters);
        showResult();
    }
}