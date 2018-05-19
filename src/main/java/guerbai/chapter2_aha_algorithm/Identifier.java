package guerbai.chapter2_aha_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static guerbai.util.Print.print;
import static java.lang.System.currentTimeMillis;

public class Identifier {

    public static String toLetterMark(String word) {
        Map<Character, Integer> letterCount = new HashMap<>();
        for (int i=0; i<26; i++) {
            letterCount.put((char)('a'+i), 0);
        }
        for (int i=0; i<word.length(); i++) {
            char s = word.charAt(i);
            int originCount = letterCount.get(s);
            letterCount.put(s, originCount+1);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i<26; i++) {
            char key = (char)('a'+i);
            stringBuilder.append(key);
            stringBuilder.append(letterCount.get(key));
        }
        return stringBuilder.toString();
    }

    private static char charToPhoneNumber(char c) {
        if (c>='A' && c<='A'+26) {
            c = (char)(c + 'a' - 'A');
        }
        if (c=='a' || c=='b' || c=='c') {
            return '2';
        } else if (c=='d' || c=='e' || c=='f') {
            return '3';
        } else if (c=='g' || c=='h' || c=='i') {
            return '4';
        } else if (c=='j' || c=='k' || c=='l') {
            return '5';
        } else if (c=='m' || c=='n' || c=='o') {
            return '6';
        } else if (c=='p' || c=='r' || c=='s') {
            return '7';
        } else if (c=='t' || c=='u' || c=='v') {
            return '8';
        } else if (c=='w' || c=='x' || c=='y') {
            return '9';
        } else {
            throw new java.lang.RuntimeException("unknown char to phone.");
        }
    }

    // 习题6， 生成关于英文名的电话号码标识.
    public static String namePhoneMark(String name) {
        StringBuilder stringBuilder = new StringBuilder();
        String firstName = name.split(" ")[0];
        String lastName = name.split(" ")[1];
        for (int i=0; i<lastName.length(); i++) {
            stringBuilder.append(Identifier.charToPhoneNumber(lastName.charAt(i)));
        }
        stringBuilder.append('*');
        stringBuilder.append(Identifier.charToPhoneNumber(firstName.charAt(0)));
        stringBuilder.append('*');
        return stringBuilder.toString();
    }

    // 习题1，采用hashmap来保存标识，则二分什么的是不存在的，直接O(1)找到变位词.
    public static void findAnagram(String word, Map<String, ArrayList<String>> anagramDict) {
        String identifier = Identifier.toLetterMark(word);
        if (anagramDict.containsKey(identifier)) {
            print(word + "'s anagram are: " + anagramDict.get(identifier));
        } else {
            print("we don't have anagram of word: " + word);
        }
    }

    public static void main(String[] args) {
        long startAt = currentTimeMillis();
        ArrayList<String> dict = new ArrayList<>(Arrays.asList(
                "pans", "pots", "opt", "snap", "stop", "tops"));
        Map<String, ArrayList<String>> result = new HashMap<>();
        for (String word: dict) {
            String identifier = Identifier.toLetterMark(word);
            if (!result.containsKey(identifier)) {
                result.put(identifier, new ArrayList<>());
            }
            result.get(identifier).add(word);
        }
        print(result);
        String word1 = "span";
        String word2 = "spang";
        Identifier.findAnagram(word1, result);
        Identifier.findAnagram(word2, result);

        // 习题6client, 其余如上使用HashMap即可，不再赘述.
        String name = "Mike Lesk";
        String nameIdentifier = Identifier.namePhoneMark(name);
        print(nameIdentifier);
        long endAt = currentTimeMillis();
        print("Program cost time: " + (float) (endAt - startAt) / 1000 + 's');
    }
}
