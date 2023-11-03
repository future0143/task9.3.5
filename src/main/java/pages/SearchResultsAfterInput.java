package pages;

import elements.SearchLine;
import org.openqa.selenium.By;
import elements.ListOfProducts;

import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsAfterInput {

    public static By pathNameOfCatalog = By.xpath("//*[@id=\"catalog\"]/div/div[1]/div/h1");
    public static By filterOfSorter = By.cssSelector(".dropdown-filter__btn--sorter");
    public static By firstFilter = By.cssSelector(".dropdown-filter__btn--burger");
    public static By listOfGoodsInProductCardSelector = By.className("product-card");
    public static By brandOfProduct = By.cssSelector(".product-card__brand");


    private final SearchLine searchLine;
    private final ListOfProducts listOfProducts;

    public SearchResultsAfterInput() {
        this.searchLine = new SearchLine();
        this.listOfProducts = new ListOfProducts();
    }

    public String findBrandOfFirstProduct() {
        return $$(listOfGoodsInProductCardSelector).get(0).$(brandOfProduct).getText();
    }
}