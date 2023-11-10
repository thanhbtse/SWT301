package BaiTap.Test.TC07;

import org.testng.annotations.Test;
import BaiTap.modelpage.GuruLoginPage;
import BaiTap.modelpage.CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
@Test
public class VerifyPDF {
    private WebDriver driver;
    public void savePreviouslyPlacedOrderAsAPdfFile(){
        try {
            driver = new ChromeDriver();

            driver.get("http://live.techpanda.org");
            CartPage cartPage = new CartPage(driver);
            // Login with the account using previously created credential
            GuruLoginPage loginPage = new GuruLoginPage(driver);
            loginPage.ClickAccountButton();
            loginPage.ClickMyAccountLink();
            // Step 3: Login
            loginPage.login("cus123@gmail.com", "123456");
            loginPage.ClickAccountButton();
            // View order and choose print the order
            cartPage.ClickViewOrder();
            cartPage.ClickPrintOrder();
            // wait the popup appears
            Thread.sleep(5000);
            //choose the option
            WebElement saveAsPdfLink = driver.findElement(By.linkText("Lưu dưới dạng PDF"));
            saveAsPdfLink.click();
            Thread.sleep(2000);
        }
        catch (Exception e){
            driver.quit();
        }
    }
}
