package pages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ConfigReader;
import utilities.Driver;

public class BasePage {

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("hepsiburada_url"));
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}

