package Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.AssertJUnit.assertTrue;

public class GoogleTasksTest {
    //Declare driver
    AppiumDriver driver;
     WebDriverWait wait;
    @BeforeClass
    public void setup() throws MalformedURLException {
        //Desired capabilities
        UiAutomator2Options options=new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();

        //Server URL
        URL serverURL =new URL("http://localhost:4723/wd/hub");
        driver =new AndroidDriver(serverURL,options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Initialize WebDriverWait

    }
    @Test
    public void additionTest()
    {
        //Find digit 6 and tap
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Tasks");
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();

        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Keep");
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();

        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete the second Activity Google Keep");
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();

// Assertion: Ensure all three tasks with their names have been added to the list
        List<String> actualTaskNames = driver.findElements(AppiumBy.id("com.google.android.apps.tasks:id/task_name"))
                .stream()
                .map(taskElement -> taskElement.getText())
                .toList();

        List<String> expectedTaskNames = List.of(
                "Complete Activity with Google Tasks",
                "Complete Activity with Google Keep",
                "Complete the second Activity Google Keep"
        );
        assertTrue("Not all tasks have been added.", actualTaskNames.containsAll(expectedTaskNames));

    }
    @AfterClass
    public void closeApp()
    {
        driver.quit();
    }
}
