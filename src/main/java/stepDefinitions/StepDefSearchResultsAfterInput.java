package stepDefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import config.ConfigSetup;
import cucumber.TestContext;
import elements.ListOfProducts;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchResultsAfterInput;
import validator.ValidateSearchResultsAfterInput;

import static com.codeborne.selenide.Selenide.$$;

public class StepDefSearchResultsAfterInput extends SearchResultsAfterInput implements ConfigSetup {

    private final ListOfProducts listOfProducts = new ListOfProducts();
    private TestContext testContext;
    private final ValidateSearchResultsAfterInput validate = new ValidateSearchResultsAfterInput();

    public StepDefSearchResultsAfterInput() {
    }

    @Then("пользователь видит товар {string} в результатах поиска")
    public void checkProductInSearchResults(String nameOfProduct) {
        SelenideElement element = $$(listOfGoodsInProductCardSelector)
                .filter(Condition.text(nameOfProduct))
                .first()
                .shouldBe(Condition.visible);
        element.hover();
    }

    @When("пользователь добавляет товар в корзину")
    public void addProductToBasket() {
        listOfProducts.addToBasket();
    }

    @Then("на странице с результатами поиска присутствует текст {string}")
    public void textOnPageShouldHaveNameOfProduct(String product) {
        validate.checkTextOnPage(product);
    }

    @And("первый фильтр - {string}")
    public void checkFirstFilter(String filter) {
        validate.checkTextOfFirstFilter(filter);
    }

    @And("применен фильтр {string}")
    public void checkSorterFilter(String sorter) {
        validate.checkTextOfSorterFilter(sorter);
    }

    @And("у первого устройства из списка бренд - {string}")
    public void checkBrand(String brand) {
        validate.checkBrandOfFirstProduct(brand);
    }
}