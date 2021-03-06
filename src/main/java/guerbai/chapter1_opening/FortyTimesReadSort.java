package guerbai.chapter1_opening;

import org.apache.lucene.util.RamUsageEstimator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static guerbai.util.Print.print;

public class FortyTimesReadSort {

    public static void main(String[] args) throws IOException{
        long startAt = System.currentTimeMillis();
        FileWriter fileWriter = new FileWriter("./sorted-number.txt");
        int count = 1;
        ArrayList<Integer> missNumber = new ArrayList<>();

        for (int i=0; i<40; i++) {
            int start = i*250000 + 1;
            int end = i*250000 + 250000;
            int[] oneTimeArray = new int[250000];
            for (int initIndex=0; initIndex<oneTimeArray.length; initIndex++) {
                oneTimeArray[initIndex] = 10000001;
            }
            BufferedReader br = new BufferedReader(new FileReader("./lot-number.txt"));
            String line;
            int arrayIndex = 0;
            while ((line = br.readLine()) != null) {
                int n = Integer.parseInt(line);
                if (n>=start && n<=end) {
                    oneTimeArray[arrayIndex] = n;
                    arrayIndex += 1;
                }
            }
            br.close();
            Arrays.sort(oneTimeArray);
            print("ArrayList cost memory: " + RamUsageEstimator.sizeOf(oneTimeArray) + "bytes.");
            for (int j=0; j<arrayIndex; j++) {
                fileWriter.append(Integer.toString(oneTimeArray[j])).append(String.valueOf('\n'));
                while (oneTimeArray[j]!=count) {
                    missNumber.add(count);
                    count++;
                }
                count++;
            }
        }
        print("miss number are: " + missNumber);
        fileWriter.close();
        long endAt = System.currentTimeMillis();
        print("Program cost time: " + (float)(endAt-startAt)/1000 + 's');
    }
}
