package guerbai.chapter3_data_struct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static guerbai.util.Print.print;
import static java.lang.System.currentTimeMillis;

public class GetMA {

    public static ArrayList<Long> getMA(int k, ArrayList<Long> AK, ArrayList<Long> CK, int m) {
        ArrayList<Long> result = new ArrayList<>();
        for (int i=0; i<k; i++) {
            result.add(AK.get(i));
        }
        if (m <= k) {
            return new ArrayList<>(result.subList(0, m));
        }
        int pointer = 0;
        for (int i=0; i<m-k; i++) {
            long AI = 0;
            for (int j=0; j<k; j++) {
                int akIndex = (pointer+k-1-j)%k;
                AI += CK.get(j)*AK.get(akIndex);
            }
            result.add(AI);
            AK.set(pointer, AI);
            pointer = (pointer+1)%k;
        }
        return result;
    }

    public static void main(String[] args) {
        long startAt = currentTimeMillis();

        ArrayList<Long> result = GetMA.getMA(
                3,
                new ArrayList<>(Arrays.asList((long)1, (long)2, (long)3)),
                new ArrayList<>(Arrays.asList((long)2, (long)3, (long)4)),
              100
        );
        print(result);

        long endAt = currentTimeMillis();
        print("Program cost time: " + (float) (endAt - startAt) / 1000 + 's');
    }
}
