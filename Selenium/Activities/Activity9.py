from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service as ChromeService
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.chrome import ChromeDriverManager
driver = webdriver.Chrome(service=ChromeService(ChromeDriverManager().install()))

    # Navigate to the URL
driver.get("https://www.v1.training-support.net/selenium/ajax")
    # Print the title of the page
print("Page title is: ", driver.title)

    # Initialize the wait object
wait = WebDriverWait(driver, 10)

    # Find the "Change Content" button and click it
driver.find_element(By.CSS_SELECTOR, "button.violet").click()
    # Wait for the text "HELLO!" to appear
wait.until(expected_conditions.text_to_be_present_in_element((By.TAG_NAME, "h1"), "HELLO!"))
hello_text = driver.find_element(By.TAG_NAME, "h1").text
    # Print the text
print(hello_text)

    # Wait for "I'm late!" to appear
wait.until(expected_conditions.text_to_be_present_in_element((By.TAG_NAME, "h3"), "I'm late!"))
late_text = driver.find_element(By.TAG_NAME, "h3").text
# Print the text
print(late_text)