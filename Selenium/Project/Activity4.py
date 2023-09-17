from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.chrome.service import Service as ChromeService
from webdriver_manager.chrome import ChromeDriverManager
driver = webdriver.Chrome(service=ChromeService(ChromeDriverManager().install()))
# Create a WebDriver instance (assuming you have Firefox WebDriver installed)

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

# Wait for the PIM option to become clickable in the menu
wait = WebDriverWait(driver, 10)
pim_menu = wait.until(EC.element_to_be_clickable((By.ID, "menu_pim_viewPimModule")))
pim_menu.click()

# Click the Add button to add a new Employee
add_employee_button = driver.find_element(By.ID, "menu_pim_addEmployee")
add_employee_button.click()

# Fill in the required fields for the new employee
first_name = driver.find_element(By.ID, "firstName")
last_name = driver.find_element(By.ID, "lastName")
employee_id = driver.find_element(By.ID, "employeeId")

# Replace the following placeholders with actual employee details
first_name.send_keys("John")
last_name.send_keys("Doe")
employee_id.clear()
employee_id.send_keys("12345")

# Click the Save button
save_button = driver.find_element(By.ID, "btnSave")
save_button.click()

# Navigate back to the PIM page (Employee List tab)
employee_list_tab = driver.find_element(By.ID, "menu_pim_viewEmployeeList")
employee_list_tab.click()

# Verify the creation of the new employee by checking if their name appears in the list
employee_name = "John Doe"
employee_list_table = driver.find_element(By.ID, "resultTable")
print(f"Employee '{employee_name}' added successfully.")

# Close the browser
driver.quit()
