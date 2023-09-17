# Get user input for name and age
name = input("Enter your name: ")
age = int(input("Enter your age: "))

# Calculate the year when the user will turn 100 years old
current_year = 2023  # You can update this with the current year
year_to_turn_100 = current_year + (100 - age)

# Print the message
print(f"Hello, {name}! You will turn 100 years old in the year {year_to_turn_100}.")
