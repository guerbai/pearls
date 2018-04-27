package guerbai.chapter1_opening;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class GenerateNumberFile {

    private final static int MAX_NUMBER = 10000000;

    public static void main(String[] args) throws IOException {
        // 生成1-10^7的int list.
        Random r = new Random();
        ArrayList<Integer> s = new ArrayList<>();
        for (int i = 0; i < MAX_NUMBER; i++) {
            s.add(i+1);
        }
        // System.out.println(s.size());
        int sLen = s.size();
        // 去掉20~50个元素.
        int removeCount = r.nextInt( 30) + 20; // 生成20~49之间的一个整数；
        System.out.println("now we remove " + removeCount + " item");
        while (removeCount>0) {
            int removeIndex = r.nextInt(sLen);
            // System.out.println("remove index " + removeIndex);
            // System.out.println("remove item " + s.get(removeIndex));
            s.remove(removeIndex);
            // System.out.println("now item at index " + s.get(removeIndex));
            removeCount--;
            sLen--;
        }
        PrintWriter writer = new PrintWriter("lot-number.txt", "UTF-8");
        while (sLen>0) {
            int removeIndex = r.nextInt(sLen);
            int removedItem = s.get(removeIndex);
            writer.println(removedItem);
            s.remove(removeIndex);
            sLen--;
            System.out.println(sLen);
        }
        writer.close();
    }
}
