package guerbai.chapter1_opening;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static guerbai.util.Print.print;
import static java.lang.System.currentTimeMillis;

public class CheckNumberFile {

    private final static int MAX_NUMBER = 10000000;

    private static void check(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        int[] s = new int[MAX_NUMBER];
        String line;
        while ((line = br.readLine()) != null) {
            try {
                int number = Integer.parseInt(line);
                if (number>MAX_NUMBER || number<0) {
                    print("Number not in bound." + number);
                    System.exit(1);
                }
                if (s[number-1]!=0) {
                    print("multiple number " + number);
                    System.exit(2);

                }
                s[number-1] = number;
            } catch (NumberFormatException e) {
                print("No Number input: " + line);
                System.exit(3);
            }
        }
        print("ok number file!");
    }

    public static void main(String[] args) throws IOException {
        long startAt = currentTimeMillis();
        CheckNumberFile.check("lot-number1.txt");
        long endAt = currentTimeMillis();
        print("Program cost time: " + (float) (endAt - startAt) / 1000 + "s");
    }
}
