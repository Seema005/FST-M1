# Set up the Chrome Driver
from selenium import webdriver
from selenium.webdriver.chrome.service import Service as ChromeService
from webdriver_manager.chrome import ChromeDriverManager
driver = webdriver.Chrome(service=ChromeService(ChromeDriverManager().install()))
#Open the URL
driver.get("http://alchemy.hguy.co/orangehrm");

# Get the title of the website
website_title = driver.title

# Expected title
expected_title = "OrangeHRM"

# Verify if the title matches
if website_title == expected_title:
    print("Website title matches.")
else:
    print(f"Website title does not match. Expected: {expected_title}, Actual: {website_title}")

# Close the browser
driver.quit()