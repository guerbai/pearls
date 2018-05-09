package guerbai.chapter2_aha_algorithm;

import java.util.ArrayList;
import java.util.Collections;

import static guerbai.util.Print.print;
import static java.lang.System.currentTimeMillis;

public class BitUpBinaryFind {

    public static void main(String[] args) {
        long startAt = currentTimeMillis();
        int mask = 1<<3;
        int fillLength = 16;
        ArrayList<Integer> inspectArray = new ArrayList<>();
        for (int i=0; i<16; i++) {
            inspectArray.add(i);
        }
        Collections.shuffle(inspectArray);
        int removedNumber = inspectArray.remove(0);
        print(removedNumber + " was removed.");
        int removedNumber2 = inspectArray.remove(0);
        print(removedNumber2 + " was removed.");
        int removedNumber3 = inspectArray.remove(0);
        print(removedNumber3 + " was removed.");
        while (inspectArray.size()>1) {
            ArrayList<Integer> zeroHalf = new ArrayList<>();
            ArrayList<Integer> oneHalf = new ArrayList<>();
            for (int i: inspectArray) {
                if ((mask & i)==0) {
                    zeroHalf.add(i);
                } else {
                    oneHalf.add(i);
                }
            }
            if (zeroHalf.size()==0) {
                print((oneHalf.get(0)-mask)+" miss.");
                System.exit(1);
            }
            if (oneHalf.size()==0) {
                print((zeroHalf.get(0)+mask)+" miss.");
                System.exit(1);
            }
            if (zeroHalf.size()<fillLength/2) {
                inspectArray = zeroHalf;
            } else {
                inspectArray = oneHalf;
            }
            mask = mask >>> 1;
            fillLength = fillLength/2;
        }
        int adjacent = inspectArray.get(0);
        int countedMissNumber;
        if (adjacent%2==1) {
            countedMissNumber = adjacent - 1;
        } else {
            countedMissNumber = adjacent + 1;
        }
        print("I algo out a miss number is " + countedMissNumber);
        long endAt = currentTimeMillis();
        print("Program cost time: " + (float) (endAt - startAt) / 1000 + 's');
    }
}
