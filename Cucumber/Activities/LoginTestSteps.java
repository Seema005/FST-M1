package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTestSteps {
    private WebDriver driver;
    private WebDriverWait wait;

    @Given("^User is on Login page$")
    public void userIsOnLoginPage() {
        // Set up Firefox driver
        //Create a new instance of the Firefox driver
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\003L24744\\Downloads\\geckodriver-v0.33.0-win64\\geckodriver.exe");

        driver = new FirefoxDriver();

        // driver = new FirefoxDriver(capabilities);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Open browser and navigate to the login page
        driver.get("https://v1.training-support.net/selenium/login-form");
    }

   /* @When("User enters {string} and {string}")
    public void user_enters_and(String username, String password) throws Throwable {
        //Enter username from Feature file
        driver.findElement(By.id("username")).sendKeys(username);
        //Enter password from Feature file
        driver.findElement(By.id("password")).sendKeys(password);
        //Click Login
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }*/
   @When("User enters {string} and {string}")
   public void user_enters_and(String username, String password) throws Throwable {
       //Enter username from Feature file
       driver.findElement(By.id("username")).sendKeys(username);
       //Enter password from Feature file
       driver.findElement(By.id("password")).sendKeys(password);
       //Click Login
       driver.findElement(By.xpath("//button[@type='submit']")).click();
   }
    @Then("^Read the page title and confirmation message$")
    public void readPageTitleAndConfirmationMessage() {
        // Wait for the confirmation message element to be visible
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation")));

        // Get the page title and confirmation message text
        String pageTitle = driver.getTitle();
        String loginMessage = confirmationMessage.getText();

        // Print out the page title and login message
        System.out.println("Page Title: " + pageTitle);
        System.out.println("Login Message: " + loginMessage);
    }

    @And("^Close the Browser$")
    public void closeTheBrowser() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
