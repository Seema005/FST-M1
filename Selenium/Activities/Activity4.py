from  selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service as ChromeService
from webdriver_manager.chrome import ChromeDriverManager
driver = webdriver.Chrome(service=ChromeService(ChromeDriverManager().install()))
from selenium import webdriver

# Open the browser and navigate to the URL
driver.get("https://v1.training-support.net/selenium/target-practice")

# Get the title of the page and print it to the console
page_title = driver.title
print("Page Title:", page_title)

# Find the 3rd header element on the page using XPath
third_heading = driver.find_element(By.XPATH, "//h3[@id='third-header']")
print("Third heading text is: ", third_heading.text)

# Find the 5th header element on the page using XPath
fifth_heading = driver.find_element(By.XPATH, "//h5")
print("Fifth heading colour is: ", fifth_heading.value_of_css_property("color"))


# Using other locator (XPath), find the violet button and print all its classes
violet_button = driver.find_element(By.XPATH, "//button[@class='ui violet button']")
button_classes = violet_button.get_attribute("class")
print("Violet Button Classes:", button_classes)

# Using other locator (XPath), find the grey button and print its text
grey_button = driver.find_element(By.XPATH, "//button[contains(@class, 'grey')]")
button_text = grey_button.text
print("Grey Button Text:", button_text)

# Close the browser
driver.quit()
