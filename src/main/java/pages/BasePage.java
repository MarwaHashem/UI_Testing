package pages;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;
import java.util.List;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait =new WebDriverWait(driver, Duration.ofSeconds(40));
    }
    public WebElement locateElement( By elementLocator)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        wait.until(ExpectedConditions.elementToBeClickable (elementLocator));
        return driver.findElement(elementLocator);
    }
    public List<WebElement> listElements(By elementLocator)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        wait.until(ExpectedConditions.elementToBeClickable (elementLocator));
        return driver.findElements(elementLocator);
    }
    public void clickElement(By elementLocator){ locateElement(elementLocator).click();}
    public void typeOnInputField(By elementLocator,String text){locateElement(elementLocator).sendKeys(text);}
    public String getTextOfElement (By elementLocator){ return locateElement(elementLocator).getText();}



    public void hoverToElement(By elementLocator){
        Actions actions = new Actions(driver);
        actions.moveToElement(locateElement(elementLocator));
        actions.perform();

    }
    public void scrollToElement(int y_pixcel){
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0,y_pixcel);
        actions.perform();

    }
    public void sendKeyFromKeyboard(){
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.ENTER);
        actions.perform();

    }
}

