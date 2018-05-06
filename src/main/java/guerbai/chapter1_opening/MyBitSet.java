package guerbai.chapter1_opening;

import org.apache.lucene.util.RamUsageEstimator;

import static guerbai.util.Print.print;

public class MyBitSet {
    private static int ZERO = 1;
    private static int ONE = 2;
    private static int TWO = 4;
    private static int THREE = 8;
    private static int FOUR = 16;
    private static int FIVE = 32;
    private static int SIX = 64;
    private static int SEVEN = (byte) 128;
    private int size;
    private byte[] byteList;

    public MyBitSet(int size) {
        this.size = size;
        int byteCount = size / 8;
        int remainder = size % 8;
        if (remainder > 0) {
            byteCount++;
        }
        byteList = new byte[byteCount];
    }

    public int getSize() {
        return size;
    }

    public void set(int index) {
        int byteIndex = index / 8;
        int byteRemainder = index % 8;
        int mask = getMask(byteRemainder);
        byteList[byteIndex] = (byte) (byteList[byteIndex] | mask);
    }

    public void clear(int index) {
        int byteIndex = index / 8;
        int byteRemainder = index % 8;
        int mask = getMask(byteRemainder);
        byteList[byteIndex] = (byte) (byteList[byteIndex] & ~mask);
    }

    public byte get(int index) {
        int byteIndex = index / 8;
        int byteRemainder = index % 8;
        int mask = getMask(byteRemainder);
        if ((byte) (byteList[byteIndex] & mask) == mask) {
            return 1;
        } else {
            return 0;
        }
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

    private int getMask(int remainder) {
        int mask;
        switch (remainder) {
            case 0:
                mask = MyBitSet.ZERO;
                break;
            case 1:
                mask = MyBitSet.ONE;
                break;
            case 2:
                mask = MyBitSet.TWO;
                break;
            case 3:
                mask = MyBitSet.THREE;
                break;
            case 4:
                mask = MyBitSet.FOUR;
                break;
            case 5:
                mask = MyBitSet.FIVE;
                break;
            case 6:
                mask = MyBitSet.SIX;
                break;
            case 7:
                mask = MyBitSet.SEVEN;
                break;
            default:
                mask = MyBitSet.ZERO;
                break;
        }
        return mask;
    }

    public static void main(String[] args) {
        MyBitSet mbs = new MyBitSet(10000000);
        print(RamUsageEstimator.sizeOf(mbs));
        MyBitSet mbs2 = new MyBitSet(13);
        print(mbs2);
        mbs2.set(3);
        print(mbs2);
        mbs2.set(7);
        print(mbs2);
        mbs2.set(12);
        print(mbs2);
        mbs2.clear(7);
        print(mbs2);
    }
}
