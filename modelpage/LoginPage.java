package BaiTap.modelpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    // Declare element selector value here
    private By emailSelector = By.id("email");
    private By passwordSelector = By.id("pass");
    private By loginBtnSelector = By.cssSelector("#send2");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Getter to return element on the page
    public WebElement email() {
        return driver.findElement(emailSelector);
    }

    public WebElement password() {
        return driver.findElement(passwordSelector);
    }

    public WebElement loginBtn() {
        return driver.findElement(loginBtnSelector);
    }

    public void inputUserEmail(String email){
        WebElement emailElem = driver.findElement(emailSelector);
        emailElem.sendKeys(email);
    }

    public void inputPassword(String password){
        password().sendKeys(password);
    }

    public void clickOnLoginBtn(){
        loginBtn().click();
    }
}
