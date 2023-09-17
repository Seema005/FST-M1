package HRM;


    import io.github.bonigarcia.wdm.WebDriverManager;
    import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity8 {

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
        public void applyForLeave() {
            // Login with credentials
            driver.findElement(By.id("txtUsername")).sendKeys("orange");
            driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
            driver.findElement(By.id("btnLogin")).click();

            // Navigate to the Dashboard page
            driver.findElement(By.linkText("Dashboard")).click();

            // Click on the "Apply Leave" option
            driver.findElement(By.xpath("//img[contains(@src, '/orangehrm/symfony/web/webres_5d69118beeec64.10301452/orangehrmLeavePlugin/images/ApplyLeave.png')]\n")).click();

            driver.findElement(By.cssSelector("a#menu_leave_applyLeave")).click();

            driver.findElement(By.id("applyleave_txtFromDate")).sendKeys("2023-09-01");
            driver.findElement(By.id("applyleave_txtToDate")).sendKeys("2023-09-02");

            // Click Apply
            driver.findElement(By.id("applyBtn")).click();

            // Navigate to My Leave page to check the status
            driver.findElement(By.linkText("My Leave")).click();

            // You can add further verification logic here if needed
        }

        @AfterTest
        public void tearDown() {
            driver.quit();
        }

}
