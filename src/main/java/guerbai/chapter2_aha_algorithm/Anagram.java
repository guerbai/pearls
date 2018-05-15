package guerbai.chapter2_aha_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static guerbai.util.Print.print;
import static java.lang.System.currentTimeMillis;

public class Anagram {

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

    // 习题1，采用hashmap来保存标识，则二分什么的是不存在的，直接O(1)找到变位词.
    public static void findAnagram(String word, Map<String, ArrayList<String>> anagramDict) {
        String identifier = Anagram.toLetterMark(word);
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
            String identifier = Anagram.toLetterMark(word);
            if (!result.containsKey(identifier)) {
                result.put(identifier, new ArrayList<>());
            }
            result.get(identifier).add(word);
        }
        print(result);
        String word1 = "span";
        String word2 = "spang";
        Anagram.findAnagram(word1, result);
        Anagram.findAnagram(word2, result);
        long endAt = currentTimeMillis();
        print("Program cost time: " + (float) (endAt - startAt) / 1000 + 's');
    }
}