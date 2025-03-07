from typing import List


class Solution:
    def sumEvenAfterQueries(self, nums: List[int], queries: List[List[int]]) -> List[int]:
        result_sum = []

        for (i, j) in queries:
            print(i, j)

if __name__ == '__main__':
    Solution().sumEvenAfterQueries([1,2], [[3,4], [5,6]])