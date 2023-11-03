package stepDefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import config.ConfigSetup;
import config.TestProperties;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import validator.ValidateHomePage;

import static com.codeborne.selenide.Selenide.$;

public class StepDefHomePage extends HomePage implements ConfigSetup {

    private final ValidateHomePage validateHomePage = new ValidateHomePage();
    private TestContext testContext;

    public StepDefHomePage() {
    }

    public StepDefHomePage(TestContext testContext) {
        this.testContext = testContext;
    }

    @Given("пользователь на главной странице магазина")
    public void openHomePage() {
        String url = TestProperties.getValue("test.url");

        Selenide.open(url);

        $(mainContent).should(Condition.visible);
    }

    @When("пользователь нажимает на “Фильтры”")
    public void clickFiltersNavigation() {
        clickButtonFilter();
    }


    @When("пользователь кликает на кнопку “Смена города”")
    public void clickButtonChangeCity() {
        clickChangeCity();
    }


    @Then("происходит переход на главную страницу WB")
    public void goToHomePage() {
        validateHomePage.checkUrl();
    }

    @And("отображается адрес пункта выдачи из предыдущего шага")
    public void checkAddressOnHomePage() {
        String firstAddress = (String) testContext.scenarioContext.getContext(Context.ADDRESS);
        validateHomePage.checkCity(firstAddress);
    }
}