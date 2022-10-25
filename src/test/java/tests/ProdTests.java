package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProdPage;
import pages.ProdSearchPage;

import java.lang.reflect.Method;

import static fileReaderManager.ReadFromFiles.getJsonValueByKey;
import static utils.extentreports.ExtentTestManager.startTest;

public class ProdTests extends BaseTests{

  String searchTextFromJson= getJsonValueByKey(prodDetailsJsonFileName, "productName");
   int noOfProdFromJson= Integer.parseInt(getJsonValueByKey(prodDetailsJsonFileName, "noOfProd"));

    @Test

    public void testProd(Method method){
        startTest(method.getName(), "valid when click search\n" +
                "button.");
        ProdPage prodPage = new ProdPage(driver);
        ProdSearchPage prodSearchPage = prodPage.searchprod(searchTextFromJson);
        prodSearchPage.scrolToAllSearch();
        for(int i=0;i<=2;i++) {
            Assert.assertTrue(prodSearchPage.getTextList(i).contains(searchTextFromJson));

        }
    }


    @Test
    public void testProd_2(Method method){
        startTest(method.getName(), " test when click Enter Button.");
        ProdPage prodPage = new ProdPage(driver);
        ProdSearchPage prodSearchPage = prodPage.searchprodByEnter(searchTextFromJson);
        Assert.assertTrue(prodSearchPage.getTextList(noOfProdFromJson).contains(searchTextFromJson));


    }
}
