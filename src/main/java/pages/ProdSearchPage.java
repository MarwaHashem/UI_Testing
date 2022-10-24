package pages;

import org.checkerframework.framework.qual.DefaultQualifier;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProdSearchPage extends BasePage{

    private By SearchText=By.xpath("//div[@class=\"productinfo text-center\"]");
    public ProdSearchPage(WebDriver driver) {super(driver);}

    public void scrolToAllSearch(){
        scrollToElement(600);
    }

    public String getTextList(int i){

    return listElements(SearchText).get(i).getText();

    }

}
