package HRM;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity2 {

        WebDriver driver;

        @BeforeTest
        public void setUp() {
            WebDriverManager.chromedriver().setup();
            //Create a new instance of the Firefox driver
            driver = new ChromeDriver();
            // Open the URL
            driver.get("http://alchemy.hguy.co/orangehrm");
        }

        @Test
        public void getHeaderImageURL() {
            // Get the URL of the header image using different selectors
            //WebElement headerImage = driver.findElement(By.cssSelector("img[src*='header']")); // Using CSS Selector
            // or
            WebElement headerImage = driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img")); // Using XPath

            String headerImageURL = headerImage.getAttribute("src");

            // Print the URL to the console
            System.out.println("Header Image URL: " + headerImageURL);
        }

        @AfterTest
        public void tearDown() {
            driver.quit();
        }
    }


