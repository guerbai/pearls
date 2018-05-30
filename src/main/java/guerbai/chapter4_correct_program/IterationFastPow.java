package guerbai.chapter4_correct_program;

import static guerbai.util.Print.print;
import static java.lang.System.currentTimeMillis;

public class IterationFastPow {

    public static int pow(int x, int n) {
        int result = 1;
        int evenMul = x;
        while (n>0) {
            if (n%2==1) {
                // important deal.
                result *= evenMul;
            }
            evenMul *= evenMul;
            n = n / 2;
        }
        return result;
    }

    public static void main(String[] args) {
        long startAt = currentTimeMillis();

        print(pow(2, 1));
        print(pow(2, 2));
        print(pow(2, 3));
        print(pow(2, 4));
        print(pow(2, 5));
        print(pow(2, 6));
        print(pow(2, 7));
        print(pow(2, 8));
        print(pow(2, 10));
        print(pow(13, 5));
        print(pow(10000, 0));
        print(pow(1000000, 1));

        long endAt = currentTimeMillis();
        print("Program cost time: " + (float) (endAt - startAt) / 1000 + 's');
    }
}
