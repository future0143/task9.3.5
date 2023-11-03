package stepDefinitions;

import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PickUpPoint;
import validator.ValidatePickUpPoint;

public class StepDefPickUpPoint extends PickUpPoint {

    private final ValidatePickUpPoint validatePickUpPoint = new ValidatePickUpPoint();
    private TestContext testContext;

    public StepDefPickUpPoint() {
    }

    public StepDefPickUpPoint(TestContext testContext) {
        this.testContext = testContext;
    }

    @Then("открывается информация о центре выдачи")
    public void checkInfoAboutPointIsVisible() {
        validatePickUpPoint.checkInfoAboutPickUpPointIsVisible();
    }

    @And("адрес пункта выдачи совпадает с тем адресом, что был предложен в списке адресов")
    public void checkAddresses() {
        String firstAddress = (String) testContext.scenarioContext.getContext(Context.ADDRESS);
        validatePickUpPoint.checkAddress(firstAddress);
    }

    @When("пользователь нажимает на кнопку “Выбрать”")
    public void clickButtonChoose() {
        choosePoint();
    }
}