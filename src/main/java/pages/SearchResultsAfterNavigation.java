package pages;

import elements.SearchLine;
import org.openqa.selenium.By;
import elements.ListOfProducts;
import validator.ValidateBasket;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static util.WorkWithDataOfElements.convertTextPriceToNumber;

public class SearchResultsAfterNavigation {

    public static final By catalogTitleElement = By.cssSelector("h1.catalog-title");
    public static By listOfGoodsInProductCardSelector = By.className("product-card");
    public static By homeLinkPath = By.xpath("//a[@href='/']/span[@itemprop='name']");
    public static By appliancesLinkPath = By.xpath("//a[@href='/catalog/bytovaya-tehnika']/span[@itemprop='name']");
    public static By homeAppliancesLinkPath = By.xpath("//a[@href='/catalog/elektronika/tehnika-dlya-doma']/span[@itemprop='name']");
    public static By vacuumCleanersLinkPath = By.xpath("//span[@itemprop='name'][text()='Пылесосы и пароочистители']");
    public static String countOfProductsInBasket = "span.navbar-pc__notify";
    public static By buttonAllFiltersSelector = By.cssSelector(".dropdown-filter__btn--all");
    public static By listOfSelectedFilters = By.cssSelector(".your-choice__list");
    public static By countOfProductsElementName = By.className("goods-count");
    public static By tagNameOfFiltersList = By.tagName("li");
    public static By buttonToResetFilters = By.xpath("//button[text()='Сбросить все']");


    private final SearchLine searchLine;
    private final ListOfProducts listOfProducts;

    public SearchResultsAfterNavigation() {
        this.searchLine = new SearchLine();
        this.listOfProducts = new ListOfProducts();
    }

    public static int getCountOfProducts() {
        return convertTextPriceToNumber($(countOfProductsElementName).getText());
    }


    public SearchResultsAfterNavigation hoverOnProductsFromList(int indexOfProduct) {
        $$(listOfGoodsInProductCardSelector).get(indexOfProduct).hover();

        return this;
    }

    public SearchResultsAfterNavigation addToBasket() {
        listOfProducts.addToBasket();

        return this;
    }

    public ValidateBasket goToBasket() {
        listOfProducts.goToBasket();

        return new ValidateBasket();
    }

    public Filters clickAllFilters() {
        $(buttonAllFiltersSelector).click();

        return new Filters();
    }
}