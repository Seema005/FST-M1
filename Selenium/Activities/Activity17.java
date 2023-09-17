package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Activity17 {
        public static void main(String[] args) {
            // Set the path to the ChromeDriver executable
            WebDriverManager.chromedriver().setup();
            ChromeDriver driver= new ChromeDriver();
            driver.get("https://v1.training-support.net/selenium/tables");

            // Get the title of the page and print it to the console
            String pageTitle = driver.getTitle();
            System.out.println("Page Title: " + pageTitle);

            // Locate the second table using XPath
            WebElement table = driver.findElement(By.xpath("//table[@id='sortableTable']"));

            // Find the number of rows and columns in the table and print them
            List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));
            int numRows = rows.size();
            int numColumns = table.findElements(By.xpath(".//thead/tr/th")).size();
            System.out.println("Number of Rows: " + numRows);
            System.out.println("Number of Columns: " + numColumns);

            // Find and print the cell value at the second row second column
            WebElement cellValue = rows.get(1).findElement(By.xpath(".//td[2]"));
            System.out.println("Cell Value at 2nd row 2nd column: " + cellValue.getText());

            // Click the header of the first column to sort by name
            WebElement nameHeader = table.findElement(By.xpath(".//th[1]"));
            nameHeader.click();

            // Find and print the cell value at the second row second column again
            cellValue = rows.get(1).findElement(By.xpath(".//td[2]"));
            System.out.println("Cell Value at 2nd row 2nd column after sorting: " + cellValue.getText());

            // Print the cell values of the table footer
            WebElement tableFooter = driver.findElement(By.xpath("//tfoot"));
            List<WebElement> footerCells = tableFooter.findElements(By.xpath(".//td"));
            for (WebElement footerCell : footerCells) {
                System.out.println("Footer Cell Value: " + footerCell.getText());
            }

            // Close the browser
            driver.close();
        }
    }

