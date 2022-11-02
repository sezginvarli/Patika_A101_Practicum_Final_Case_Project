package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ConfigReader;
import utilities.Driver;

public class BaseTest {


    WebDriver driver ;

    @BeforeAll
    public void setUp(){
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
        Driver.getDriver().get(ConfigReader.getProperty("hepsiburada_url"));
//        driver.manage().window().maximize();
    }

    @AfterAll
    public void tearDown(){
        driver.quit();
    }

}
