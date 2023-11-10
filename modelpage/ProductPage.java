package BaiTap.modelpage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.testng.Assert;
public class ProductPage {
    private final WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickReorderLink() {
        WebElement reorderLink = driver.findElement(By.xpath("//tr[@class='last even']//a[@class='link-reorder'][normalize-space()='Reorder']"));
        reorderLink.click();
    }

    public void updateQuantity(String qty) {
        WebElement qtyInput = driver.findElement(By.name("qty"));
        qtyInput.clear();
        qtyInput.sendKeys(qty);
    }

    public void clickUpdateButton() {
        WebElement updateButton = driver.findElement(By.xpath("//button[@title='Update']//span//span[contains(text(),'Update')]"));
        updateButton.click();
    }

    public void verifyGrandTotal(String expectedGrandTotal) {
        WebElement grandTotal = driver.findElement(By.xpath("//strong[normalize-space()='Grand Total']"));
        String actualGrandTotal = grandTotal.getText();
        Assert.assertEquals(actualGrandTotal, expectedGrandTotal, "Grand Total is not as expected.");
    }


    public void enterBillingInformation(String newAddress, String address, String city, String state, String zip, String country, String telephone) {
        driver.findElement(By.id("billing-address-select")).sendKeys(newAddress);
        driver.findElement(By.id("billing:street1")).sendKeys(address);
        driver.findElement(By.id("billing:city")).sendKeys(city);
        driver.findElement(By.id("billing:region_id")).sendKeys(state);
        driver.findElement(By.id("billing:postcode")).sendKeys(zip);
        driver.findElement(By.id("billing:country_id")).sendKeys(country);
        driver.findElement(By.id("billing:telephone")).sendKeys(telephone);
        driver.findElement(By.xpath("//label[@for='billing:use_for_shipping_no']")).click();
        driver.findElement(By.xpath("//button[@onclick='billing.save()']//span//span[contains(text(),'Continue')]")).click();
    }
    public void enterShippingInformation(String newAddress, String address, String city, String state, String zip, String country, String telephone) {
        driver.findElement(By.id("shipping-address-select")).sendKeys(newAddress);
        driver.findElement(By.id("shipping:street1")).sendKeys(address);
        driver.findElement(By.id("shipping:city")).sendKeys(city);
        driver.findElement(By.id("shipping:region_id")).sendKeys(state);
        driver.findElement(By.id("shipping:postcode")).sendKeys(zip);
        driver.findElement(By.id("shipping:country_id")).sendKeys(country);
        driver.findElement(By.id("shipping:telephone")).sendKeys(telephone);
        driver.findElement(By.xpath("//label[@for='shipping:same_as_billing']")).click();
        driver.findElement(By.xpath("//button[@onclick='shipping.save()']//span//span[contains(text(),'Continue')]")).click();
    }

    public void clickPlaceOrderButton() {
        WebElement placeOrderButton = driver.findElement(By.xpath("//button[@title='Place Order']"));
        placeOrderButton.click();
    }

    public String getOrderNumber() {
        WebElement orderNumberElement = driver.findElement(By.xpath("//p[contains(text(),'Your order number is:')]"));
        String orderNumberText = orderNumberElement.getText();
        return orderNumberText.replaceAll("\\D", ""); // Extract the order number
    }
}

