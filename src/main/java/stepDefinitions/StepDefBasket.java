package stepDefinitions;

import com.codeborne.selenide.Condition;
import config.ConfigSetup;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.Basket;
import validator.ValidateBasket;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$;
import static elements.ListOfProducts.buttonBasket;

public class StepDefBasket extends Basket implements ConfigSetup {

    private final ValidateBasket validateBasket = new ValidateBasket();
    TestContext testContext;

    public StepDefBasket(TestContext context) {
        testContext = context;
    }

    public StepDefBasket() {
    }

    @Then("в его корзине находится товар {string}")
    public void checkProductNameInBasket(String expectedProductName) {
        $(buttonBasket).click();
        $(nameOfProductInBasket).shouldHave(Condition.text(expectedProductName));
    }

    @Then("текст и цена товара соответствует цене и названию товара из предыдущих шагов")
    public void checkDataAboutProducts() {
        ArrayList<String> dataAboutProduct = (ArrayList<String>) testContext.scenarioContext.getContext(Context.DATA_ABOUT_PRODUCT);
        validateBasket.checkDataAboutProduct(dataAboutProduct);
    }

    @And("“Итого” = сумме товара")
    public void checkTotalAmount() {
        validateBasket.checkTotalSum();
    }

    @And("кнопка “Заказать” активна для нажатия")
    public void checkButtonOrderIsEnabled() {
        validateBasket.checkButtonToOrderIsEnabled();
    }
}