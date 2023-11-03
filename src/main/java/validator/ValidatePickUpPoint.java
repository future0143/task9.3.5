package validator;

import com.codeborne.selenide.Condition;
import pages.PickUpPoint;

import static com.codeborne.selenide.Selenide.$;

public class ValidatePickUpPoint extends PickUpPoint {

    public ValidatePickUpPoint checkInfoAboutPickUpPointIsVisible() {
        $(infoAboutPickUpPoint).shouldBe(Condition.visible);

        return new ValidatePickUpPoint();
    }

    public PickUpPoint checkAddress(String expectedText) {
        $(addressOnInfoPoint).shouldHave(Condition.text(expectedText));

        return new PickUpPoint();
    }
}