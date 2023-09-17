from selenium import webdriver
from selenium.webdriver.chrome.service import Service as ChromeService
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.common.by import By
driver = webdriver.Chrome(service=ChromeService(ChromeDriverManager().install()))
# Navigate to the HRM system login page
url = "http://alchemy.hguy.co/orangehrm"
driver.get(url)

# Find the header image element by its XPath (you may need to inspect the page to get the correct XPath)
header_image = driver.find_element(By.XPATH,"//*[@id='divLogo']/img")

header_image_url=header_image.get_property("src")
# Print the URL to the console
print("URL of the header image:", header_image_url)

# Close the browser
driver.quit()
