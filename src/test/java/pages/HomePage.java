package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    public WebElement cerez;

    @FindBy(xpath = "//div[@id='myAccount']")
    public WebElement girisYapButton;

    @FindBy(xpath = "//a[@id='login']")
    public WebElement girisYapLinkButton;

    @FindBy(xpath = "//input[@class='desktopOldAutosuggestTheme-UyU36RyhCTcuRs_sXL9b']")
    public WebElement searchBox;

    @FindBy(xpath = "//div[@class='SearchBoxOld-cHxjyU99nxdIaAbGyX7F']")
    public WebElement searchButton;

    @FindBy(xpath = "//a[@href='/caykur-tiryaki-1000-gr-dokme-cay-p-ZYSERK690105000436']")
    public WebElement product;

}
