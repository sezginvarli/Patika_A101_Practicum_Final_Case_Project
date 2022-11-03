package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ProductPage {

    public ProductPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h1[@id='product-name']")
    public WebElement productName;
    @FindBy(xpath = "//button[@id='addToCart']")
    public WebElement addToButton;

    @FindBy(xpath="//a[contains(@class,'checkoutui-Modal')]")
    public WebElement popupCloseButton;

    @FindBy(xpath = "(//button[@class='add-to-basket button small'])[1]")
    public WebElement anotherSellerButton;

    @FindBy(xpath = "//button[text()='Sepete git']")
    public WebElement goToAddButton;

    @FindBy(xpath = "(//div[@class='product_name_3Lh3t'])[1]")
    public WebElement productOne;

    @FindBy(xpath = "(//div[@class='product_name_3Lh3t'])[2]")
    public WebElement productTwo;

}
