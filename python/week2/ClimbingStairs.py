class Solution:
    # TODO Fibonacci numbers solution
    def climbStairs(self, n: int) -> int:
        def climb(n: int, one_or_two: int, counter: int) -> int:
            if n - one_or_two == 0:
                return counter + 1
            else:
                return counter + climb(n - one_or_two, one_or_two, counter + 1)

        counter = 0
        counter += climb(n, 1, 0)
        counter += climb(n, 2, 0)
        return counter




if __name__ == '__main__':
    res = Solution().climbStairs(3)
    print()
