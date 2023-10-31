package BaiTap.modelpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GuruLoginPage {
    private WebDriver driver;
    private By AccountButton = By.xpath("//span[@class='label'][normalize-space()='Account']");
    private By MyAccountLink = By.xpath("//div[@id='header-account']//a[@title='My Account'][normalize-space()='My Account']");
    public GuruLoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void ClickAccountButton(){driver.findElement(AccountButton).click();}
    public void ClickMyAccountLink(){driver.findElement(MyAccountLink).click();}
    public void login(String email, String password) {
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("pass")).sendKeys(password);
        driver.findElement(By.id("send2")).click();
    }
}

