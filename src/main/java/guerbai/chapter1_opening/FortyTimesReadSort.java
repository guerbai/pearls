package guerbai.chapter1_opening;

import org.apache.lucene.util.RamUsageEstimator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FortyTimesReadSort {

    public static void main(String[] args) throws IOException{
        System.out.println("Start at: " + System.currentTimeMillis());
        String fileName = "./lot-number.txt";
        String targetFileName = "./sorted-number.txt";
        FileWriter fileWriter = new FileWriter(targetFileName);
        int count = 1;
        ArrayList<Integer> missNumber = new ArrayList<>();

        for (int i=0; i<40; i++) {
            int start = i*250000 + 1;
            int end = i*250000 + 250000;
            int[] oneTimeArray = new int[250000];
            for (int initIndex=0; initIndex<oneTimeArray.length; initIndex++) {
                oneTimeArray[initIndex] = 10000001;
            }
            BufferedReader br = new BufferedReader(new FileReader(fileName));
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
            System.out.println("ArrayList cost memory: " + RamUsageEstimator.sizeOf(oneTimeArray) + "bytes.");
            for (int j=0; j<arrayIndex; j++) {
                fileWriter.append(Integer.toString(oneTimeArray[j])).append(String.valueOf('\n'));
                while (oneTimeArray[j]!=count) {
                    missNumber.add(count);
                    count++;
                }
                count++;
            }
        }
        System.out.println(missNumber);
        fileWriter.close();
        System.out.println("End at: " + System.currentTimeMillis());
    }
}
