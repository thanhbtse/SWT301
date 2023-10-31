package BaiTap.Test.TC6;

import BaiTap.modelpage.CartPage;
import BaiTap.modelpage.CheckoutPage;
import BaiTap.modelpage.GuruLoginPage;
import driver.driverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

@Test
public class Verifyuserisabletopurchaseproductusingregisteredemailid {
   public static  void  Testing(){
       WebDriver driver = driverFactory.getChromeDriver();
       try {
           // Step 1: Go to the website
           driver.get("http://live.techpanda.org/");

           // Step 2: Click on my account link
           GuruLoginPage loginPage = new GuruLoginPage(driver);
           loginPage.ClickAccountButton();
           loginPage.ClickMyAccountLink();

           // Step 3: Login
           loginPage.login("cus123@gmail.com", "123456");
           loginPage.ClickAccountButton(); // Are you sure you want to click this again?

           // Step 4: Click to wishlist
           CartPage cartPage = new CartPage(driver);
           cartPage.ClickWishListLink();

           // Step 5: Add to cart
           cartPage.AddToCartInWishList();

           // Step 6-7: Enter shipping details and estimate shipping cost
           CheckoutPage checkoutPage = new CheckoutPage(driver);
           checkoutPage.enterShippingDetails("United States", "California", "12345");

           // Step 8: Verify Shipping cost generated
           checkoutPage.verifyShippingCost();

           // Step 9: Select Shipping Cost and Update Total
           checkoutPage.updateTotal();

           // Step 10: Proceed to Checkout
           checkoutPage.proceedToCheckout();

           // Step 11-14: Enter billing information, shipping information, select payment, and place the order
           checkoutPage.enterBillingInformation("New Address", "123 Street", "City", "State", "12345", "United States", "123456789");
           checkoutPage.enterShippingInformation("New Address", "123 Street", "City", "State", "12345", "United States", "123456789");
           checkoutPage.ShippingMethodContinue();
           checkoutPage.selectPaymentInformationAndContinue();
           checkoutPage.placeOrder();
            Thread.sleep(2000);
       } catch (Exception e) {
           e.printStackTrace();
       } finally {
           driver.quit();
       }
   }
}
