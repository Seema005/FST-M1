from  selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.chrome.service import Service as ChromeService
from selenium.webdriver.support.select import Select
from webdriver_manager.chrome import ChromeDriverManager
driver = webdriver.Chrome(service=ChromeService(ChromeDriverManager().install()))
from selenium.webdriver.common.keys import Keys

# Open the OrangeHRM page
url = "http://alchemy.hguy.co/orangehrm"
driver.get(url)

# Find and fill in the username and password fields
username = driver.find_element(By.ID, "txtUsername")
password = driver.find_element(By.ID, "txtPassword")
username.send_keys("orange")
password.send_keys("orangepassword123")
password.send_keys(Keys.RETURN)

# Navigate to the "My Info" page
menu_my_info = driver.find_element(By.ID, "menu_pim_viewMyDetails")
menu_my_info.click()

# Locate the left-hand menu and click on "Emergency Contacts"
menu_emergency_contacts = driver.find_element(By.ID, "sidenav")
menu_emergency_contacts.find_element(By.LINK_TEXT, "Emergency Contacts").click()

# Retrieve information about all the contacts listed in the table
contacts_table = driver.find_element(By.ID, "emgcontact_list")
rows = contacts_table.find_elements(By.TAG_NAME, "tr")

contact_info = []

# Loop through the table rows to collect contact information
for row in rows[1:]:  # Skip the header row
    columns = row.find_elements(By.TAG_NAME, "td")
    contact_name = columns[1].text
    contact_relationship = columns[2].text
    contact_home_phone = columns[3].text
    contact_mobile_phone = columns[4].text
    contact_work_phone = columns[5].text

    contact_info.append(
        {
            "Name": contact_name,
            "Relationship": contact_relationship,
            "Home Phone": contact_home_phone,
            "Mobile Phone": contact_mobile_phone,
            "Work Phone": contact_work_phone,

        }
    )

# Print all the information to the console
for contact in contact_info:
    print("Contact Information:")
    for key, value in contact.items():
        print(f"{key}: {value}")
    print()

# Close the browser
driver.quit()
