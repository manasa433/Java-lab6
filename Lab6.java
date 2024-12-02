1Q. Coins Combinations {1,2,3} and {2,3,5,6}

import threading

def count_combinations(coins, total_sum):
    # dp[i] will store the number of ways to make the sum 'i' using the given coins
    dp = [0] * (total_sum + 1)
    
    # There is one way to make the sum 0: use no coins
    dp[0] = 1
    
    # Loop over each coin and update the dp array
    for coin in coins:
        for i in range(coin, total_sum + 1):
            dp[i] += dp[i - coin]
    
    # The value at dp[total_sum] will be the number of ways to make 'total_sum'
    return dp[total_sum]

# Test case 1: Coins = {1, 2, 3}, Sum = 4
coins_1 = [1, 2, 3]
total_sum_1 = 4

# Test case 2: Coins = {2, 5, 3, 6}, Sum = 10
coins_2 = [2, 5, 3, 6]
total_sum_2 = 10

# Calling the function and printing the results
result_1 = count_combinations(coins_1, total_sum_1)
result_2 = count_combinations(coins_2, total_sum_2)

# Output the results
print(f"Number of ways to make sum {total_sum_1} with coins {coins_1}: {result_1}")
print(f"Number of ways to make sum {total_sum_2} with coins {coins_2}: {result_2}")
