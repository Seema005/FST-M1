from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service as ChromeService
from webdriver_manager.chrome import ChromeDriverManager
driver = webdriver.Chrome(service=ChromeService(ChromeDriverManager().install()))

# Open the browser and navigate to the URL
driver.get("https://v1.training-support.net/selenium/login-form")

# Get the title of the page and print it to the console
page_title = driver.title
print("Page Title:", page_title)

# Find the username field
username = driver.find_element(By.ID, "username")
# Find the password field
password = driver.find_element(By.ID, "password")
# Find the "Log in" button and click it
login = driver.find_element(By.CSS_SELECTOR, "button.button:nth-child(4)")
login.click()

# Close the browser
driver.quit()
