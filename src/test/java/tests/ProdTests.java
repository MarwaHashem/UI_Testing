package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProdPage;
import pages.ProdSearchPage;

import static fileReaderManager.ReadFromFiles.getJsonValueByKey;


public class ProdTests extends BaseTests{

  String searchTextFromJson= getJsonValueByKey(prodDetailsJsonFileName, "productName");
   int noOfProdFromJson= Integer.parseInt(getJsonValueByKey(prodDetailsJsonFileName, "noOfProd"));




    @Test

    public void testProd(){


        ProdPage prodPage = new ProdPage(driver);
        ProdSearchPage prodSearchPage = prodPage.searchprod(searchTextFromJson);
        prodSearchPage.scrolToAllSearch();
        for(int i=0;i<=2;i++) {
            Assert.assertTrue(prodSearchPage.getTextList(i).contains(searchTextFromJson));

        }
    }


    @Test
    public void testProd_2(){
        ProdPage prodPage = new ProdPage(driver);
        ProdSearchPage prodSearchPage = prodPage.searchprodByEnter(searchTextFromJson);
        Assert.assertTrue(prodSearchPage.getTextList(noOfProdFromJson).contains(searchTextFromJson));


    }
}
