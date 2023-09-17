from selenium import webdriver
from selenium.webdriver.common.action_chains import ActionChains
from  selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service as ChromeService
from selenium.webdriver.support.select import Select
from webdriver_manager.chrome import ChromeDriverManager
driver = webdriver.Chrome(service=ChromeService(ChromeDriverManager().install()))

# Navigate to the URL
driver.get("https://www.v1.training-support.net/selenium/popups")
# Print the title of the page
print("Page title is: ", driver.title)

# Find the "Sign In" button
signin_button = driver.find_element(By.CLASS_NAME, "orange")
# Move the cursor over the button to show tooltip
ActionChains(driver).move_to_element(signin_button).perform()
# Print the tooltip text
tooltip_text = signin_button.get_attribute("data-tooltip")
print("Button tooltip text: ", tooltip_text)
# Click the button
signin_button.click()

# Find the username and password fields
username = driver.find_element(By.ID, "username")
password = driver.find_element(By.ID, "password")
# Enter credentials
username.send_keys("admin")
password.send_keys("password")
# Click login
driver.find_element(By.XPATH, "/html/body/div[4]/div/div[2]/div/div/button").click()

# Print the confirmation message
message = driver.find_element(By.ID, "action-confirmation")
print("Confirmation message: ", message.text)