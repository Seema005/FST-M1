from  selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service as ChromeService
from selenium.webdriver.support.select import Select
from webdriver_manager.chrome import ChromeDriverManager
driver = webdriver.Chrome(service=ChromeService(ChromeDriverManager().install()))

# Open the webpage
driver.get("https://v1.training-support.net/selenium/javascript-alerts")

# Get the title of the page and print it
pageTitle = driver.title
print("Page Title:", pageTitle)


# Find the confirm button and click it
driver.find_element(By.ID, "confirm").click()
# Switch focus to the alert
confirm_alert = driver.switch_to.alert
# Print the text in the alert
print(confirm_alert.text)
# Close the alert with either one of the methods
# with OK
confirm_alert.accept()
# with Cancel
# confirm_alert.dismiss()