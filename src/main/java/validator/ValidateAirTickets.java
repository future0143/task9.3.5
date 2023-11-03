package validator;

import com.codeborne.selenide.WebDriverRunner;
import config.TestProperties;
import org.junit.jupiter.api.Assertions;
import pages.AirTickets;

public class ValidateAirTickets extends AirTickets {

    public void checkUrl() {
        String actualUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        String expectedUrl = TestProperties.getValue("avia.url");
        Assertions.assertEquals(expectedUrl, actualUrl);
    }
}