package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class City {

    protected static final By listOfAddress = By.cssSelector(".address-item.j-poo-option");
    protected static final By addressOfElement = By.cssSelector(".address-item__name-text");
    private static final By searchCityLine = By.cssSelector("input.ymaps-2-1-79-searchbox-input__input");


    public City inputCityInSearchLine(String city) {
        $(searchCityLine).sendKeys(city);
        $(searchCityLine).sendKeys(Keys.ENTER);

        return this;
    }

    public String chooseAddressFromListByIndex(int index, String cityForInput) {
        SelenideElement element = $$((listOfAddress)).get(index);
        element.shouldHave(text(cityForInput)).click();

        return element.$(addressOfElement).getText();
    }
}