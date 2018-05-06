package guerbai.chapter1_opening;

import org.apache.lucene.util.RamUsageEstimator;

import java.util.ArrayList;
import java.util.BitSet;

import static guerbai.util.Print.print;

public class CheckSpaceAndTime {

    public static void main(String[] args) {
        print("Start at: " + System.currentTimeMillis());
        ArrayList<Integer> s = new ArrayList<>();
        for (int i=0; i<10000000; i++) {
            s.add(i);
        }
        int[] sss = new int[10000000];
        for (int i=0; i<10000000; i++) {
            sss[i] = i;
        }
        BitSet ss = new BitSet(10000000);
        print("ArrayList cost memory: " + RamUsageEstimator.sizeOf(s) + "bytes.");
        print("BitSet cost memory: " + RamUsageEstimator.sizeOf(ss) + "bytes.");
        print("List cost memory: " + RamUsageEstimator.sizeOf(sss) + "bytes.");
        print("End at: " + System.currentTimeMillis());
    }
}
