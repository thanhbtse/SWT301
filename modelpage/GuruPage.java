package BaiTap.modelpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GuruPage {
    private WebDriver driver;

    private By MobileSelector = By.id("level0 nav-1 first");

    public GuruPage(WebDriver driver){
        this.driver=driver;
    }

    public WebElement MobiePageLink(){
        return  driver.findElement(MobileSelector);
    }

    public void clickMobileLink(){
        MobiePageLink().click();
    }
}
