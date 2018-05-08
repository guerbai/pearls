package guerbai.chapter1_opening;

import static guerbai.util.Print.print;

public class OccurTimesLessTen {
    private static int FRONT_ONE_END_ZERO = 240;
    private static int FRONT_ZERO_END_ONE = 15;
    private int size;
    private byte[] byteList;

    public OccurTimesLessTen(int size) {
        this.size = size;
        int byteCount = size / 2;
        int remainder = size % 2;
        if (remainder > 0) {
            byteCount++;
        }
        byteList = new byte[byteCount];

    }

    public int getSize() {
        return size;
    }

    public byte get(int index) {
        int byteIndex = index / 2;
        int byteRemainder = index % 2;
        byte value = byteList[byteIndex];
        if (byteRemainder == 1) {
            value = (byte) (value>>>4);
        } else {
            value = (byte) (value & FRONT_ZERO_END_ONE);
        }
        return value;
    }

    public void set(int index, int value) {
        if (value>=10) {
            print("index "+index+" beyond limit!");
            throw new java.lang.RuntimeException();
        }
        int byteIndex = index / 2;
        int byteRemainder = index % 2;
        int mask;
        if (byteRemainder == 1) {
            value = (byte)(value<<4);
            mask = FRONT_ZERO_END_ONE;
        } else {
            mask = FRONT_ONE_END_ZERO;
        }
        byte mid = (byte)(byteList[byteIndex] & mask);
        byte result = (byte)(mid | value);
        byteList[byteIndex] = result;
    }

    public void inc(int index) {
        byte value = get(index);
        if (value>=10) {
            print("index "+index+" beyond limit!");
            throw new java.lang.RuntimeException();
        }
        set(index, value+1);
    }

    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append('[');
        for (int i=0; i<size; i++) {
            s.append(get(i)).append(", ");
        }
        s.append(']');
        return new String(s);
    }

    public static void main(String[] args) {
        OccurTimesLessTen s = new OccurTimesLessTen(23);
//        print(s);
        s.set(5, 1);
        print(s.get(5));
        print(s.get(4));
        s.set(5, 10);
//        print(s);
        OccurTimesLessTen s1 = new OccurTimesLessTen(7);
        int[] numbers = {1, 3, 6, 4, 1, 2, 1, 1, 1};
        for (int number: numbers) {
            s1.inc(number);
        }
        print(s1);
    }
}
