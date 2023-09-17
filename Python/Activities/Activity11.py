# Create a dictionary of fruits and their prices
fruit_prices = {
    "apple": 0.5,
    "banana": 0.25,
    "orange": 0.75,
    "kiwi": 1.0,
    "mango": 1.5,
    "pear": 0.6
}

# Ask the user for a fruit to check
fruit_to_check = input("Enter a fruit to check its availability: ").lower()

# Check if the fruit is available in the dictionary
if fruit_to_check in fruit_prices:
    print(f"{fruit_to_check.capitalize()} is available.")
    print(f"Price of {fruit_to_check.capitalize()}: ${fruit_prices[fruit_to_check]:.2f}")
else:
    print(f"{fruit_to_check.capitalize()} is not available.")
