package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='txtUserName']")
    public WebElement usernameBox;

    @FindBy(xpath = "//input[@id='txtPassword']")
    public WebElement passwordBox;

    @FindBy(xpath = "//*[@id=\"myAccount\"]/span/a/span[1]")
    public WebElement userinfo;

}
