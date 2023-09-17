package stepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertTestSteps {
    private WebDriver driver;
    private WebDriverWait wait;
    Alert alert;

    @Given("^User is on the page$")
    public void userIsOnThePage() {
        //Create a new instance of the Firefox driver
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\003L24744\\Downloads\\geckodriver-v0.33.0-win64\\geckodriver.exe");

        driver = new FirefoxDriver();

        // driver = new FirefoxDriver(capabilities);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Open browser and navigate to the page
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
    }

    @When("^User clicks the Simple Alert button$")
    public void userClicksSimpleAlertButton() {
        driver.findElement(By.cssSelector("#simple")).click();
    }

    @When("^User clicks the Confirm Alert button$")
    public void userClicksConfirmAlertButton() {
        driver.findElement(By.cssSelector("#confirm")).click();
    }

    @When("^User clicks the Prompt Alert button$")
    public void userClicksPromptAlertButton() {
        driver.findElement(By.cssSelector("#prompt")).click();
    }

    @Then("^Alert opens$")
    public void alertOpens() {
        alert = driver.switchTo().alert();
    }

    @And("^Read the text from it and print it$")
    public void readTextFromAlertAndPrint() {
        System.out.println("Alert says: " + alert.getText());
    }

    @And("^Write a custom message in it$")
    public void writeCustomMessageInPromptAlert() {
        alert.sendKeys("Custom Message");
    }

    @And("^Close the alert$")
    public void closeAlert() {
        alert.accept();
    }

    @And("^Close the alert with Cancel$")
    public void closeAlertWithCancel() {
        alert.dismiss();
    }

    @And("^Show the result$")
    public void showResult() {
        WebElement resultText = driver.findElement(By.id("result"));
        String result = resultText.getText();
        System.out.println("Result: " + result);
    }

    @And("^Close Browser$")
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
