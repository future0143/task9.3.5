package config;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public interface ConfigSetup {

    @Before
    static void setup() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());

        WebDriverManager.chromedriver().setup();

        Configuration.browserSize = "1150x850";
    }
}