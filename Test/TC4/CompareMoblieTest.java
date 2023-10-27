package BaiTap.Test.TC4;
import BaiTap.modelpage.CompareMoblePage;
import BaiTap.modelpage.ComparisonPopup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
@Test
public class CompareMoblieTest {
    private WebDriver driver;
    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
    }
    public void testCompareMobiles() {
        try {
            driver.get("http://live.techpanda.org/");

            // Create instances of our MobilePage and ComparisonPopup
            CompareMoblePage CompareMoblePage = new CompareMoblePage(driver);
            ComparisonPopup comparisonPopup = new ComparisonPopup(driver);

            // Use MobilePage for operations
            CompareMoblePage.goToMobilePage();
            CompareMoblePage.addSonyXperiaToCompare();
            CompareMoblePage.addIPhoneToCompare();
            CompareMoblePage.clickCompare();
            Thread.sleep(5000);
            // Switch to popup window
            String mainWindow = driver.getWindowHandle();
            for (String handle : driver.getWindowHandles()) {
                if (!handle.equals(mainWindow)) {
                    driver.switchTo().window(handle);
                    break;
                }
            }

            // Use ComparisonPopup to verify products and close
            comparisonPopup.verifyProducts();
            comparisonPopup.closePopup();
            Thread.sleep(5000);
            // Switch back to main window
            driver.switchTo().window(mainWindow);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
    }

