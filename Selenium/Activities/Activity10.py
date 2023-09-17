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

# Check if the checkbox is visible on the page
is_checkbox_visible = checkbox.is_displayed()
print("Checkbox is visible:", is_checkbox_visible)

# Click the "Remove Checkbox" button
remove_button = driver.find_element(By.ID, "toggleCheckbox")
remove_button.click()

# Check if the checkbox is visible again and print the result
is_checkbox_visible = checkbox.is_displayed()
print("Checkbox is visible after removal:", is_checkbox_visible)

# Close the browser
driver.quit()
