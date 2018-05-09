package guerbai.chapter1_opening;

import static guerbai.util.Print.print;

public class DelayInitialBitSet extends MyBitSet {

    private int[] from;
    private int[] to;
    private int top;

    public DelayInitialBitSet(int size) {
        super(size);
        from = new int[size];
        to = new int[size];
        top = 0;
        for (int j=0; j<size; j++) {
            super.set(j);
        }
    }

    private void firstVisit(int index) {
        if (from[index]<top && to[from[index]]==index) {
            print(index + " already inited.");
        } else {
            clear(index);
            from[index] = top;
            to[top] = index;
            top++;
        }
    }

    @Override
    public void set(int index) {
        firstVisit(index);
        super.set(index);
    }

    @Override
    public byte get(int index) {
        firstVisit(index);
        return super.get(index);
    }

    public static void main(String[] args) {
        DelayInitialBitSet s = new DelayInitialBitSet(9);
        print(s);
        DelayInitialBitSet s2 = new DelayInitialBitSet(11);
        s2.set(5);
        print(s2);
    }
}

