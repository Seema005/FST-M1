# Get a tuple of numbers from the user
input_str = input("Enter a tuple of numbers separated by spaces: ")
numbers = tuple(int(x) for x in input_str.split())

# Iterate through the tuple and print numbers divisible by 5
print("Numbers divisible by 5:")
for num in numbers:
    if num % 5 == 0:
        print(num)
