from  selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service as ChromeService
from webdriver_manager.chrome import ChromeDriverManager
driver = webdriver.Chrome(service=ChromeService(ChromeDriverManager().install()))

# Open the webpage
driver.get("https://v1.training-support.net/selenium/dynamic-controls")

# Get the title of the page and print it
pageTitle = driver.title
print("Page Title:", pageTitle)

# Find the checkbox input element
checkbox = driver.find_element(By.XPATH, "//input[@type='checkbox']")

# Check if the checkbox is selected and print the result
is_checkbox_selected = checkbox.is_selected()
print("Checkbox is selected:", is_checkbox_selected)

# Click the checkbox to select it
checkbox.click()

# Check if the checkbox is selected again and print the result
is_checkbox_selected = checkbox.is_selected()
print("Checkbox is selected after click:", is_checkbox_selected)

# Close the browser
driver.quit()
