package BaiTap.Test.TC2;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


@Test
public class RightClickMobie {
    public static void TestRightClickMobie(){
        WebDriver driver = driverFactory.getChromeDriver();
        try{
            driver.get("http://live.techpanda.org/index.php/");
            By clickMobieLinkText = By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > header:nth-child(2) > div:nth-child(1) > div:nth-child(4) > nav:nth-child(1) > ol:nth-child(1) > li:nth-child(1) > a:nth-child(1)");
            WebElement linkTextElem = driver.findElement(clickMobieLinkText);
            linkTextElem.click();
            Thread.sleep(2000);

        }catch(Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
}
