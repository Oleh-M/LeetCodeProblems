package dynamicprogramming;

public class Stock {
    public static void main(String[] args) {
//        System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));
//        System.out.println(maxProfit(new int[] {7,6,4,3,1}));
        System.out.println(maxProfit(new int[]{8, 5, 2, 4, 54, 1, 3, 12, 32, 4, 5, 6, 7, 7, 43, 4, 2}));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int left = 0;
        int right = 1;
        int maxProfit = 0;

        while (right < prices.length) {
            if (prices[right] > prices[left]) {
                maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
            } else left = right;

            right++;
        }

        return maxProfit;
    }
}
