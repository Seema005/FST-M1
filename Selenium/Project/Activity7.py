from selenium import webdriver
from selenium.webdriver.common.by import By
import time
def main():
    # Initialize the ChromeDriver
    driver = webdriver.Chrome()

    # Navigate to the website
    url = 'http://alchemy.hguy.co/orangehrm'
    driver.get(url)

    # Find the username and password fields, and login button
    username_field = driver.find_element(By.ID, "txtUsername")
    password_field = driver.find_element(By.ID, "txtPassword")
    login_button = driver.find_element(By.ID, "btnLogin")
    # Enter credentials and click login
    username_field.send_keys("orange")
    password_field.send_keys("orangepassword123")
    login_button.click()

    # Wait for the dashboard to load
    time.sleep(3)

    # Find the "My Info" menu item and click it
    my_info_menu = driver.find_element(By.ID,"menu_pim_viewMyDetails")
    my_info_menu.click()

    # Find the "Qualifications" option on the left side menu and click it
    qualification_menu = driver.find_element(By.XPATH,'//*[@id="sidenav"]/li[9]/a')
    qualification_menu.click()

    # Find "Add" button and click it
    add_button = driver.find_element(By.XPATH,'//*[@id="addWorkExperience"]')
    add_button.click()

    # Fill in the work experience details
    company_field = driver.find_element(By.ID,"experience_employer")
    job_title_field = driver.find_element(By.ID,"experience_jobtitle")

    company_field.send_keys("Company XYZ")
    job_title_field.send_keys("Software Engineer")

    # Save the work experience
    save_button = driver.find_element(By.ID,"btnWorkExpSave")
    save_button.click()

    print("Saved successfully")
    # Close the browser
    driver.quit()

if __name__ == "__main__":
    main()
