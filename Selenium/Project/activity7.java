package HRM;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class activity7 {

    WebDriver driver;

    @BeforeMethod
        public void setUp() {
        WebDriverManager.chromedriver().setup();
        //Create a new instance of the Firefox driver
        driver = new ChromeDriver();
            // Open the URL
            driver.get("http://alchemy.hguy.co/orangehrm");
        }

        @Test
        public void loginToOrangeHRM() {
            // Login with credentials
            driver.findElement(By.id("txtUsername")).sendKeys("orange");
            driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
            driver.findElement(By.id("btnLogin")).click();
            // Find "My Info" and click
            driver.findElement(By.cssSelector("a[id='menu_pim_viewMyDetails']")).click(); // Using CSS Selector

            // Find "Qualifications" and click
            driver.findElement(By.linkText("Qualifications")).click();

            // Click "Add" for Work Experience
            driver.findElement(By.id("addWorkExperience")).click();
            // Fill out the work experience details
            driver.findElement(By.id("experience_employer")).sendKeys("Example Employer");
            driver.findElement(By.id("experience_jobtitle")).sendKeys("Example Job Title");
            driver.findElement(By.id("experience_from_date")).sendKeys("2023-08-16");
            driver.findElement(By.id("experience_to_date")).sendKeys("2023-08-18");
            driver.findElement(By.id("experience_comments")).sendKeys("Example comments");

            // Click "Save"
            driver.findElement(By.id("btnWorkExpSave")).click();
        }
    @AfterTest
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
    }


