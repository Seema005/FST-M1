package Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class GoogleKeepTest {
    AppiumDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() throws MalformedURLException {
        //Desired capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity("com.google.android.apps.keep.ui.activities.BrowseActivity");
        options.noReset();

        //Server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL, options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void addNoteToGoogleKeep() {
        // Click the "Create New Note" button to add a new note
        driver.findElement(AppiumBy.id("com.google.android.keep:id/new_note_button")).click();

        // Add a title and description for the note
        driver.findElement(AppiumBy.id("com.google.android.keep:id/editable_title")).sendKeys("Test Note Title");
        driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text")).sendKeys("This is a test note description.");

        // Press the back button to save the note
        driver.navigate().back();

        String Note = driver.findElement(AppiumBy.id("com.google.android.keep:id/index_note_text_description")).getText();
        String NoteTitle = driver.findElement(AppiumBy.id("com.google.android.keep:id/index_note_title")).getText();
        Assert.assertEquals(NoteTitle, "Test Note Title", "Addition result is incorrect.");
        Assert.assertEquals(Note, "This is a test note description.", "Addition result is incorrect.");
    }
    @AfterClass
    public void closeApp()
    {
        driver.quit();
    }
}
