package guerbai.util;
// Copy from https://github.com/BruceEckel/TIJ4-code for easy print.

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Item {
    int i;
    Item(int i) {
        this.i = i;
    }
}

public class Print {

    // Print with a newline:
    public static void print(Object obj) {
        System.out.println(obj);
    }
    // Print a newline by itself:
    public static void print() {
        System.out.println();
    }
    // Print with no line break:
    public static void printnb(Object obj) {
        System.out.print(obj);
    }
    // The new Java SE5 printf() (from C):
    public static PrintStream
    printf(String format, Object... args) {
        return System.out.printf(format, args);
    }

    public static <T> void printList(T[] v) {
        for (T t: v) {
            print(t);
        }
    }

    public static <T> void printMatrix(T[][] m) {
        for (T[] list: m) {
            for (T i: list) {
                print(i);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Item> s = new ArrayList<>();
        s.add(new Item(9));
        s.add(new Item(3));
        s.add(new Item(7));
        for (int i=0; i<s.size(); i++) {
            print(s.get(i).i);
        }
        s.sort(Comparator.comparingInt(a -> a.i));
        for (int i=0; i<s.size(); i++) {
            print(s.get(i).i);
        }

    }
}
