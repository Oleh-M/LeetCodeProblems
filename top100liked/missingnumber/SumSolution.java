package missingnumber;

public class SumSolution {
    public static void main(String[] args) {
        missingNumber(new int[] {0,2,1,4});
    }

    public static int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }
}