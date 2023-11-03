package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class Filters {

    public static By minPriceFilterName = By.name("startN");
    public static By maxPriceFilterName = By.name("endN");
    public static By deliveryBeforeThreeDays = By.xpath("//*[contains(text(), 'до 3 дней')]");
    public static By brandApple = By.xpath("//span[contains(text(), 'Apple')]");
    public static By screenDiagonal_13_3 = By.xpath("//span[contains(text(), '13.3\"')]");
    public static By buttonToShowResults = By.cssSelector(".filters-desktop__btn-main");
    public static List<String> listOfFilters = new ArrayList<>();

    public Filters setMinPrice(String minPrice) {
        $(minPriceFilterName).setValue(minPrice);

        return this;
    }

    public Filters setMaxPrice(String maxPrice, String minPrice) {
        $(maxPriceFilterName).setValue(maxPrice);
        listOfFilters.add("от " + minPrice + " до " + maxPrice);

        return this;
    }

    public Filters applyDeliveryTimeBeforeThreeDays() {
        SelenideElement deliveryTime = $(deliveryBeforeThreeDays);
        listOfFilters.add(deliveryTime.getText().replaceAll("\\d+$", ""));
        deliveryTime.click();

        return this;
    }

    public Filters applyBrandApple() {
        SelenideElement brand = $(brandApple);
        listOfFilters.add(brand.getText().replaceAll("\\d+$", ""));
        brand.click();

        return this;
    }

    public Filters applyScreenDiagonal_13_3() {
        SelenideElement screenDiagonal = $(screenDiagonal_13_3);
        listOfFilters.add(screenDiagonal.getText().replaceAll("\\d+$", ""));
        screenDiagonal.click();

        return this;
    }

    public List<String> showResult() {
        $(buttonToShowResults).click();

        return listOfFilters;
    }
}