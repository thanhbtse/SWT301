package BaiTap.modelpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class GuruPage {
    private WebDriver driver;

    // Locators
    private By mobileLink = By.linkText("MOBILE");
    private By sortByDropdown = By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > select:nth-child(2)");  // This XPath is an assumption.

    public GuruPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToMobilePage() {
        driver.findElement(mobileLink).click();
    }

    public void sortBy(String criteria) {
        Select dropdown = new Select(driver.findElement(sortByDropdown));
        dropdown.selectByVisibleText(criteria);
    }

    // Add more methods as necessary, like one to retrieve the list of product names to verify sorting.
}

