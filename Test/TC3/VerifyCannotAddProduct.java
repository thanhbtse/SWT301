package BaiTap.Test.TC3;

import driver.driverFactory;
import BaiTap.modelpage.CartPage;
import BaiTap.modelpage.MobilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.junit.Assert;
import org.testng.annotations.Test;

@Test
public class VerifyCannotAddProduct {
    public static void TestAddProduct() {
        WebDriver driver = driverFactory.getChromeDriver();
        try{
            driver.get("http://live.techpanda.org/");

            MobilePage mobilePage = new MobilePage(driver);
            CartPage cartPage = new CartPage(driver);

            // Click on MOBILE menu
            driver.findElement(By.linkText("MOBILE")).click();

            // Add Sony Xperia to cart
            mobilePage.addToCartSonyXperia();

            // Update quantity and verify error message
            mobilePage.updateQuantity("1000");
            String expectedMessage = "The requested quantity for Sony Xperia is not available.";
            Assert.assertEquals(expectedMessage, mobilePage.getErrorMessage());

            // Empty cart and verify cart is empty
            mobilePage.clickEmptyCart();
            String expectedEmptyMessage = "SHOPPING CART IS EMPTY";
            Assert.assertEquals(expectedEmptyMessage, cartPage.getCartMessage());
        }catch(Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
}
