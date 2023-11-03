package elements;

import org.openqa.selenium.By;
import pages.SearchResultsAfterNavigation;
import validator.ValidateBasket;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$;

public class ListOfProducts {

    public static By nameOfProductFromList = By.cssSelector(".product-card__name");
    public static By brandOfProductFromList = By.cssSelector(".product-card__brand");
    public static By priceOfProductFromList = By.cssSelector(".price__lower-price");
    public static By listProductsAfterFiltersSelector = By.className("product-card");
    public static By buttonAddToBasketSelector = By.linkText("В корзину");
    public static By buttonBasket = By.cssSelector("div.navbar-pc__item.j-item-basket");


    public ArrayList<String> getDataAboutProduct() {
        String expectedProductName = $(nameOfProductFromList).getText();

        String expectedProductBrand = $(brandOfProductFromList).getText();

        String expectedProductPrice = $(priceOfProductFromList).getText();

        ArrayList<String> dataAboutProduct = new ArrayList<>();
        dataAboutProduct.add(expectedProductName);
        dataAboutProduct.add(expectedProductBrand);
        dataAboutProduct.add(expectedProductPrice);

        return dataAboutProduct;
    }

    public SearchResultsAfterNavigation addToBasket() {
        $(buttonAddToBasketSelector).click();

        return new SearchResultsAfterNavigation();
    }

    public ValidateBasket goToBasket() {
        $(buttonBasket).click();

        return new ValidateBasket();
    }
}