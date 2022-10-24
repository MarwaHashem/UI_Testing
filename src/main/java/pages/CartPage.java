package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{


private By cartTable= By.id("empty_cart");
private By quantCount=By.className("disabled");
    public CartPage(WebDriver driver) {  super(driver);  }

    public String getCartTable () {  return getTextOfElement(cartTable) ; }
    //public String getQuantCount () {  return getTextOfElement(quantCount) ; }

}
