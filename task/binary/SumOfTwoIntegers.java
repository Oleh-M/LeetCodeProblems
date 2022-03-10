package binary;

public class SumOfTwoIntegers {
    public static int getSum(int a, int b) {
        while (b != 0) {
            int tmp = (a & b) << 1;
            a ^= b;
            b = tmp;
        }

        return a;
    }

    public static void main(String[] args) {
        System.out.println(getSum(1, 2));
        System.out.println(getSum(2, 3));
        System.out.println(getSum(-4, 1));
    }
}
