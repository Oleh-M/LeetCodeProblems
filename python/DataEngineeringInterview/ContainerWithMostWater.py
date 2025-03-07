from typing import List


class Solution:
    def maxArea(self, height: List[int]) -> int:
        max_area = 0

        left, right = 0, len(height) - 1
        while left < right:
            max_area = max(max_area, height[left] + height[right])
            if height[right] > height[left]:
                left += 1
            else:
                right -= 1

        return max_area

if __name__ == '__main__':
    Solution().maxArea([1,8,6,2,5,4,8,3,7])