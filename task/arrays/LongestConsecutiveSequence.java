package arrays;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        var numSet = new HashSet<Integer>(nums.length);
        for (int num : nums) {
            numSet.add(num);
        }

        int longestSeq = 0;
        for (int num : nums) {
            if (!numSet.contains(num - 1)) {
                var length = 0;
                while (numSet.contains(num + length)) {
                    length++;
                }
                longestSeq = Math.max(longestSeq, length);
            }
        }

        return longestSeq;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        System.out.println(longestConsecutive(new int[]{1, 2, 0, 1}));
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
