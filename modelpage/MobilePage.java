package BaiTap.modelpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
public class MobilePage {
    private WebDriver driver;
    private By addToCartSonyXperiaButton = By.xpath("//li[2]//div[1]//div[3]//button[1]");
    private By qtyField = By.xpath("//input[@title='Qty']");
    private By updateButton = By.xpath("//button[@title='Update']//span//span[contains(text(),'Update')]");
    private By errorMessage = By.className("error-msg");
    private By emptyCartLink = By.linkText("EMPTY CART");
    private By AddToCartIphone = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/ul[1]/li[1]/div[1]/div[3]/button[1]/span[1]/span[1]");

    public MobilePage(WebDriver driver) {
        this.driver = driver;
    }
    public void addToCartIphone(){
        driver.findElement(AddToCartIphone).click();
    }
    public void addToCartSonyXperia() {
        driver.findElement(addToCartSonyXperiaButton).click();
    }

    public void updateQuantity(String quantity) {
        driver.findElement(qtyField).clear();
        driver.findElement(qtyField).sendKeys(quantity);
        driver.findElement(updateButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public void clickEmptyCart() {
        driver.findElement(emptyCartLink).click();
    }


}
