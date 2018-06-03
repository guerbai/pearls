package guerbai.chapter5_programming_trifles;

import java.util.*;

import static guerbai.util.Print.print;
import static java.lang.System.currentTimeMillis;

public class EnsureCorrectBinarySearch {

    private static ArrayList<Integer> randomOrderList1= new ArrayList<>();
    private static ArrayList<Integer> randomOrderList10 = new ArrayList<>();
    private static ArrayList<Integer> randomOrderList100 = new ArrayList<>();
    private static ArrayList<Integer> randomOrderList1000 = new ArrayList<>();
    private static ArrayList<Integer> randomOrderList10000 = new ArrayList<>();
    private static Map<Integer, ArrayList<Integer>> numTestsDict = new HashMap<>();

    static {
        for (int i=0; i<10000000; i++) {
            randomOrderList1.add(i);
        }
        for (int i=0; i<1000000; i++) {
            randomOrderList10.add(i);
        }
        for (int i=0; i<100000; i++) {
            randomOrderList100.add(i);
        }
        for (int i=0; i<10000; i++) {
            randomOrderList1000.add(i);
        }
        for (int i=0; i<1000; i++) {
            randomOrderList10000.add(i);
        }
        Collections.shuffle(randomOrderList1);
        Collections.shuffle(randomOrderList10);
        Collections.shuffle(randomOrderList100);
        Collections.shuffle(randomOrderList1000);
        Collections.shuffle(randomOrderList10000);
        numTestsDict.put(1, randomOrderList1);
        numTestsDict.put(10, randomOrderList10);
        numTestsDict.put(100, randomOrderList100);
        numTestsDict.put(1000, randomOrderList1000);
        numTestsDict.put(10000, randomOrderList10000);
    }

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

    private static void assureLogN(int type) {
        // type 1: search from 1 to n, type 2: search with shuffle order.
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
                if (type==1) {
                    for (int j=0; j<n; j++) {
                        assert binarySearch(s, j) == j;
                    }
                }
                if (type==2) {
                    for (int j: numTestsDict.get(numtests)) {
                        assert binarySearch(s, j) == j;
                    }
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
//        assureLogN(1);
//        1000 10000 cost time: 0.564s
//        10000 1000 cost time: 0.888s
//        100000 100 cost time: 1.46s
//        1000000 10 cost time: 2.878s
//        10000000 1 cost time: 5.553s
        assureLogN(2);

        long endAt = currentTimeMillis();
        print("Program cost time: " + (float) (endAt - startAt) / 1000 + 's');
    }
}
