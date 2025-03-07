from typing import (
    List,
)

class Solution:
    def wiggle_sort(self, nums: List[int]):
        for i in range(len(nums) - 1):
            if (i % 2 == 0 and nums[i] > nums[i + 1]) or (i % 2 != 0 and nums[i] < nums[i + 1]):
                nums[i], nums[i + 1] = nums[i + 1], nums[i]
        print(nums)

if __name__ == '__main__':
    Solution().wiggle_sort([3,5,2,1,6,4])