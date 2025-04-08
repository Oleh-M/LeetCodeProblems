from typing import List


class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        self.merge_sort(nums, 0, len(nums) - 1)

        return nums

    def merge_sort(self, arr, left, right):
        if left < right:
            mid = (left + right) // 2
            self.merge_sort(arr, left, mid)
            self.merge_sort(arr, mid + 1, right)
            return self.merge(arr, left, mid, right)

    def merge(self, arr, left, mid, right):
        n1 = mid - left + 1
        n2 = right - mid
        L = [0] * n1
        R = [0] * n2

        for i in range(n1):
            L[i] = arr[i + left]
        for i in range(n2):
            R[i] = arr[i + mid + 1]

        l, r, k = 0, 0, left

        while l < n1 and r < n2:
            if L[l] < R[r]:
                arr[k] = L[l]
                l += 1
            else:
                arr[k] = R[r]
                r += 1
            k += 1

        while l < n1:
            arr[k] = L[l]
            l += 1
            k += 1
        while r < n2:
            arr[k] = R[r]
            r += 1
            k += 1
