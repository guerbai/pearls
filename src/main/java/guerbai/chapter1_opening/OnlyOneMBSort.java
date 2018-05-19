package guerbai.chapter1_opening;

import org.apache.lucene.util.RamUsageEstimator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static guerbai.util.Print.print;
import static java.lang.System.currentTimeMillis;

public class OnlyOneMBSort {
    public static void main(String[] args) throws IOException {
        long startAt = currentTimeMillis();
        FileWriter fileWriter = new FileWriter("./sorted-number.txt");
        ArrayList<Integer> missNumber = new ArrayList<>();
        for (int readTime=0; readTime<2; readTime++) {
            MyBitSet s = new MyBitSet(5000000);
            print("BitSet cost memory: " + ((float)RamUsageEstimator.sizeOf(s))/1024/1024 + "M.");
            BufferedReader br = new BufferedReader(new FileReader("./lot-number1.txt"));
            String line;
            int startNumber = readTime*5000000 + 1;
            int endNumber = readTime*5000000 + 5000000;
            while ((line = br.readLine()) != null) {
                int lineNumber = Integer.parseInt(line);
                if (lineNumber>=startNumber && lineNumber<=endNumber) {
                    s.set(lineNumber-readTime*5000000-1);
                }
            }
            for (int j=0; j<5000000; j++) {
                if (s.get(j)==1) {
                    fileWriter.append(Integer.toString(j+startNumber)).append(String.valueOf('\n'));
                } else {
                    missNumber.add(j+startNumber);
                }
            }
            br.close();
        }
        fileWriter.close();
        print("Miss number is: " + missNumber);
        long endAt = currentTimeMillis();
        print("Program cost time: " + (float) (endAt - startAt) / 1000 + "s");
    }
}
