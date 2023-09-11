from collections import Counter
from typing import List


class Solution:
    def majorityElement_first(self, nums: List[int]) -> int:
        res = {}
        length = len(nums) // 2

        for i in nums:
            n = res.get(i, 0) + 1
            if n <= length:
                res[i] = n
            else:
                return i
        return nums[0]

    def majorityElement(self, nums: List[int]) -> int:
        count = 0
        current = nums[0]

        for i in nums:
            if current == i:
                count += 1
            elif current != i and count != 0:
                count -= 1
            else:
                count = 1
                current = i

        return current
