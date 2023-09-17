package Project;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ToDoListTest {
    // Driver Declaration
    AndroidDriver driver;
    WebDriverWait wait;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(200));

        // Open the page in Chrome
        driver.get("https://v1.training-support.net/selenium");
    }
    @Test
    public void ChromeTest1() {
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        String[] taskList = {"Add tasks to list","Get number of tasks","Clear the list"};

        //Scroll to find the To-Do List card and click it.
       driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".flingForward()"));
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View[contains(@class, 'android.view.View') and contains(@text, 'To-Do List')]\n")));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[contains(@class, 'android.view.View') and contains(@text, 'To-Do List')]\n")));
        driver.findElement(AppiumBy.xpath("//android.view.View[contains(@class, 'android.view.View') and contains(@text, 'To-Do List')]\n")).click();
        // Find the input field and enter tasks without using a List

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText[@resource-id='taskInput']")));
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='taskInput']")).sendKeys("Add tasks to list");
        driver.findElement(By.xpath("//android.widget.Button[@text='Add Task']\n")).click();
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='taskInput']")).sendKeys("Get number of tasks");
        driver.findElement(By.xpath("//android.widget.Button[@text='Add Task']\n")).click();
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='taskInput']")).sendKeys("Clear the list");
        driver.findElement(By.xpath("//android.widget.Button[@text='Add Task']\n")).click();

        // Get the number of tasks and assert it
       // wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tasksList")));
       // driver.findElement(By.id("tasksList")).isDisplayed();

        // Click on each task to strike them out
        /*wait = new WebDriverWait(driver, Duration.ofSeconds(200));
        driver.findElement(By.xpath("//android.view.View[@text='Add tasks to list']\n")).click();
        driver.findElement(By.xpath("//android.view.View[@text='Get number of tasks']\n")).click();
        driver.findElement(By.xpath("//android.view.View[@text='Clear the list']\n")).click();*/

        // Click on each task to strike them out
        for (int i = 1; i <= 3; i++) {
            driver.findElement(By.xpath("//android.widget.ListView/android.view.View[" + i + "]")).click();
        }

        // Clear the list
        driver.findElement(By.id("clearButton")).click();
    }
    @AfterTest
    public void tearDown() {
        // Close the browser or app after the test
        driver.quit();
    }
    }
