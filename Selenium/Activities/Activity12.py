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

# Find the text field
text_field = driver.find_element(By.XPATH, "//input[@type='text']")

# Check if the text field is enabled and print the result
is_text_field_enabled = text_field.is_enabled()
print("Text Field is enabled:", is_text_field_enabled)

# Click the "Enable Input" button to enable the input field
enable_button = driver.find_element(By.ID, "toggleInput")
enable_button.click()

# Check if the text field is enabled again and print the result
is_text_field_enabled = text_field.is_enabled()
print("Text Field is enabled after click:", is_text_field_enabled)

# Close the browser
driver.quit()
