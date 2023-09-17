from  selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service as ChromeService
from webdriver_manager.chrome import ChromeDriverManager
driver = webdriver.Chrome(service=ChromeService(ChromeDriverManager().install()))
# Open the webpage
driver.get("https://v1.training-support.net/selenium/tables")

# Get the title of the page and print it
pageTitle = driver.title
print("Page Title:", pageTitle)

# Find the first table using xpath
table = driver.find_element(By.XPATH, "//table[@id='sortableTable']")

# Find the number of rows and columns in the table
rows = table.find_elements(By.XPATH, ".//tbody/tr")
columns = table.find_elements(By.XPATH, ".//thead/tr/th")

rowCount = len(rows)
columnCount = len(columns)

print("Number of Rows:", rowCount)
print("Number of Columns:", columnCount)

# Find and print all the cell values in the third row of the table
thirdRowCells = rows[2].find_elements(By.XPATH, ".//td")
print("Cell values in the third row:")
for cell in thirdRowCells:
    print(cell.text)

# Find and print the cell value at the second row, second column
cellValue = rows[1].find_elements(By.XPATH, ".//td")[1]
print("Cell value at second row, second column:", cellValue.text)

# Close the browser
driver.quit()
