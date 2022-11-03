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

public class TestWithUserLogin extends BasePage {

    HomePage homePage;
    LoginPage loginPage;
    ProductPage productPage;
    Actions actions;

    public void selectProductWithLogin() {

        PropertyConfigurator.configure("log4j.properties");
        Log4j.startLog("start");

        homePage = new HomePage();
        loginPage = new LoginPage();
        productPage = new ProductPage();
        actions = new Actions(Driver.getDriver());


        Log4j.info("Kullanıcı giriş sayfasına gider  PASS");
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        homePage.cerez.click();
        Log4j.info("Kullanıcı çerezleri kabul eder PASS");
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        actions.moveToElement(homePage.girisYapButton).perform();
        Log4j.info("Kullanıcı giriş yap butonuna yönlenir PASS");
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        homePage.girisYapLinkButton.click();
        Log4j.info("Kullanıcı giriş yap butonuna tıklar PASS");
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        loginPage.usernameBox.sendKeys(ConfigReader.getProperty("username") + Keys.ENTER);
        Log4j.info("Kullanıcı adı girilir PASS");
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("password") + Keys.ENTER);
        Log4j.info("Kullanıcı şifre girer PASS");
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        String actualUsername = loginPage.userinfo.getText();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        Assert.assertEquals(actualUsername, "Hesabım");
        Log4j.info("Kullanıcı giriş işlemi doğrulanır PASS");
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
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
        productPage.popupCloseButton.click();
        productPage.anotherSellerButton.click();
        Log4j.info("Kullanıcı aynı ürünü başka bir satıcıdan sepete ekler PASS");
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        JSUtils.clickElementByJS(productPage.goToAddButton);
        Log4j.info("Kullanıcı sepete gider PASS");
        String productOneTitle = productPage.productOne.getText();
        String productTwoTitle = productPage.productTwo.getText();
        Assert.assertEquals(productTitle, productOneTitle);
        Assert.assertEquals(productTitle, productTwoTitle);
        Log4j.info("Kullanıcı seçtiği ürünlerin sepete doğrulamasını yapar PASS");

    }

}
