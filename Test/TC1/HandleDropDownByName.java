package BaiTap.Test.TC1;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

@Test
public class HandleDropDownByName {
    public static void TestHandleDropDownByName() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            driver.get("http://live.techpanda.org/index.php/mobile.html");
            WebElement dropdownElement = driver.findElement(By.xpath("//body/div[@class='wrapper']/div[@class='page']/div[@class='main-container col3-layout']/div[@class='main']/div[@class='col-wrapper']/div[@class='col-main']/div[@class='category-products']/div[@class='toolbar']/div[@class='sorter']/div[@class='sort-by']/select[1]"));
            Select selectOption = new Select(dropdownElement);
            selectOption.selectByVisibleText("Name");
            Thread.sleep(2000);
        } catch(Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
}
