def determine_winner(player1_choice, player2_choice):
    if player1_choice == player2_choice:
        return "It's a tie!"

    if player1_choice == "rock":
        return "Player 1 wins!" if player2_choice == "scissors" else "Player 2 wins!"
    elif player1_choice == "paper":
        return "Player 1 wins!" if player2_choice == "rock" else "Player 2 wins!"
    elif player1_choice == "scissors":
        return "Player 1 wins!" if player2_choice == "paper" else "Player 2 wins!"
    else:
        return "Invalid choices. Please choose rock, paper, or scissors."


while True:
    player1_choice = input("Player 1, choose rock, paper, or scissors: ").lower()
    player2_choice = input("Player 2, choose rock, paper, or scissors: ").lower()

    result = determine_winner(player1_choice, player2_choice)
    print(result)

    play_again = input("Do you want to play again? (yes/no): ").lower()
    if play_again != "yes":
        print("Thanks for playing!")
        break