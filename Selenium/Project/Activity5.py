from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.chrome.service import Service as ChromeService
from webdriver_manager.chrome import ChromeDriverManager
driver = webdriver.Chrome(service=ChromeService(ChromeDriverManager().install()))
# Navigate to the HRM system login page
driver.get("http://alchemy.hguy.co/orangehrm")

# Find the username and password input fields and login button
username_field = driver.find_element(By.ID, "txtUsername")
password_field = driver.find_element(By.ID, "txtPassword")
login_button = driver.find_element(By.ID, "btnLogin")

# Enter the login credentials
username_field.send_keys("orange")
password_field.send_keys("orangepassword123")

# Click the login button
login_button.click()

# Wait for the My Info menu item to become clickable in the menu
wait = WebDriverWait(driver, 10)
my_info_menu = wait.until(EC.element_to_be_clickable((By.ID, "menu_pim_viewMyDetails")))
my_info_menu.click()

# Click the Edit button
edit_button = driver.find_element(By.ID, "btnSave")
edit_button.click()

# Fill in the Name, Gender, Nationality, and DOB fields
name_field = driver.find_element(By.ID, "personal_txtEmpFirstName")
gender_dropdown = driver.find_element(By.ID, "personal_optGender_2")
nationality_dropdown = driver.find_element(By.ID, "personal_cmbNation")
dob_field = driver.find_element(By.ID, "personal_DOB")

# Replace the following placeholders with the desired information
name_field.clear()
name_field.send_keys("Updated Name")
gender_dropdown.click()  # Select the appropriate option in the dropdown
nationality_dropdown.send_keys("Nationality")  # Select the appropriate option in the dropdown
dob_field.clear()
dob_field.send_keys("2000-01-01")  # Format: YYYY-MM-DD

# Click the Save button
save_button = driver.find_element(By.ID, "btnSave")
save_button.click()
print("Saved")
# Close the browser
driver.quit()
