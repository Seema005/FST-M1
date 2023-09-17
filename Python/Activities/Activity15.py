try:
    # Attempt to access an undefined variable
    print(undefined_variable)
except NameError as e:
    # Handle the NameError
    print(f"NameError: {e}")
    print("The variable 'undefined_variable' is not defined.")
