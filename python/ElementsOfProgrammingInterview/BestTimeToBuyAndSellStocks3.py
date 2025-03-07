from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        min_profit = float('inf')
        max_profit = 0
        profits_as_of_now = [0] * len(prices)

        for i, price in enumerate(prices):
            min_profit = min(min_profit, price)
            max_profit = max(max_profit, price - min_profit)
            profits_as_of_now[i] = max_profit

        max_current_profit = float('-inf')
        for i, price in reversed(list(enumerate(prices[1:], 1))):
            max_current_profit = max(
                max_current_profit,
                price
            )
            max_profit = max(max_profit, max_current_profit - price + profits_as_of_now[i])

        return max_profit