package Activity;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class Activity1 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // Navigate to the website
        driver.get("https://v1.training-support.net");
    }

    @Test
    public void testPageTitleAndAboutUs() {
        // Get and print the title of the page
        String pageTitle = driver.getTitle();
        System.out.println("Page title is: " + pageTitle);

        // Assert that the title of the page is "Training Support"
        Assert.assertEquals(pageTitle, "Training Support", "Page title is not as expected.");

        // Find the "About Us" button on the page and click it
        driver.findElement(By.linkText("About Us")).click();

        // Get and print the title of the new page
        String newPageTitle = driver.getTitle();
        System.out.println("New page title is: " + newPageTitle);

        // Assert the title of the new page
        Assert.assertEquals(newPageTitle, "About Training Support", "New page title is not as expected.");
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.close();
    }
}
