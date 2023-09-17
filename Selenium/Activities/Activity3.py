from  selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service as ChromeService
from webdriver_manager.chrome import ChromeDriverManager
driver = webdriver.Chrome(service=ChromeService(ChromeDriverManager().install()))
# Open the browser and navigate to the URL
driver.get("https://v1.training-support.net/selenium/login-form")

# Get the title of the page and print it to the console
page_title = driver.title
print("Page Title:", page_title)

# Find the username field and enter "admin" using XPath
username_field = driver.find_element(By.XPATH, "//input[@id='username']")
username_field.send_keys("admin")

# Find the password field and enter "password" using XPath
password_field = driver.find_element(By.XPATH, "//input[@id='password']")
password_field.send_keys("password")

# Find the "Log in" button and click it using XPath
login_button = driver.find_element(By.XPATH, "//button[@type='submit']")
login_button.click()

# Close the browser
driver.quit()





