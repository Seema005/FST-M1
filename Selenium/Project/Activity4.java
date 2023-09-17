package HRM;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity4 {

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
    public void addNewEmployee() {
        // Login with credentials
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();

        // Click on PIM option in the menu
        driver.findElement(By.linkText("PIM")).click();

        // Click the Add button to add a new Employee
        driver.findElement(By.id("menu_pim_addEmployee")).click();

        // Fill in the required fields
        driver.findElement(By.id("firstName")).sendKeys("John");
        driver.findElement(By.id("lastName")).sendKeys("Doe");
        String empId = driver.findElement(By.id("employeeId")).getAttribute("value"); // Get Employee ID for verification
        driver.findElement(By.id("btnSave")).click();

        // Verify the creation of the employee
        driver.findElement(By.linkText("Employee List")).click();
        driver.findElement(By.id("empsearch_id")).sendKeys(empId);
        driver.findElement(By.id("searchBtn")).click();
        WebElement empIdElement = driver.findElement(By.xpath("//a[text()='" + empId + "']"));
        Assert.assertNotNull(empIdElement, "New employee not found in the list");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}


