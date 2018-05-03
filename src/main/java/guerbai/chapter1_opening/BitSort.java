package guerbai.chapter1_opening;

import org.apache.lucene.util.RamUsageEstimator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BitSort {

    public static void main(String[] args) throws IOException {
        long startAt = System.currentTimeMillis();
        String fileName = "./lot-number.txt";
        String targetFileName = "./sorted-number.txt";
        FileWriter fileWriter = new FileWriter(targetFileName);
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        MyBitSet s = new MyBitSet(10000000);
        ArrayList<Integer> missNumber = new ArrayList<>();
        System.out.println("BitSet cost memory: " + ((float)RamUsageEstimator.sizeOf(s))/1024/1024 + "M.");
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
        System.out.println("Miss number is: " + missNumber);
        long endAt = System.currentTimeMillis();
        System.out.println("Program cost time: " + (float)(endAt-startAt)/1000 + 's');
    }
}
