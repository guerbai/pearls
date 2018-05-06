package guerbai.chapter1_opening;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import static guerbai.util.Print.print;

public class LibSort {
    public static void main(String[] args) throws IOException{
        long startAt = System.currentTimeMillis();
        String fileName = "./lot-number.txt";
        String targetFileName = "./sorted-number2.txt";
        FileWriter fileWriter = new FileWriter(targetFileName);
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        ArrayList<Integer> numberArray = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            numberArray.add(Integer.parseInt(line));
        }
        Collections.sort(numberArray);
        for (int number: numberArray) {
            fileWriter.append(Integer.toString(number)).append('\n');
        }
        fileWriter.close();
        br.close();
        long endAt = System.currentTimeMillis();
        print("Program cost time: " + (float)(endAt-startAt)/1000 + 's');
    }
}
