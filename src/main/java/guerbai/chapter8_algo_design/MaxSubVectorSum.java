package guerbai.chapter8_algo_design;

import guerbai.util.Print;

import static guerbai.util.Print.print;
import static guerbai.util.Print.printnb;
import static java.lang.System.currentTimeMillis;

public class MaxSubVectorSum {

    private static int plainSolution1(int[] v) {
        int max = 0;
        for (int i=0; i<v.length; i++) {
            int sum = 0;
            for (int j=i; j<v.length; j++) {
                sum += v[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    private static int plainSolution2(int[] v) {
        int[] vTillSum = new int[v.length+1];
        int tillSum = 0;
        vTillSum[0] = 0;
        for (int i=0; i<v.length; i++) {
            tillSum += v[i];
            vTillSum[i+1] = tillSum;
        }
        int max = 0;
        for (int i=0; i<v.length; i++) {
            for (int j=i; j<=v.length; j++) {
                int sum = vTillSum[j] - vTillSum[i];
                max = Math.max(sum, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        long startAt = currentTimeMillis();

        int[] v = {31, -41, 59, 26, -53, 58, 97, -93, -23, 84};
        print(plainSolution1(v));
        print(plainSolution2(v));
        int[] v1 = {-31, -41, -59, -26, -53, -58, -2, -93, -23, 84};
        print(plainSolution1(v1));
        print(plainSolution2(v1));

        long endAt = currentTimeMillis();
        print("Program cost time: " + (float) (endAt - startAt) / 1000 + 's');
    }
}
