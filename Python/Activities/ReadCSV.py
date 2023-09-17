import pandas as pd

# Read the CSV file into a DataFrame
file_path = 'user_credentials.csv'
df = pd.read_csv(file_path)

# Print the values in the Usernames column
print("Usernames:")
print(df['Usernames'])

# Print the username and password of the second row
print("\nUsername and Password of the Second Row:")
print(f"Username: {df.at[1, 'Usernames']}, Password: {df.at[1, 'Passwords']}")

# Sort the Usernames column data in ascending order and print data
print("\nSorted Usernames (Ascending):")
print(df['Usernames'].sort_values())

# Sort the Passwords column in descending order and print data
print("\nSorted Passwords (Descending):")
print(df['Passwords'].sort_values(ascending=False))
