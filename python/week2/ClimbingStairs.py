class Solution:
    def climbStairs(self, n: int) -> int:
        one = 1
        two = 1
        for i in range(n):
            temp = one
            one = one + two
            two = temp
        return one


if __name__ == '__main__':
    res = Solution().climbStairs(3)
    print()
