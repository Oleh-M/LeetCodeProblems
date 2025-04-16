from typing import List


class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        nums.sort()
        res = []
        i = 0
        n = len(nums)

        while i < n:
            j = i + 1
            while j < n:
                goal = target - nums[i] + nums[j]
                left = j + 1
                right = n - 1

                while left < right:
                    if goal == nums[left] + nums[right]:
                        res.append([nums[i], nums[j], nums[left], nums[right]])
                        while left + 1 < right and nums[left + 1] == nums[left]:
                            left += 1
                        left += 1
                        right -= 1
                    elif goal < nums[left] + nums[right]:
                        right -= 1
                    else:
                        left += 1
                while j + 1 < n and nums[j + 1] == nums[j]:
                    j += 1
                j += 1
            while i + 1 < n and nums[i + 1] == nums[i]:
                i += 1
            i += 1

        return res

if __name__ == '__main__':
    Solution().fourSum([-3,-1,0,2,4,5], 0)