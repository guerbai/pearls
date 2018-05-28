package guerbai.chapter4_correct_program;

import static guerbai.util.Print.print;
import static java.lang.System.currentTimeMillis;

public class BinarySearch {

    public static int compareCount = 0;

    public static int binarySearch(int[] x,int t) {
        int l = 0;
        int r = x.length-1;
        while (true) {
            compareCount++;
            if (r<l) {
                return -1;
            }
            int mid = (r+l) / 2;
            if (x[mid] > t) {
                r = mid - 1;
            } else if (x[mid] < t) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
    }

    public static int recursionBinarySearch(int[] x, int t, int l, int r) {
        compareCount++;
        if (r<l) {
            return -1;
        }
        int mid = (r+l) / 2;
        if (x[mid] > t) {
            return recursionBinarySearch(x, t, l, mid-1);
        } else if (x[mid] < t) {
            return recursionBinarySearch(x, t, mid+1, r);
        } else {
            return mid;
        }
    }

    public static void measureTimeO() {
        for (int i=0; i<20; i++) {
            int length = (int) Math.pow(2, i);
            int[] s = new int[length];
            for (int j=0; j<length; j++) {
                s[j] = j;
            }
//            binarySearch(s, -1);
            recursionBinarySearch(s, -1, 0, s.length-1);
            print(length + " " + compareCount);
            compareCount = 0;
        }
    }

    public static void main(String[] args) {
        long startAt = currentTimeMillis();

//        int[] s = {1, 3, 7, 21, 88, 155, 899, 1000, 2551, 10034, 12343, 123456, 6543211};
//        print(binarySearch(s, 1000));
//        print(recursionBinarySearch(s, 1000, 0, s.length-1));
//        print(binarySearch(s, 2657));
//        print(recursionBinarySearch(s, 2657, 0, s.length-1));
//        print(binarySearch(s, 888888));
//        print(recursionBinarySearch(s, 888888, 0, s.length-1));
//        print(binarySearch(s, 6543211));
//        print(recursionBinarySearch(s, 6543211, 0, s.length-1));
//        print(binarySearch(s, -20));
//        print(recursionBinarySearch(s, -20, 0, s.length-1));
//
//        int[] s1 = {};
//        print(binarySearch(s1, 2));
//        print(recursionBinarySearch(s1, 2, 0, s1.length-1));
        measureTimeO();

        long endAt = currentTimeMillis();
        print("Program cost time: " + (float) (endAt - startAt) / 1000 + 's');
    }
}
