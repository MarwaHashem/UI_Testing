package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBarPage extends BasePage{

    private By cartBtn = By.xpath("//a[contains(text(),'Cart')]");


    public NavigationBarPage(WebDriver driver) {
        super(driver);
    }


    public CartPage clickOnCartBtn ()
    {
        clickElement(cartBtn);
        return new CartPage(driver) ;
    }
}
