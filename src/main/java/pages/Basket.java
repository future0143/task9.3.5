package pages;

import org.openqa.selenium.By;

public class Basket {

    public final static By nameOfProductInBasket = By.cssSelector(".good-info__good-name");
    public final static By brandOfProductInBasket = By.cssSelector(".good-info__good-brand");
    public final static By priceOfProductInBasket = By.cssSelector(".list-item__price-new");
    public final static By listOfProductsPrices = By.cssSelector("div.accordion__list-item div.list-item__price-new");
    public final static By totalSum = By.cssSelector("p.b-top__total span[data-jsv]");
    public final static By buttonToOrder = By.cssSelector("[name='ConfirmOrderByRegisteredUser']");
}