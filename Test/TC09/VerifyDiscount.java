package BaiTap.Test.TC09;
import BaiTap.modelpage.CompareMoblePage;
import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import BaiTap.modelpage.GuruLoginPage;
import BaiTap.modelpage.MobilePage;
import org.testng.Assert;
@Test
public class VerifyDiscount {
    public static void TestDiscount(){
        WebDriver driver = driverFactory.getChromeDriver();
        try{
            MobilePage mobilePage = new MobilePage(driver);
            CompareMoblePage CompareMoblePage = new CompareMoblePage(driver);
            driver.get("http://live.techpanda.org/");
            // Step 2: Click on my account link
            GuruLoginPage loginPage = new GuruLoginPage(driver);
            loginPage.ClickAccountButton();
            loginPage.ClickMyAccountLink();
            // Step 3: Login
            loginPage.login("cus123@gmail.com", "123456");
            loginPage.ClickAccountButton();
            //Step 4: Go to Mobie and Add iphone to cart
            CompareMoblePage.goToMobilePage();
            mobilePage.addToCartIphone();
            Thread.sleep(2000);
            //Step 5 : enter Discount code
            WebElement inputDiscount = driver.findElement(By.xpath("//input[@id='coupon_code']"));
            WebElement applyButton = driver.findElement(By.xpath("//span[contains(text(),'Apply')]"));
            inputDiscount.clear();
            inputDiscount.sendKeys("GURU50");
            applyButton.click();
            Thread.sleep(2000);
            //Step 6: Verify discount
            WebElement ActualDiscount = driver
                    .findElement(By.xpath("(//td[@colspan='1'])[3]"));
            String ExpectedDiscount = "DISCOUNT (GURU50)";
            Assert.assertNotEquals(ActualDiscount.getText(), ExpectedDiscount);

            // Assert that the actual discount matches the expected discount
        }catch(Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
}
