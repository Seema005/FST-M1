package HRM;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.testng.Assert;
        import org.testng.annotations.AfterTest;
        import org.testng.annotations.BeforeTest;
        import org.testng.annotations.Test;

public class Activity1{

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // Open the URL
        driver.get("http://alchemy.hguy.co/orangehrm");
    }

    @Test
    public void verifyWebsiteTitle() {
        // Get the title of the website
        String actualTitle = driver.getTitle();

        // Expected title
        String expectedTitle = "OrangeHRM";

        // Verify the title matches exactly
        Assert.assertEquals(actualTitle, expectedTitle, "Title doesn't match");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
