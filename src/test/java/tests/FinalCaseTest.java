package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.security.Key;
import java.time.Duration;

public class FinalCaseTest {

    HomePage homePage;
    LoginPage loginPage;
    ProductPage productPage;
    Actions actions;


    @Test
    public void selectProductWithLogin() throws InterruptedException {

        homePage = new HomePage();
        loginPage = new LoginPage();
        productPage=new ProductPage();
        actions = new Actions(Driver.getDriver());


        Driver.getDriver().get(ConfigReader.getProperty("hepsiburada_url"));

        homePage.cerez.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        actions.moveToElement(homePage.girisYapButton).perform();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        homePage.girisYapLinkButton.click();

        loginPage.usernameBox.sendKeys(ConfigReader.getProperty("username") + Keys.ENTER);
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("password") + Keys.ENTER);
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        homePage.searchBox.sendKeys(ConfigReader.getProperty("product") + Keys.ENTER);
        homePage.product.click();

     //   String productTitle = productPage.productName.getText();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        productPage.addToButton.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        productPage.popupCloseButton.click();
        productPage.anotherSellerButton.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        productPage.goToAddButton.click();
        String productOneTitle = productPage.productOne.getText();
        String productTwoTitle = productPage.productTwo.getText();

//        Assert.assertEquals(productTitle, productOneTitle);
//        Assert.assertEquals(productTitle, productTwoTitle);


    }

}
