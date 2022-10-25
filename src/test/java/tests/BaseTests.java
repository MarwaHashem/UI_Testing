package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.logs.Log;

import java.io.File;
import java.io.IOException;

import static fileReaderManager.ReadFromFiles.getPropertyByKey;
import static fileReaderManager.ReadFromFiles.url;

public class BaseTests {
    public static String configPropertyFileName =  "configData.properties" ;
    public static String prodDetailsJsonFileName =  "prodDetails.json" ;
    public static String cartDetailsJsonFileName =  "cartDetails.json" ;
    public WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }




    @BeforeMethod
    public void  setup_initiateDriver()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
        Log.info("Tests is starting!");

    }
@BeforeTest
        public void getPropertiesData() {
            getPropertyByKey(configPropertyFileName, "App_url");
        }




    @AfterMethod
    public void a_ScrnshotForFalier(ITestResult result)
    {
        if (result.getStatus()==ITestResult.FAILURE){
            File scrnshot=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try{
                FileUtils.copyFile(scrnshot,new File("./images/"+result.getName()+".png"));
            } catch (IOException e){

            }
        }
    }


    @AfterMethod
    public void z_quitDriver(){
     Log.info("Tests are ending!");
       driver.quit();
    }


}
