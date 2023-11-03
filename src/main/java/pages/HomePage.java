package pages;

import config.ConfigSetup;
import elements.SearchLine;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage implements ConfigSetup {

    public static final By buttonFiltersCssSelector = By.cssSelector(".j-menu-burger-btn");
    private static final By cssSelectorForCity = By.cssSelector(".j-geocity-wrap");
    public static final By mainContent = By.cssSelector(".main-page__content-wrapper");

    private final SearchLine searchLine;


    public HomePage() {
        this.searchLine = new SearchLine();
    }

    public SiteNavigation clickButtonFilter() {
        $(buttonFiltersCssSelector).click();

        return new SiteNavigation();
    }

    public City clickChangeCity() {
        $(cssSelectorForCity).click();

        return new City();
    }

    public String getCity() {
        return $(cssSelectorForCity).getText();
    }
}