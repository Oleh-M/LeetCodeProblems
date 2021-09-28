package binarysearch;

public class Sqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(64));
        System.out.println(mySqrt(113));
    }

    public static int mySqrt(int x) {
        if (x < 2) return x;

        double mid, pow, left = 1, right = x;

        while (left < right) {
            mid = left + Math.floor((right - left) / 2);
            pow = mid * mid;
            if (pow == x) {
                return Double.valueOf(mid).intValue();
            }
            else if (pow > x) right = mid;
            else left = mid + 1;
        }

        return Double.valueOf(left).intValue() - 1;
    }
}
