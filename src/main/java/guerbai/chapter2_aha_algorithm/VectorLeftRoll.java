package guerbai.chapter2_aha_algorithm;

import java.util.Arrays;

import static guerbai.util.Print.print;
import static guerbai.util.Print.printList;
import static java.lang.System.currentTimeMillis;

public class VectorLeftRoll {

    public char[] iSpaceRoll(char[] v, int rollDistance) {
        char[] rolled = new char[v.length];
        char[] cache = new char[rollDistance];
        for (int i=0; i<rollDistance; i++) {
            cache[i] = v[i];
        }
        for (int i=rollDistance; i<v.length; i++) {
            rolled[i-rollDistance] = v[i];
        }
        for (int i=0; i<rollDistance; i++) {
            rolled[v.length-rollDistance+i] = cache[i];
        }
        return rolled;
    }

    private char[] moveOneRoll(char[] v) {
        char cache = v[0];
        char[] rolled = new char[v.length];
        for (int i=1; i<v.length; i++) {
            rolled[i-1] = v[i];
        }
        rolled[v.length-1] = cache;
        return rolled;
    }

    public char[] moveOneMultiPerRoll(char[] v, int rollDistance) {
        char[] rolled = v;
        for (int i=0; i<rollDistance; i++) {
            rolled = moveOneRoll(rolled);
        }
        return rolled;
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
//        char[] rolled = ins.iSpaceRoll(v, 26);
        char[] rolled = ins.moveOneMultiPerRoll(v, 26);
        print(Arrays.toString(rolled));
        long endAt = currentTimeMillis();
        print("Program cost time: " + (float) (endAt - startAt) / 1000 + 's');
    }
}
