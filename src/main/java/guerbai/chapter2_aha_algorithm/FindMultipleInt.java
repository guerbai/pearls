package guerbai.chapter2_aha_algorithm;

import java.util.ArrayList;
import java.util.Collections;

import static guerbai.util.Print.print;
import static java.lang.System.currentTimeMillis;

public class FindMultipleInt {

    public static void main(String[] args) {
        long startAt = currentTimeMillis();
        int mask = 1<<3;
        int fillLength = 16;
        ArrayList<Integer> inspectArray = new ArrayList<>();
        for (int i=0; i<16; i++) {
            inspectArray.add(i);
        }
        Collections.shuffle(inspectArray);
        inspectArray.add(15);
        inspectArray.add(15);
        while (fillLength!=1) {
            ArrayList<Integer> zeroHalf = new ArrayList<>();
            ArrayList<Integer> oneHalf = new ArrayList<>();
            for (int i: inspectArray) {
                if ((mask & i)==0) {
                    zeroHalf.add(i);
                } else {
                    oneHalf.add(i);
                }
            }
            if (zeroHalf.size()>fillLength/2) {
                inspectArray = zeroHalf;
            } else {
                inspectArray = oneHalf;
            }
            mask = mask >>> 1;
            fillLength = fillLength/2;
        }
        int multipleNumber = inspectArray.get(0);
        print("I algo out a multiple number is " + multipleNumber);
        long endAt = currentTimeMillis();
        print("Program cost time: " + (float) (endAt - startAt) / 1000 + 's');
    }
}
