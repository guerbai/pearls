package guerbai.chapter5_programming_trifles;

import java.util.Scanner;

import static guerbai.util.Print.print;
import static java.lang.System.currentTimeMillis;

public class EnsureCorrectBinarySearch {

    private static boolean sorted(int[] s) {
        for (int i=0; i<s.length-1; i++) {
            if (s[i] > s[i+1]) {
                return false;
            }
        }
        return true;
    }


    static int binarySearch(int[] s, int t) {
//        assert sorted(s);
        int l = 0;
        int r = s.length - 1;
        while (l<=r) {
            int mid = (l + r) / 2;
            if (s[mid] < t) {
                l = mid + 1;
            } else if (s[mid] == t) {
                return mid;
            } else {
                r = mid - 1;
            }
        }
        assert ((r<0 || s[r]<t) && (r+1>=s.length || s[r+1]>t));
        return -1;
    }

    private static void runScanTestTool() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        while (n != 0) {
            print(n + " " + t);
            int[] s = new int[n];
                for (int i=0; i<n; i++) {
                    s[i] = i * 10;
                }
                print(binarySearch(s, t));
            n = scanner.nextInt();
            t = scanner.nextInt();
        }
    }

    private static void runAutomatedTestTool() {
        for (int n=0; n<1001; n++) {
            int[] s = new int[n+1];
            for (int i=0; i<n+1; i++) {
                s[i] = 10 * i;
            }
            for (int i=0; i<n; i++) {
                assert binarySearch(s, 10*i) == i;
                assert binarySearch(s, 10*i-5) == -1;
            }
            assert binarySearch(s, 10*s.length-5) == -1;
            assert binarySearch(s, 10*s.length) == -1;
            for (int i=0; i<n; i++) {
                s[i] = 10;
            }
            if (n==0) {
                assert binarySearch(s, 10) == -1;
            }
            else {
                assert 0<=binarySearch(s, 10) && binarySearch(s, 10) < n;
            }
            assert binarySearch(s, 5) == -1;
            assert binarySearch(s, 15) == -1;
        }
    }

    private static void assureLogN() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int numtests  = scanner.nextInt();
        int[] s = new int[n];
        while (n != 0) {
            for (int i=0; i<n; i++) {
                s[i] = i;
            }
            long startAt = currentTimeMillis();
            for (int i=0; i<numtests; i++) {
                for (int j=0; j<n; j++) {
                    assert binarySearch(s, j) == j;
                }
            }
            long endAt = currentTimeMillis();
            print(n + " " + numtests + " " + "cost time: " + (float) (endAt - startAt) / 1000 + 's');
            n = scanner.nextInt();
            numtests  = scanner.nextInt();
            s = new int[n];
        }
    }

    public static void main(String[] args) {
        long startAt = currentTimeMillis();

//        runScanTestTool();
//        说明assert sorted(s)起作用;
//        int[] s = {2, 9, 3};
//        binarySearch(s, 7);
//        runAutomatedTestTool();

//        1000 10000 cost time: 0.42s
//        10000 1000 cost time: 0.479s
//        100000 100 cost time: 0.537s
//        1000000 10 cost time: 0.608s
//        10000000 1 cost time: 0.677s
//         y = a + b * log(n, 2)
//         a = 0.22270000000000006
//         b = 0.019356228721193993
//        执行binarySearch的次数一样均为10000000次.
        assureLogN();

        long endAt = currentTimeMillis();
        print("Program cost time: " + (float) (endAt - startAt) / 1000 + 's');
    }
}
