from  selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service as ChromeService
from selenium.webdriver.support.select import Select
from webdriver_manager.chrome import ChromeDriverManager
driver = webdriver.Chrome(service=ChromeService(ChromeDriverManager().install()))


# Open the webpage
driver.get("https://v1.training-support.net/selenium/selects")

# Get the title of the page and print it
pageTitle = driver.title
print("Page Title:", pageTitle)

# Find the dropdown
single_select = driver.find_element(By.ID, "single-select")
# Pass the dropdown WebElement to the Select class and initialize the select object
dropdown = Select(single_select)

# Select the second option using the visible text.
dropdown.select_by_visible_text("Option 2")
# Print the selected option using the first_selected_option method
# first_selected_option returns a WebElement.
# Use the text method to get the name of the selected option
print("Selected option: ", dropdown.first_selected_option.text)

# Select the third option using the index.
dropdown.select_by_index(3)
print("Selected option: ", dropdown.first_selected_option.text)

# Select the fourth option using the value.
dropdown.select_by_value("4")
print("Selected option: ", dropdown.first_selected_option.text)

# Get all the options and print them to the console.
select_options = dropdown.options
for option in select_options:
    print("Option: ", option.text)