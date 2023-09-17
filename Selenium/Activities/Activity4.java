package activities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;


public class Activity4 {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver= new ChromeDriver();

        // Open the browser and navigate to the URL
        driver.get("https://v1.training-support.net/selenium/target-practice");

        // Get the title of the page and print it to the console
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);

        // Find the 3rd header and print its text
        String thirdHeaderText = driver.findElement(By.xpath("//h3[@id='third-header']")).getText();
        System.out.println(thirdHeaderText);
        // Find the 5th header and print its colour
        String fifthHeaderColor = driver.findElement(By.xpath("//h5[text()='Fifth header']")).getCssValue("color");
        System.out.println(fifthHeaderColor);
        // Using other locator (XPath), find the violet button and print all its classes
        WebElement violetButton = driver.findElement(By.xpath("//button[@class='ui violet button']"));
        String buttonClasses = violetButton.getAttribute("class");
        System.out.println("Violet Button Classes: " + buttonClasses);

        // Using other locator (XPath), find the grey button and print its text
        WebElement greyButton = driver.findElement(By.xpath("//button[contains(@class, 'grey')]"));
        String buttonText = greyButton.getText();
        System.out.println("Grey Button Text: " + buttonText);

        // Close the browser
        driver.quit();
    }
}
