package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.NavigationBarPage;
import pages.ProdPage;
import pages.ShoppingCartPage;

import static fileReaderManager.ReadFromFiles.getJsonValueByKey;

public class CartTests extends BaseTests{
    String value1= getJsonValueByKey(cartDetailsJsonFileName, "cartTableMenu");
    String value2= (getJsonValueByKey(cartDetailsJsonFileName, "noOfQuant"));

    @Test
            public void testCart() {
        NavigationBarPage navigationBarPage = new NavigationBarPage(driver);
        CartPage cartPage = navigationBarPage.clickOnCartBtn();
        cartPage.getCartTable();
        Assert.assertTrue(cartPage.getCartTable().contains(value1));
    }
    @Test
      public void testCart_2() {

         ProdPage prodPage = new ProdPage(driver);
         prodPage.scrolToAllSearch();
         prodPage.clickToAddToCart();
         ShoppingCartPage shoppingCartPage= prodPage.clickToViewCart();
         Assert.assertEquals( shoppingCartPage.getNoOfQuantCart(),value2);
    }

}
