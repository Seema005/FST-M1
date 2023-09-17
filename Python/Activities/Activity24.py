# test_wallet.py

import pytest

# Define the wallet fixture
@pytest.fixture
def wallet():
    # Initialize the wallet with 0
    amount = 0
    return amount

# Create a test function with parameters
@pytest.mark.parametrize("earned, spent, expected", [
    (30, 10, 20),  # Test case 1: Earn 30, Spend 10, Expect 20 remaining
    (20, 2, 18),   # Test case 2: Earn 20, Spend 2, Expect 18 remaining
])
def test_wallet_transactions(wallet, earned, spent, expected):
    # Simulate wallet transactions
    wallet += earned
    wallet -= spent

    # Assert that the final amount matches the expected value
    assert wallet == expected
