package guerbai.chapter2_aha_algorithm;

import java.util.Arrays;

import static guerbai.util.Print.print;
import static java.lang.System.currentTimeMillis;

public class VectorLeftRoll {

    public void iSpaceRoll(char[] v, int rollDistance) {
        char[] cache = new char[rollDistance];
        for (int i=0; i<rollDistance; i++) {
            cache[i] = v[i];
        }
        for (int i=rollDistance; i<v.length; i++) {
            v[i-rollDistance] = v[i];
        }
        for (int i=0; i<rollDistance; i++) {
            v[v.length-rollDistance+i] = cache[i];
        }
    }

    private void moveOneRoll(char[] v) {
        char cache = v[0];
        for (int i=1; i<v.length; i++) {
            v[i-1] = v[i];
        }
        v[v.length-1] = cache;
    }

    public void moveOneMultiPerRoll(char[] v, int rollDistance) {
        for (int i=0; i<rollDistance; i++) {
            moveOneRoll(v);
        }
    }

    public void acrobatics(char[] v, int rollDistance) {
        int len = v.length;
        boolean[] rolled = new boolean[len];
        int dealCount = 0;
        int roundFrom = 0;
        while (dealCount<len) {
            char t = v[roundFrom];
            int fromIndex = (roundFrom + rollDistance) % len;
            int toIndex = roundFrom;
            while (fromIndex!=roundFrom) {
                if (!rolled[toIndex]) {
                    dealCount += 1;
                    rolled[toIndex] = true;
                }
                v[toIndex] = v[fromIndex];
                fromIndex = (fromIndex + rollDistance) % len;
                toIndex = (toIndex + rollDistance) % len;
            }
            if (!rolled[toIndex]) {
                dealCount += 1;
                rolled[toIndex] = true;
            }
            v[toIndex] = t;
            roundFrom += 1;
        }
    }

    public void rollHand(char[] v, int rollDistance) {
        reverse(v, 0, rollDistance-1);
        reverse(v, rollDistance, v.length-1);
        reverse(v, 0, v.length-1);
    }

    private void reverse(char[] v, int l, int r) {
        while (r-l>1) {
            char t = v[l];
            v[l] = v[r];
            v[r] = t;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        long startAt = currentTimeMillis();
        VectorLeftRoll ins = new VectorLeftRoll();
        char[] v = new char[52];
        // {'a', 'b', ..., 'Z'}
        for(int i=0; i<26; i++){
            v[i]=(char)('a'+i);
        }
        for(int i=0; i<26; i++){
            v[i+26]=(char)('A'+i);
        }
//        ins.iSpaceRoll(v, 17);
//        ins.moveOneMultiPerRoll(v, 13);
//        ins.acrobatics(v, 52);
//        ins.rollHand(v, 17);
        print(Arrays.toString(v));
        long endAt = currentTimeMillis();
        print("Program cost time: " + (float) (endAt - startAt) / 1000 + 's');
    }
}
