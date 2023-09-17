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

# Wait for the navigation menu to become visible
wait = WebDriverWait(driver, 10)
menu = wait.until(EC.presence_of_element_located((By.ID, "menu_directory_viewDirectory")))

# Check if the "Directory" menu item is visible and clickable
if menu.is_displayed() and menu.is_enabled():
    # Click on the "Directory" menu item
    menu.click()

    # Wait for the heading of the page to match "Search Directory"
    search_directory_heading = wait.until(EC.visibility_of_element_located((By.XPATH, "//div[@class='head']/h1")))
    if search_directory_heading.text == "Search Directory":
        print("Directory menu item is visible, clickable, and the heading matches 'Search Directory'.")
    else:
        print("Directory menu item is visible and clickable, but the heading does not match 'Search Directory'.")
else:
    print("Directory menu item is not visible or clickable.")

# Close the browser
driver.quit()
