package dynamicprogramming;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(5));
        System.out.println(climbStairs(2));
    }

    public static int climbStairs(int n) {
        int one = 1,
                two = 1;

        for (int i = 0; i < n - 1; i++) {
            int tmp = one + two;
            two = one;
            one = tmp;
        }
        return one;
    }
}
