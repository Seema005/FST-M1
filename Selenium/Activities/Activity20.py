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

# Find the button to open a PROMPT alert and click it
promptButton = driver.find_element(By.ID,"prompt")
promptButton.click()

# Switch the focus to the alert
alert = driver.switch_to.alert

# Get the text in the alert and print it
alertText = alert.text
print("Alert Text:", alertText)

# Type "Awesome!" into the prompt
alert.send_keys("Awesome!")

# Close the alert with OK
alert.accept()

# Close the browser
driver.quit()
