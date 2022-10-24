package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProdPage;
import pages.ProdSearchPage;

import static fileReaderManager.ReadFromFiles.getJsonValueByKey;


public class ProdTests extends BaseTests{

  String value1= getJsonValueByKey(prodDetailsJsonFileName, "productName");
   int value2= Integer.parseInt(getJsonValueByKey(prodDetailsJsonFileName, "noOfProd"));




    @Test

    public void testProd(){


        ProdPage prodPage = new ProdPage(driver);
        ProdSearchPage prodSearchPage = prodPage.searchprod(value1);
        prodSearchPage.scrolToAllSearch();
        for(int i=0;i<=2;i++) {
            Assert.assertTrue(prodSearchPage.getTextList(i).contains(value1));

        }
    }


    @Test
    public void testProd_2(){
        ProdPage prodPage = new ProdPage(driver);
        ProdSearchPage prodSearchPage = prodPage.searchprodByEnter(value1);
        Assert.assertTrue(prodSearchPage.getTextList(value2).contains(value1));


    }
}
