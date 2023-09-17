from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
# Create a WebDriver instance (assuming you have Firefox WebDriver installed)
driver = webdriver.Firefox()

# Navigate to the HRM system login page
driver.get("http://alchemy.hguy.co/orangehrm")

# Find the username and password input fields and login button
username_field = driver.find_element(By.ID,"txtUsername")
password_field = driver.find_element(By.ID,"txtPassword")
login_button = driver.find_element(By.ID,"btnLogin")

# Enter the login credentials
username_field.send_keys("orange")
password_field.send_keys("orangepassword123")

# Click the login button
login_button.click()

wait = WebDriverWait(driver, 10)
wait.until(EC.presence_of_element_located((By.ID, "menu_dashboard_index")))

# Close the browser
driver.quit()
