package stepDefinitions;

import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.And;
import pages.City;

public class StepDefCity extends City {

    private TestContext testContext;

    public StepDefCity() {
    }

    public StepDefCity(TestContext testContext) {
        this.testContext = testContext;
    }

    @And("вводит в поисковую строку название города - {string}")
    public void inputCityInSearchBar(String city) {
        inputCityInSearchLine(city);
    }

    @And("выбирает {int}-й адрес из списка адресов с городом {string}")
    public void chooseAddressByIndex(int index, String city) {
        String firstAddress = chooseAddressFromListByIndex(index - 1, city);
        testContext.scenarioContext.setContext(Context.ADDRESS, firstAddress);
    }
}