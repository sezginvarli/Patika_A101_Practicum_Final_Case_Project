package tests;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import utilities.*;

import java.time.Duration;

public class TestWithoutLogin extends BasePage {


    HomePage homePage;
    LoginPage loginPage;
    ProductPage productPage;
    Actions actions;


    public void selectProductWithoutLogin() {

        PropertyConfigurator.configure("log4j.properties");
        Log4j.startLog("Test işlemi başlar");

        homePage = new HomePage();
        loginPage = new LoginPage();
        productPage = new ProductPage();
        actions = new Actions(Driver.getDriver());


        Log4j.info("Kullanıcı giriş sayfasına gider  PASS");
        homePage.cerez.click();
        homePage.searchBox.sendKeys(ConfigReader.getProperty("product") + Keys.ENTER);
        Log4j.info("Kullanıcı arama kutusuna ürünü yazar PASS");
        homePage.product.click();
        Log4j.info("Kullanıcı ürünü seçer PASS");
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        ReusableMethods.switchDriver();
        String productTitle = productPage.productName.getText();
        productPage.addToButton.click();
        Log4j.info("Kullanıcı ürünü sepete ekler PASS");
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        JSUtils.clickElementByJS(productPage.popupCloseButton);
        productPage.anotherSellerButton.click();
        Log4j.info("Kullanıcı aynı ürünü başka bir satıcıdan sepete ekler PASS");
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        JSUtils.clickElementByJS(productPage.goToAddButton);
        Log4j.info("Kullanıcı sepete gider PASS");
        String productOneTitle = productPage.productOne.getText();
        String productTwoTitle = productPage.productTwo.getText();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        Assert.assertEquals(productTitle, productOneTitle);
        Assert.assertEquals(productTitle, productTwoTitle);
        Log4j.info("Kullanıcı seçtiği ürünlerin sepete doğrulamasını yapar PASS");
        Log4j.endLog("end");

    }

}
