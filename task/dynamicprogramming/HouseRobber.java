package dynamicprogramming;

public class HouseRobber {

    public static int rob(int[] nums) {
        int rob = 0,
                notRob = 0;

        for (int num : nums) {
            int currRob = notRob + num;
            notRob = Math.max(rob, notRob);
            rob = currRob;
        }

        return Math.max(rob, notRob);
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(rob(new int[]{2, 1, 1, 2}));
    }
}
