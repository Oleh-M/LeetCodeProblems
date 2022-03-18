package dynamicprogramming;

import java.util.TreeSet;

public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        var treeSet = new TreeSet<Integer>();
        for (int num : nums) {
            Integer ceiling = treeSet.ceiling(num);
            if (null != ceiling) {
                treeSet.remove(ceiling);
            }

            treeSet.add(num);
        }

        return treeSet.size();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{1, 2, 3}));
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println(lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
    }
}
