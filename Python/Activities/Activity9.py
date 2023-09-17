# Get two lists of numbers from the user
input_str1 = input("Enter the first list of numbers separated by spaces: ")
list1 = [int(x) for x in input_str1.split()]

input_str2 = input("Enter the second list of numbers separated by spaces: ")
list2 = [int(x) for x in input_str2.split()]

# Create a new list with odd numbers from the first list and even numbers from the second list
new_list = [x for x in list1 if x % 2 != 0] + [x for x in list2 if x % 2 == 0]

# Print the new list
print("New list:", new_list)
