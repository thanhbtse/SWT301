package BaiTap.modelpage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
public class WishListPage {
    private WebDriver driver;

    // Locators
    private By tvLink = By.linkText("TV");
    private By lgLcdAddToWishlistLink = By.xpath("//li[2]//div[1]//div[3]//ul[1]//li[1]//a[1]");
    private By shareWishlistButton = By.linkText("SHARE WISHLIST");
    // ... locators for the email field, message field, and share button on the wishlist sharing page ...

    public void WishlistPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToTVPage() {
        driver.findElement(tvLink).click();
    }

    public void addLgLcdToWishlist() {
        driver.findElement(lgLcdAddToWishlistLink).click();
    }

    public void shareWishlist(String email, String message) {
        driver.findElement(shareWishlistButton).click();
        // Fill in the email and message, then click the share button.
    }
}
