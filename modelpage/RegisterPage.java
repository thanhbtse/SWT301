package BaiTap.modelpage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
public class RegisterPage {
    private WebDriver driver;

    // Locators
    private By accountLink = By.linkText("my account");
    private By createAccountLink = By.linkText("Create an Account");
    private By registerButton = By.xpath("//span[contains(text(),'Register')]");  // Assuming the ID, adjust as needed.
    // ... other locators for user information fields ...
    private By firstNameField = By.name("firstname"); // Assuming the name attribute. Adjust as necessary.
    private By middleNameField = By.name("middlename");
    private By lastNameField = By.name("lastname");
    private By emailField = By.name("email");
    private By passwordField = By.name("password");
    private By confirmPasswordField = By.name("confirmation");
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openAccountPage() {
        driver.findElement(accountLink).click();
    }

    public void openRegistration() {
        driver.findElement(createAccountLink).click();
    }

    public void fillUserInfo(String firstName, String middleName, String lastName, String email, String password, String confirmPassword) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(middleNameField).sendKeys(middleName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
    }
    public void clickRegister() {
        driver.findElement(registerButton).click();
    }

}
