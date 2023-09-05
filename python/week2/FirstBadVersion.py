class Solution:
    def firstBadVersion(self, n: int) -> int:
        left = 0
        right = n
        first_bad_version = n
        while left <= right:
            mid = left + (right - left) // 2
            if self.isBadVersion(mid):
                right = mid - 1
                first_bad_version = mid
            else:
                left = mid + 1
        return first_bad_version

    def isBadVersion(self, n: int) -> bool:
        return n >= 1702766719


if __name__ == '__main__':
    res0 = Solution().firstBadVersion(2126753390)
    res1 = Solution().firstBadVersion(5)
    res2 = Solution().firstBadVersion(1)
    print()
