package guerbai.chapter3_data_struct;

import guerbai.chapter1_opening.MyBitSet;

import java.util.Arrays;

import static guerbai.util.Print.print;
import static guerbai.util.Print.printList;
import static java.lang.System.currentTimeMillis;

public class LEDNumber {

    private MyBitSet ledUnit = new MyBitSet(7);

    LEDNumber(int i) {
        setNumber(i);
    }

    public void setNumber(int i) {
        if (i>9 || i<0) {
            throw new java.lang.RuntimeException("not such led.");
        }
        for (int j=0; j<ledUnit.getSize(); j++) {
            ledUnit.clear(j);
        }
        switch (i) {
            case 0:
                ledUnit.setMultiple(0, 2, 3, 4, 5, 6);
                break;
            case 1:
                ledUnit.setMultiple(4, 6);
                break;
            case 2:
                ledUnit.setMultiple(0, 1, 2, 4, 5);
                break;
            case 3:
                ledUnit.setMultiple(0, 1, 2, 4, 6);
                break;
            case 4:
                ledUnit.setMultiple(1, 3, 4, 6);
                break;
            case 5:
                ledUnit.setMultiple(0, 1, 2, 3, 6);
                break;
            case 6:
                ledUnit.setMultiple(0, 1, 2, 3, 5, 6);
                break;
            case 7:
                ledUnit.setMultiple(2, 4, 6);
                break;
            case 8:
                ledUnit.setMultiple(0, 1, 2, 3, 4, 5, 6);
                break;
            case 9:
                ledUnit.setMultiple(1, 2, 3, 4, 6);
                break;
            default:
                break;
        }
    }

    public int[] getBitArray() {
        int[] res = new int[7];
        for (int i=0; i<7; i++) {
            if (ledUnit.get(i)==1) {
                res[i] = 1;
            } else {
                res[i] = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        long startAt = currentTimeMillis();

        int number = 51234;
        int tenAt5 = number/10000;
        int tenAt4 = (number%10000)/1000;
        int tenAt3 = (number%1000)/100;
        int tenAt2 = (number%100)/10;
        int tenAt1 = (number%10);
        int[] printNumber = {tenAt5, tenAt4, tenAt3, tenAt2, tenAt1};
        for (int i: printNumber) {
            LEDNumber ledNumber = new LEDNumber(i);
            print(Arrays.toString(ledNumber.getBitArray()));
        }



        long endAt = currentTimeMillis();
        print("Program cost time: " + (float) (endAt - startAt) / 1000 + 's');
    }
}
