package BaiTap.Test.TC5;
import BaiTap.modelpage.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class VerifyCreateAccountAndShareWishList {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void testRegistrationAndWishlistSharing() {
        try {
            driver.get("http://live.techpanda.org/");

            // Register
            RegisterPage registerPage = new RegisterPage(driver);
            registerPage.openAccountPage();
            registerPage.openRegistration();
           // registerPage.fillUserInfo();
            registerPage.clickRegister();
            // Check registration successful
            // This assumes there's a confirmation message or element you can check. Adjust as necessary.
            Assert.assertTrue(driver.getPageSource().contains("account registration done"));

            // Go to TV menu and add product to wishlist
            driver.findElement(By.linkText("TV")).click();
            driver.findElement(By.xpath("//a[text()='LG LCD']/following-sibling::a[text()='Add to Wishlist']")).click();

            // Share wishlist
            driver.findElement(By.linkText("SHARE WISHLIST")).click();
            // Assuming placeholders for email and message fields. Adjust XPath or locators as necessary.
            driver.findElement(By.name("email")).sendKeys("someone@example.com");
            driver.findElement(By.name("message")).sendKeys("Check out this wishlist!");
            driver.findElement(By.linkText("SHARE WISHLIST")).click();

            // Check wishlist shared
            // Adjust this based on the confirmation message or element after sharing.
            Assert.assertTrue(driver.getPageSource().contains("wishlist shared successfully"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
