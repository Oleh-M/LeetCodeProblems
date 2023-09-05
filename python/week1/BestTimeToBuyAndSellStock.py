from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        max_profit = 0
        left = 0
        right = 1
        while left < right < len(prices):
            max_profit = max(prices[right] - prices[left], max_profit)
            if prices[left] > prices[right]:
                left = right
                right += 1
            else:
                right += 1

        return max_profit

    def maxProfit_optimal(self, prices: List[int]) -> int:
        buy_price = float('inf')
        max_profit = 0
        for price in prices:
            buy_price = min(buy_price, price)
            max_profit = max(max_profit, price - buy_price)

        return max_profit

        return max_profit


if __name__ == '__main__':
    Solution().maxProfit([7, 1, 5, 3, 6, 4])
