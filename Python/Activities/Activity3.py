# Function to determine the winner of the game
def determine_winner(player1_choice, player2_choice):
    if player1_choice == player2_choice:
        return "It's a tie!"
    elif (
            (player1_choice == "rock" and player2_choice == "scissors")
            or (player1_choice == "scissors" and player2_choice == "paper")
            or (player1_choice == "paper" and player2_choice == "rock")
    ):
        return "Player 1 wins!"
    else:
        return "Player 2 wins!"

# Get choices from both players
player1_choice = input("Player 1, enter 'rock', 'paper', or 'scissors': ").lower()
player2_choice = input("Player 2, enter 'rock', 'paper', or 'scissors': ").lower()

# Check for valid input
if player1_choice not in ["rock", "paper", "scissors"] or player2_choice not in ["rock", "paper", "scissors"]:
    print("Invalid input. Please enter 'rock', 'paper', or 'scissors'.")
else:
    # Display choices and result
    print(f"Player 1's choice: {player1_choice}")
    print(f"Player 2's choice: {player2_choice}")
    print(determine_winner(player1_choice, player2_choice))
