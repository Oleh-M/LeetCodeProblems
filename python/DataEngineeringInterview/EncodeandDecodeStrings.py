from typing import List


class Solution:

    def encode(self, strs: List[str]) -> str:
        return ' '.join(f"{len(s)}#{s}" for s in strs)

    def decode(self, s: str) -> List[str]:
        i = 0
        result = []

        while i < len(s):
            delimiter_pos = s.find('#', i)
            if delimiter_pos == -1:
                break

            length = int(s[i:delimiter_pos])
            start = delimiter_pos + 1
            end = start + length

            result.append(s[start:end])
            i = end

        return result