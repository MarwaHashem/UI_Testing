package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.NavigationBarPage;
import pages.ProdPage;
import pages.ShoppingCartPage;

import java.lang.reflect.Method;

import static fileReaderManager.ReadFromFiles.getJsonValueByKey;
import static utils.extentreports.ExtentTestManager.startTest;

public class CartTests extends BaseTests{
    String descCartMenuFromJson= getJsonValueByKey(cartDetailsJsonFileName, "cartTableMenu");
    String noOfQuantFromJson= (getJsonValueByKey(cartDetailsJsonFileName, "noOfQuant"));

    @Test
            public void testCart(Method method) {
        startTest(method.getName(), " test The table should contain 6 columns.");
        NavigationBarPage navigationBarPage = new NavigationBarPage(driver);
        CartPage cartPage = navigationBarPage.clickOnCartBtn();
        cartPage.getCartTable();
        Assert.assertTrue(cartPage.getCartTable().contains(descCartMenuFromJson));
    }
    @Test
      public void testCart_2(Method method) {
        startTest(method.getName(), " the product\n" +
                "should be seen on cart page by quantity 1");

         ProdPage prodPage = new ProdPage(driver);
         prodPage.scrolToAllSearch();
         prodPage.clickToAddToCart();
         ShoppingCartPage shoppingCartPage= prodPage.clickToViewCart();
         Assert.assertEquals( shoppingCartPage.getNoOfQuantCart(),noOfQuantFromJson);
    }

}
