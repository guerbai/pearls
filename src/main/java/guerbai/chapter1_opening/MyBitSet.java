package guerbai.chapter1_opening;

import org.apache.lucene.util.RamUsageEstimator;

public class MyBitSet {
    private static short ZERO = 1;
    private static short ONE = 2;
    private static short TWO = 4;
    private static short THREE = 8;
    private static short FOUR = 16;
    private static short FIVE = 32;
    private static short SIX = 64;
    private static short SEVEN = 128;
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
        short mask = getMask(byteRemainder);
        byteList[byteIndex] = (byte) (byteList[byteIndex] | mask);
    }

    public void clear(int index) {
        int byteIndex = index / 8;
        int byteRemainder = index % 8;
        short mask = getMask(byteRemainder);
        byteList[byteIndex] = (byte) (byteList[byteIndex] & ~mask);
    }

    public byte get(int index) {
        int byteIndex = index / 8;
        int byteRemainder = index % 8;
        short mask = getMask(byteRemainder);
        if ((short) (byteList[byteIndex] & mask) == mask) {
            return 1;
        } else {
            return 0;
        }
    }

    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append('[');
        for (int i=0; i<size; i++) {
            s.append(get(i)+", ");
        }
        s.append(']');
        return new String(s);
    }

    private short getMask(int remainder) {
        short mask;
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
        mbs.set(9);
        System.out.println(mbs.get(9));
        mbs.set(9);
        System.out.println(mbs.get(9));
        mbs.set(13);
        mbs.set(188888);
        mbs.set(1888889);
        mbs.get(189888);
        mbs.set(1888800);
        mbs.set(20);
        mbs.clear(9);
        System.out.println(mbs.get(9));
        mbs.clear(9);
        System.out.println(mbs.get(9));
//        System.out.println(mbs.toString());
        System.out.println(mbs.get(12));
        System.out.println(mbs.get(13));
        System.out.println(mbs.getSize());
        System.out.println(RamUsageEstimator.sizeOf(mbs));
    }

}
