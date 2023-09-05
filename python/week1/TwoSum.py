from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        res_dict = dict()
        for i, elem in enumerate(nums):
            if target - elem in res_dict:
                return [res_dict.get(target - elem), i]
            else:
                res_dict[elem] = i




if __name__ == '__main__':
    Solution().twoSum([2,7,11,15], 9)