package stepDefinitions;

import config.ConfigSetup;
import cucumber.TestContext;
import elements.ListOfProducts;
import enums.Context;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchResultsAfterNavigation;
import validator.ValidateSearchResultsAfterNavigation;

import java.util.ArrayList;
import java.util.List;

public class StepDefSearchResultsAfterNavigation extends SearchResultsAfterNavigation implements ConfigSetup {

    private final ValidateSearchResultsAfterNavigation validate = new ValidateSearchResultsAfterNavigation();
    private final ListOfProducts listOfProducts = new ListOfProducts();
    private TestContext testContext;

    public StepDefSearchResultsAfterNavigation(TestContext testContext) {
        this.testContext = testContext;
    }

    public StepDefSearchResultsAfterNavigation() {
    }

    @Then("отображается {string}")
    public void checkTitle(String expectedTitle) {
        validate.checkTitleOfCatalog(expectedTitle);
    }

    @And("путь фильтра - “Главная - Бытовая техника - Техника для дома - Пылесосы и пароочистители”")
    public void checkPathFilter() {
        validate.checkPathOfFilters();
    }

    @When("пользователь добавляет в корзину {int}-й товар из списка товаров")
    public void addProductToBasketById(int index) {
        hoverOnProductsFromList(index - 1);
        ArrayList<String> data = listOfProducts.getDataAboutProduct();
        testContext.scenarioContext.setContext(Context.DATA_ABOUT_PRODUCT, data);
        addToBasket();
    }

    @Then("в правом верхнем углу над логотипом “Корзина” появляется красная цифра {int}")
    public void checkCountOfProductsInBasket(int count) {
        validate.checkCountOfProductsInBasket(count);
    }

    @When("пользователь нажимает на “Корзина”")
    public void clickGoToBasket() {
        goToBasket();
    }

    @Then("открывается страница с ноутбуками - {string}")
    public void checkTitleOfSearchResults(String expectedText) {
        validate.checkTitleOfCatalog(expectedText);
    }

    @When("Применяются фильтры:")
    public void clickFilters() {
        clickAllFilters();
    }

    @Then("фильтр активируется")
    public void checkFiltersAreVisible() {
        validate.checkSelectedFiltersIsVisible();
    }

    @And("кол-во товара на страница = количеству товара на странице")
    public void checkCountOfProducts() {
        validate.checkCountOfProducts(getCountOfProducts());
    }

    @And("выбранные фильтры отображаются на странице")
    public void checkSelectedFilters() {
        List<String> listOfFilters = (List<String>) testContext.scenarioContext.getContext(Context.LIST_OF_FILTERS);
        validate.checkSelectedFiltersOnPage(listOfFilters);
    }

    @And("появилась кнопка “Сбросить все”")
    public void buttonToResetAllIsVisible() {
        validate.checkButtonToResetFilterIsVisible();
    }
}