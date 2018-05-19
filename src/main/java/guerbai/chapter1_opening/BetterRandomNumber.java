package guerbai.chapter1_opening;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import static guerbai.util.Print.print;
import static java.lang.System.currentTimeMillis;

public class BetterRandomNumber {

    private final static int MAX_NUMBER = 10000000;

    public static void main(String[] args) throws IOException {
        long startAt = currentTimeMillis();
        Random r = new Random(47);
        int removeCount = r.nextInt( 30) + 20;
        int[] s = new int[MAX_NUMBER];
        for (int i=0; i<MAX_NUMBER; i++) {
            s[i] = i+1;
        }
        for (int j=0; j<MAX_NUMBER; j++) {
            int randomIndex = r.nextInt(MAX_NUMBER-1);
            int temp = s[j];
            s[j] = s[randomIndex];
            s[randomIndex] = temp;
        }
        print("We remove " + removeCount + " numbers");
        PrintWriter writer = new PrintWriter("lot-number2.txt", "UTF-8");
        for (int k=0; k<MAX_NUMBER-removeCount; k++) {
            writer.println(s[k]);
        }
        writer.close();
        long endAt = currentTimeMillis();
        print("Program cost time: " + (float) (endAt - startAt) / 1000 + "s");
    }
}
