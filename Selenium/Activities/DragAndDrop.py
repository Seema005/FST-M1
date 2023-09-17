from  selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service as ChromeService
from webdriver_manager.chrome import ChromeDriverManager
driver = webdriver.Chrome(service=ChromeService(ChromeDriverManager().install()))

driver.get("https://www.v1.training-support.net/selenium/drag-drop")

# Print the title of the page
print("Page title is: ", driver.title)

# Declare the actions variable
actions = ActionChains(driver)

# Find the ball and store it
ball = driver.find_element(By.ID, "draggable")
# Find the dropzones and save them
dropzone1 = driver.find_element(By.ID, "droppable")
dropzone2 = driver.find_element(By.ID, "dropzone2")

# Perform the actions in separate lines
actions.drag_and_drop(ball, dropzone1).perform() # drag the ball into dropzone1
if(dropzone1.text.find("Dropped!")):
    print("Dropzone 1 was activated!")

# Perform the actions in separate lines
actions.drag_and_drop(ball, dropzone2).perform() # drag the ball into dropzone2
if(dropzone2.text.find("Dropped!")):
    print("Dropzone 2 was activated!")