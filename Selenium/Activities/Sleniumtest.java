package examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Sleniumtest {
    public static void main(String[] args) {
        // Code to be executed when the program starts
        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver= new FirefoxDriver();
        //WebDriverManager.chromedriver().setup();
        // ChromeDriver driver= new ChromeDriver();
        driver.get("https://v1.training-support.net/");

        String pageTitle=driver.getTitle();
        System.out.println("Pagetitle is "+pageTitle);

        String pageHeading=driver.findElement(By.className("ui header")).getText();
        System.out.println(pageHeading); // Print a message to the console

        driver.quit();
        System.out.println("Selenium test"); // Print a message to the console
    }
}
