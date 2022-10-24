package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage {

private By cartQuant= By.xpath("//button[@class=\"disabled\"]");


    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }



    public String getNoOfQuantCart() {
        return getTextOfElement(cartQuant);

    }
}
