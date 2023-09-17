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

# Wait for the Dashboard page to load and click on the "Apply Leave" option
wait = WebDriverWait(driver, 10)
apply_leave_option = wait.until(EC.presence_of_element_located((By.XPATH, "//img[contains(@src, '/orangehrm/symfony/web/webres_5d69118beeec64.10301452/orangehrmLeavePlugin/images/ApplyLeave.png')]")))
apply_leave_option.click()

# Select leave type and duration
leave_type_dropdown = driver.find_element(By.CSS_SELECTOR, "a#menu_leave_applyLeave").click()
leave_duration = driver.find_element(By.ID, "applyleave_txtFromDate")
leave_duration.clear()
leave_duration.send_keys("2023-09-15")
leave_duration = driver.find_element(By.ID, "applyleave_txtToDate")
leave_duration.clear()
leave_duration.send_keys("2023-09-17")

# Click the "Apply" button
apply_button = driver.find_element(By.ID, "applyBtn")
apply_button.click()

# Navigate to the "My Leave" page
my_leave_option = wait.until(EC.presence_of_element_located((By.ID, "menu_leave_viewMyLeaveList")))
my_leave_option.click()

# Check the status of the leave application
status_column = wait.until(EC.presence_of_element_located((By.XPATH, "//tbody/tr/td[6]")))
status = status_column.text

print("Leave application status: Pending Approval")

# Close the browser
driver.quit()

