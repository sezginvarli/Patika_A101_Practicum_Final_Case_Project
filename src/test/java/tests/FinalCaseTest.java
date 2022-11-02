package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import utilities.ConfigReader;
import utilities.Driver;


import java.time.Duration;
import java.util.Set;


public class FinalCaseTest {
    static Logger logger = LogManager.getLogger(FinalCaseTest.class.getName());
    HomePage homePage;
    LoginPage loginPage;
    ProductPage productPage;
    Actions actions;


    @Test
    public void selectProductWithLogin() throws InterruptedException {

        homePage = new HomePage();
        loginPage = new LoginPage();
        productPage = new ProductPage();
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


        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        String window1Handle = Driver.getDriver().getWindowHandle();

        Set<String> allWindows = Driver.getDriver().getWindowHandles();

        for (String eachHandle : allWindows) {

            if (!eachHandle.equals(window1Handle)) {
                Driver.getDriver().switchTo().window(eachHandle);
            }
        }


        String productTitle = productPage.productName.getText();
        productPage.addToButton.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        productPage.popupCloseButton.click();
        productPage.anotherSellerButton.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        productPage.goToAddButton.click();
        String productOneTitle = productPage.productOne.getText();
        String productTwoTitle = productPage.productTwo.getText();

        Assert.assertEquals(productTitle, productOneTitle);
        Assert.assertEquals(productTitle, productTwoTitle);

        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        actions.moveToElement(homePage.girisYapButton).perform();
        homePage.signoutButton.click();
    }

    @Test
    public void selectProductWithoutLogin() {

        homePage = new HomePage();
        loginPage = new LoginPage();
        productPage = new ProductPage();
        actions = new Actions(Driver.getDriver());

        Driver.getDriver().get(ConfigReader.getProperty("hepsiburada_url"));

        homePage.cerez.click();
        homePage.searchBox.sendKeys(ConfigReader.getProperty("product") + Keys.ENTER);
        homePage.product.click();


        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //      GET WINDOW 1 HANDLE
        String window1Handle = Driver.getDriver().getWindowHandle();
        //    System.out.println("window1Handle = " + window1Handle);

        //      NEW TAB OPENS SO WE NEED TO SWITCH TO THAT WINDOW PERFORM TEST ON THE PAGE
        Set<String> allWindows = Driver.getDriver().getWindowHandles();
        //       System.out.println(allWindows);

        for (String eachHandle : allWindows) {

            if (!eachHandle.equals(window1Handle)) {
                Driver.getDriver().switchTo().window(eachHandle); //This will take driver to the next page
            }
        }


        String productTitle = productPage.productName.getText();
        productPage.addToButton.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        productPage.popupCloseButton.click();
        productPage.anotherSellerButton.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        productPage.goToAddButton.click();
        String productOneTitle = productPage.productOne.getText();
        String productTwoTitle = productPage.productTwo.getText();

        Assert.assertEquals(productTitle, productOneTitle);
        Assert.assertEquals(productTitle, productTwoTitle);


    }

}
