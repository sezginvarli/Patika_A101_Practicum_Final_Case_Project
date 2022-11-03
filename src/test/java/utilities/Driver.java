package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class Driver {
    private static WebDriver driver;

    private Driver() {
    }

    public static WebDriver getDriver() {

        ChromeOptions obj = new ChromeOptions();
        obj.addArguments("--incognito");
        obj.addArguments("--start-maximized");
        obj.addArguments("--ignore-certificate-errors");
        obj.addArguments("--allow-insecure-localhost");
        obj.addArguments("--acceptInsecureCerts");
        obj.addArguments("--disable-blink-features=AutomationControlled");
        obj.addArguments("--disable-extensions");


        if (driver == null) {
            String browser = ConfigReader.getProperty("browser");
            if ("chrome".equals(browser)) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(obj);

            } else if ("chrome-headless".equals(browser)) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;

        }
    }
}
