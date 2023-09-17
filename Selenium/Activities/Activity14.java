package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.firefox.FirefoxOptions;
        import java.util.List;

public class Activity14 {
    public static void main(String[] args) {
        // Set up the Chrome WebDriver
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver= new ChromeDriver();


        // Open the webpage
        driver.get("https://v1.training-support.net/selenium/tables");

        // Get the title of the page and print it
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);

        // Find the second table using xpath
        WebElement table = driver.findElement(By.xpath("//table[@id='sortableTable']"));

        // Find the number of rows and columns in the table
        List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));
        List<WebElement> columns = table.findElements(By.xpath(".//thead/tr/th"));

        int rowCount = rows.size();
        int columnCount = columns.size();

        System.out.println("Number of Rows: " + rowCount);
        System.out.println("Number of Columns: " + columnCount);

        // Find and print the cell value at the second row, second column
        WebElement cellValue1 = rows.get(1).findElements(By.xpath(".//td")).get(1);
        System.out.println("Cell value at second row, second column: " + cellValue1.getText());

        // Click the header of the first column to sort by name
        WebElement headerName = columns.get(0);
        headerName.click();

        // Find and print the cell value at the second row, second column again
        WebElement cellValue2 = rows.get(1).findElements(By.xpath(".//td")).get(1);
        System.out.println("Cell value at second row, second column after sorting: " + cellValue2.getText());

        // Find and print the cell values of the table footer
        WebElement tableFooter = table.findElement(By.xpath(".//tfoot"));
        List<WebElement> footerCells = tableFooter.findElements(By.xpath(".//td"));
        System.out.println("Cell values in the table footer:");
        for (WebElement footerCell : footerCells) {
            System.out.println(footerCell.getText());
        }

        // Close the browser
        driver.quit();
    }
}
