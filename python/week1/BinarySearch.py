from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        right = len(nums) - 1
        left = 0
        while right >= left:
            mid = left + (right - left) // 2
            if nums[mid] > target:
                right = right-1
            elif nums[mid] < target:
                left = left + 1
            else:
                return mid

        return -1



if __name__ == '__main__':
    res1 = Solution().search([-1,0,3,5,9,12], 9)
    res2 = Solution().search([-1,0,3,5,9,12], 2)
    print()