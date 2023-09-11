class Solution:
    def addBinary(self, a: str, b: str) -> str:
        res = ""
        carry = 0

        a, b = a[::-1], b[::-1]

        for i in range(max(len(a), len(b))):
            # minus "0" to transform a[i] to number
            binaryA = ord(a[i]) - ord("0") if i < len(a) else 0
            binaryB = ord(b[i]) - ord("0") if i < len(b) else 0

            total = binaryA + binaryB + carry
            res = str(total % 2) + res
            carry = total // 2

        return "1" + res if carry else res

    def addBinary2(self, a: str, b: str) -> str:
        res = ""
        carry = 0

        i, j = len(a) - 1, len(b) - 1

        while i >= 0 and j >= 0 or carry:
            digitA = int(a[i]) if i >= 0 else 0
            digitB = int(b[i]) if j >= 0 else 0
            total = digitA + digitB + carry
            res = str(total % 2) + res
            carry = total // 2

        return "".join(res[::-1])

if __name__ == '__main__':
    res1 = Solution().addBinary("11", "1")
    res2 = Solution().addBinary("1010", "1011")
    print()