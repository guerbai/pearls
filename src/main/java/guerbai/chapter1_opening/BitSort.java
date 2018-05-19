package guerbai.chapter1_opening;

import org.apache.lucene.util.RamUsageEstimator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static guerbai.util.Print.print;
import static java.lang.System.currentTimeMillis;

public class BitSort {

    public static void main(String[] args) throws IOException {
        long startAt = currentTimeMillis();
        FileWriter fileWriter = new FileWriter("./sorted-number.txt");
        BufferedReader br = new BufferedReader(new FileReader("./lot-number.txt"));
        String line;
        MyBitSet s = new MyBitSet(10000000);
        ArrayList<Integer> missNumber = new ArrayList<>();
        print("BitSet cost memory: " + ((float)RamUsageEstimator.sizeOf(s))/1024/1024 + "M.");
        while ((line = br.readLine()) != null) {
            int lineNumber = Integer.parseInt(line);
            s.set(lineNumber-1);
        }
        for (int i=0; i<10000000; i++) {
            if (s.get(i)==1) {
                fileWriter.append(Integer.toString(i+1)).append(String.valueOf('\n'));
            } else {
                missNumber.add(i+1);
            }
        }
        fileWriter.close();
        print("Miss number is: " + missNumber);
        long endAt = currentTimeMillis();
        print("Program cost time: " + (float)(endAt-startAt)/1000 + 's');
    }
}
