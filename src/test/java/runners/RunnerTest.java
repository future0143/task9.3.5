package runners;

import com.codeborne.selenide.Configuration;
import config.ConfigSetup;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/"}, // Путь к директории с feature-файлами
        glue = {"stepDefinitions"},// Пакет, где находятся реализации шагов (step definitions)
        tags = "@airTickets"
)
public class RunnerTest implements ConfigSetup {

    @BeforeClass
    public static void setupSelenideTimeout() {
        Configuration.timeout = 25000;
    }
}