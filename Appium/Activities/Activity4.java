package Example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Instant;

public class Activity4 {
    AppiumDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setup() throws MalformedURLException {
        //Desired capabilities
        UiAutomator2Options options=new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.contacts");
        options.setAppActivity(".activities.PeopleActivity");
        options.noReset();

        //Server URL
        URL serverURL =new URL("http://localhost:4723/wd/hub");
        driver =new AndroidDriver(serverURL,options);

    }

    @Test
    public void contactsTest() {
        // Find and click the add button
        driver.findElement(AppiumBy.accessibilityId("Create new contact")).click();

        // Enter the details
        driver.findElement(AppiumBy.xpath(
                "//android.widget.EditText[@text='First name']"
        )).sendKeys("Aaditya");
        driver.findElement(AppiumBy.xpath(
                "//android.widget.EditText[@text='Last name']"
        )).sendKeys("Varma");
        driver.findElement(AppiumBy.xpath(
                "//android.widget.EditText[@text='Phone']"
        )).sendKeys("999148292");
        // Click Save
        driver.findElement(AppiumBy.id("editor_menu_save_button")).click();
        // Assertion
        String contactName = driver.findElement(AppiumBy.id("large_title")).getText();
        Assert.assertEquals(contactName, "Aaditya Varma");
    }
    @AfterClass
    public void closeApp()
    {
        driver.quit();
    }
}
