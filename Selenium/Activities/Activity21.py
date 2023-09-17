from  selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service as ChromeService
from selenium.webdriver.support.select import Select
from webdriver_manager.chrome import ChromeDriverManager
driver = webdriver.Chrome(service=ChromeService(ChromeDriverManager().install()))

# Open the webpage
driver.get("https://www.v1.training-support.net/selenium/tab-opener")

# Get the title of the main page and print it
pageTitle = driver.title
print("Main Page Title:", pageTitle)

# Find the button to open a new tab and click it
openTabButton = driver.find_element(By.ID,"opentab")
openTabButton.click()

# Wait for the new tab to open
windowHandles = driver.window_handles
for handle in windowHandles:
    driver.switch_to.window(handle)

# Print all the handles
print("All Window Handles:", windowHandles)

# Print the title and heading of the new tab
print("New Tab Title:", driver.title)
heading = driver.find_element(By.TAG_NAME,"h1")
print("New Tab Heading:", heading.text)

# Close the current tab
driver.close()

# Switch back to the main tab
windowHandles = driver.window_handles
for handle in windowHandles:
    driver.switch_to.window(handle)

# Click the button in the main tab to open another new tab
openTabButton = driver.find_element(By.ID,"opentab")
openTabButton.click()

# Wait for the new tab to open
windowHandles = driver.window_handles
for handle in windowHandles:
    driver.switch_to.window(handle)

# Print all the handles
print("All Window Handles:", windowHandles)

# Print the title and heading of the new tab
print("New Tab Title:", driver.title)
heading = driver.find_element(By.TAG_NAME,"h1")
print("New Tab Heading:", heading.text)

# Close the browser
driver.quit()
