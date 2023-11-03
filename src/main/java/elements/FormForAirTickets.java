package elements;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import validator.ValidateSearchResultsOfAirTickets;

import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.$;

public class FormForAirTickets {

    public static By fieldFromForInput = By.id("rc_select_0");
    public static By fieldWhereForInput = By.id("rc_select_1");
    public static By fieldDateThere = By.cssSelector("div.ant-picker.selector-form-date input[name='dateFrom']");
    public static By dateContainerSelector = By.className("ant-picker-panels");
    public static By attributeForDates = By.cssSelector("td[title]");
    public static By buttonPassengers = By.cssSelector("div.ant-dropdown-trigger");
    public static By buttonSearchTickets = By.cssSelector("button[class*='_button-module__button'][class*='_selector-form-module__button']");


    public FormForAirTickets enterCityFrom(String text) {
        $(fieldFromForInput).sendKeys(text);
        $(By.xpath("//div[contains(@label, '" + text + "')]")).click();

        return this;
    }

    public FormForAirTickets enterCityWhere(String text) {
        $(fieldWhereForInput).sendKeys(text);
        $(By.xpath("//div[contains(@label, '" + text + "')]")).click();

        return this;
    }

    public FormForAirTickets chooseDateInField(int days) {
        LocalDate nowDate = LocalDate.now();
        LocalDate dateForInput = nowDate.plusDays(days);
        String dateForInputString = dateForInput.toString();

        $(fieldDateThere).click();
        ElementsCollection dateElements = $(dateContainerSelector).$$(attributeForDates);

        for (WebElement dateElement : dateElements) {
            if (dateElement.getAttribute("title").equals(dateForInputString)) {
                dateElement.click();
            }
        }
        return this;
    }

    public FormForAirTickets clickPassengers(int countClick) {
        for (int i = 1; i <= countClick; i++) {
            $(buttonPassengers).click();
        }

        return this;
    }

    public ValidateSearchResultsOfAirTickets clickSearchTickets() {
        $(buttonSearchTickets).click();

        return new ValidateSearchResultsOfAirTickets();
    }
}