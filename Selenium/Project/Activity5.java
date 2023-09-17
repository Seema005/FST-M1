package HRM;


    import io.github.bonigarcia.wdm.WebDriverManager;
    import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity5 {

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
        public void editUserInfo() {
            // Login with credentials
            driver.findElement(By.id("txtUsername")).sendKeys("orange");
            driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
            driver.findElement(By.id("btnLogin")).click();

            // Click on "My Info" menu item
            driver.findElement(By.linkText("My Info")).click();

            // Click the Edit button
            driver.findElement(By.id("btnSave")).click();

            // Fill in the Name, Gender, Nationality, and DOB fields
            driver.findElement(By.id("personal_txtEmpFirstName")).clear();
            driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys("John");

            driver.findElement(By.cssSelector("input[name='personal[txtEmpLastName]']")).clear();
            driver.findElement(By.cssSelector("input[name='personal[txtEmpLastName]']")).sendKeys("Doe");

            driver.findElement(By.id("personal_optGender_1")).click();

            driver.findElement(By.id("personal_cmbNation")).sendKeys("United States");

            driver.findElement(By.id("personal_DOB")).sendKeys("1990-01-01");

            // Click Save
            driver.findElement(By.id("btnSave")).click();
        }

        @AfterTest
        public void tearDown() {
            driver.quit();
        }
    }


