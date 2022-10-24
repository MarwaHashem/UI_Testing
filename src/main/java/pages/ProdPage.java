package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProdPage extends BasePage {
  private   By searchBox = By.id("search_product");
  private   By searchBtn = By.id("submit_search");
  private  By addToCartBtn=By.xpath("(//a[@data-product-id=\"1\"])[2]");

  private By viewCartLink=By.xpath("(//a[@href=\"/view_cart\"])[2]");

    public ProdPage(WebDriver driver) {
        super(driver);
    }

    public ProdSearchPage searchprod(String search_prod) {
        typeOnInputField(searchBox, search_prod);
        clickElement(searchBtn);
        return new ProdSearchPage(driver);
    }

    public ProdSearchPage searchprodByEnter(String search_prod) {
        typeOnInputField(searchBox, search_prod);
        sendKeyFromKeyboard();
        return new ProdSearchPage(driver);
    }
    public void scrolToAllSearch(){
        scrollToElement(600);
    }
    public void clickToAddToCart(){ clickElement(addToCartBtn);}
    public ShoppingCartPage clickToViewCart(){
        clickElement(viewCartLink);
    return new ShoppingCartPage(driver);}




}
