package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HandlingSelect {

    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver= new ChromeDriver();
        driver.get(" https://v1.training-support.net/selenium/selects");

        // Get the title of the page and print it to the console
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);

        // Locate the Single Select element
        WebElement singleSelect = driver.findElement(By.id("single-select"));

        // Select the second option using visible text
        Select select = new Select(singleSelect);
        select.selectByVisibleText("Option 2");

        // Select the third option using index
        select.selectByIndex(2);

        // Select the fourth option using value
        select.selectByValue("4");

        // Get all the options and print them to the console
        List<WebElement> allOptions = select.getOptions();
        System.out.println("All Options:");
        for (WebElement option : allOptions) {
            System.out.println(option.getText());
        }

        // Close the browser
        driver.close();
    }
}

