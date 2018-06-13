package guerbai.chapter8_algo_design;

import static guerbai.util.Print.print;
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

    private static int partionSolution(int[] v) {
        return partionSolutionRecursion(v, 0, v.length-1);
    }

    private static int partionSolutionRecursion(int[] v, int l, int r) {
        if (l>r) return 0;
        if (l==r) return Math.max(v[l], 0);
        int m = (l + r) / 2;
        int lmax = 0;
        int rmax = 0;
        int sum = 0;
        for (int i=m; i>=l; i--) {
            sum += v[i];
            lmax = Math.max(sum, lmax);
        }
        sum = 0;
        for (int i=m+1; i<=r; i++) {
            sum += v[i];
            rmax = Math.max(sum, rmax);
        }
        return Math.max(lmax+rmax, Math.max(partionSolutionRecursion(v, l, m), partionSolutionRecursion(v, m+1, r)));
    }

    private static int scanLinearSolution(int[] v) {
        int maxSoFar = 0;
        int maxEndingHere = 0;
        for (int i=0; i<v.length; i++) {
            maxEndingHere = Math.max(maxEndingHere+v[i], 0);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }
        return maxSoFar;
    }


    public static void main(String[] args) {
        long startAt = currentTimeMillis();

        int[] v = {31, -41, 59, 26, -53, 58, 97, -93, -23, 84};
        print(plainSolution1(v));
        print(plainSolution2(v));
        print(partionSolution(v));
        print(scanLinearSolution(v));
        int[] v1 = {-31, -41, -59, -26, -53, -58, -2, -93, -23, 84};
        print(plainSolution1(v1));
        print(plainSolution2(v1));
        print(partionSolution(v1));
        print(scanLinearSolution(v1));
        int[] v2 = {-31, -41, 59, 26, -53, 58, -2, 93, 23, 84};
        print(partionSolution(v2));
        print(scanLinearSolution(v2));
        int[] v3 = {};
        print(partionSolution(v3));
        print(scanLinearSolution(v3));
        int[] v4 = {-1};
        print(partionSolution(v4));
        print(scanLinearSolution(v4));
        int[] v5 = {-31, -41, -59, -26, -53, 58, -2, -93, -23, 84};
        print(scanLinearSolution(v5));

        long endAt = currentTimeMillis();
        print("Program cost time: " + (float) (endAt - startAt) / 1000 + 's');
    }
}
