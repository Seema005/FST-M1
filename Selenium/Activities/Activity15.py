from  selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service as ChromeService
from webdriver_manager.chrome import ChromeDriverManager
driver = webdriver.Chrome(service=ChromeService(ChromeDriverManager().install()))

# Open the webpage
driver.get("https://v1.training-support.net/selenium/dynamic-attributes")

# Get the title of the page and print it
pageTitle = driver.title
print("Page Title:", pageTitle)

# Find the username and password input fields
usernameField = driver.find_element(By.XPATH, "//input[@type='text']")
passwordField = driver.find_element(By.XPATH, "//input[@type='password']")

# Type in the credentials
usernameField.send_keys("admin")
passwordField.send_keys("password")

# Find the login button and click it
driver.find_element(By.XPATH, "//button[@type='submit']").click()

# wait for the login message to appear
#wait.until(EC.visibility_of_element_located((By.ID, "action-confirmation")))

# Print the confirmation message
message = driver.find_element(By.ID, "action-confirmation").text
print("Login message: ", message)
