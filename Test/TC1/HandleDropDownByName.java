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
        Select selectOption;
        try {
            driver.get("http://live.techpanda.org/index.php/mobile.html");
            WebElement dropdownElement = driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > select:nth-child(2)"));
            selectOption = new Select(dropdownElement);
            selectOption.selectByVisibleText("Position");
            selectOption.selectByVisibleText("Name");
            selectOption.selectByVisibleText("Price");
            selectOption.selectByValue("http://live.techpanda.org/index.php/mobile.html?dir=asc&order=position");
            selectOption.selectByValue("http://live.techpanda.org/index.php/mobile.html?dir=asc&order=name");
            selectOption.selectByValue("http://live.techpanda.org/index.php/mobile.html?dir=asc&order=price");
            Thread.sleep(5000);
        } catch(Exception e){
            e.printStackTrace();
        }
        driver.close();
        driver.quit();
    }
}
