# Get a list of numbers from the user
input_str = input("Enter a list of numbers separated by spaces: ")
numbers = [int(x) for x in input_str.split()]

# Calculate the sum of the numbers using the sum() function
total_sum = sum(numbers)

# Print the result
print("Sum of the numbers:", total_sum)
