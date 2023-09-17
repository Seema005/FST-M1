import pandas as pd

# Create a DataFrame with the given data
data = {'Usernames': ['admin', 'Charles', 'Deku'],
        'Passwords': ['password', 'Charl13', 'AllMight']}

df = pd.DataFrame(data)

# Specify the file path where you want to save the CSV file
file_path = 'user_credentials.csv'

# Write the DataFrame to a CSV file
df.to_csv(file_path, index=False)

print(f'Data has been written to {file_path}')
