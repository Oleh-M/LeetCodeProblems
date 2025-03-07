from typing import List


class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        sum_of_elements = sum(nums[:k])
        max_average_value = sum_of_elements

        for i in range(k, len(nums)):
            sum_of_elements = sum_of_elements + nums[i] - nums[i - k]
            max_average_value = max(max_average_value, sum_of_elements)

        return max_average_value / k


if __name__ == '__main__':
    Solution().findMaxAverage([4,2,1,3,3], 2)
    Solution().findMaxAverage([1,12,-5,-6,50,3], 4)
    Solution().findMaxAverage([0,1,1,3,3], 4)