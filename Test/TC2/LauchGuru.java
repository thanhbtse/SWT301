package BaiTap.Test.TC2;

import driver.driverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

@Test
public class LauchGuru {
        public static void testLauchGuru(){
            WebDriver driver = driverFactory.getChromeDriver();
            driver.get("http://live.techpanda.org/index.php/");
            try{
                Thread.sleep(2000);
            }catch(Exception ignored){
            }
            driver.close();
            driver.quit();
    }
}
