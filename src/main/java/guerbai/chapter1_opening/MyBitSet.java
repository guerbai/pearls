package guerbai.chapter1_opening;

import org.apache.lucene.util.RamUsageEstimator;

import static guerbai.util.Print.print;

public class MyBitSet {
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
        if ((byte) (byteList[byteIndex] & mask) == 0) {
            return 0;
        } else {
            return 1;
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
        return 1<<remainder;
    }

    public static void main(String[] args) {
        MyBitSet mbs = new MyBitSet(10000000);
        print("10000000 size BitSet cost: " + RamUsageEstimator.sizeOf(mbs) + "bytes.");
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
