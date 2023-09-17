package HRM;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.List;

public class Activity9 {
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
    public void retrieveEmergencyContacts() {
        // Login with credentials
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();

        // Navigate to "My Info" using different selectors
        driver.findElement(By.linkText("My Info")).click(); // Using Link Text
        // Click on "Emergency Contacts"
        driver.findElement(By.linkText("Emergency Contacts")).click();

        // Retrieve and print information about all contacts listed in the table
        List<WebElement> contactRows = driver.findElements(By.cssSelector("table#emgcontact_list tbody tr"));
        List<String> contactInfo;

        for (int i = 0; i < contactRows.size(); i++) {
            WebElement row = contactRows.get(i);
            List<WebElement> columns = row.findElements(By.tagName("td"));

            String contactName = columns.get(1).getText();
            String contactRelationship = columns.get(2).getText();
            String contactHomePhone = columns.get(3).getText();
            String contactMobilePhone = columns.get(4).getText();
            String contactWorkPhone = columns.get(5).getText();

            contactInfo = List.of(
                    "Name: " + contactName,
                    "Relationship: " + contactRelationship,
                    "Home Phone: " + contactHomePhone,
                    "Mobile Phone: " + contactMobilePhone,
                    "Work Phone: " + contactWorkPhone
            );

            System.out.println("Contact Information:");
            for (String info : contactInfo) {
                System.out.println(info);
            }
            System.out.println();
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}