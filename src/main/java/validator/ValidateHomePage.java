package validator;

import com.codeborne.selenide.WebDriverRunner;
import config.TestProperties;
import org.junit.jupiter.api.Assertions;
import pages.HomePage;

public class ValidateHomePage extends HomePage {

    public void checkCity(String expectedCity) {
        Assertions.assertEquals(expectedCity, getCity());
    }

    public ValidateHomePage checkUrl() {
        String actualUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        String expectedUrl = TestProperties.getValue("test.url");
        Assertions.assertEquals(expectedUrl, actualUrl);

        return this;
    }
}