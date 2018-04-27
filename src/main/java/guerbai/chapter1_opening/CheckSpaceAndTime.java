package guerbai.chapter1_opening;

import org.apache.lucene.util.RamUsageEstimator;

import java.util.ArrayList;
import java.util.BitSet;

public class CheckSpaceAndTime {

    public static void main(String[] args) {
        System.out.println("Start at: " + System.currentTimeMillis());
        ArrayList<Integer> s = new ArrayList<>();
        for (int i=0; i<10000000; i++) {
            s.add(i);
        }
        int[] sss = new int[10000000];
        for (int i=0; i<10000000; i++) {
            sss[i] = i;
        }
        BitSet ss = new BitSet(10000000);
        System.out.println("ArrayList cost memory: " + RamUsageEstimator.sizeOf(s) + "bytes.");
        System.out.println("BitSet cost memory: " + RamUsageEstimator.sizeOf(ss) + "bytes.");
        System.out.println("List cost memory: " + RamUsageEstimator.sizeOf(sss) + "bytes.");
        System.out.println("End at: " + System.currentTimeMillis());
    }
}
