package guerbai.chapter4_correct_program;

import static guerbai.util.Print.print;
import static guerbai.util.Print.printnb;
import static java.lang.System.currentTimeMillis;

class LinearEquation {
    double a;
    double b;

    LinearEquation(double a, double b) {
        this.a = a;
        this.b = b;
    }

    double getY(double x) {
        return a * x + b;
    }
}

class Area {
    LinearEquation below;
    LinearEquation top;

    Area(LinearEquation below, LinearEquation top) {
        this.below = below;
        this.top = top;
    }

    boolean contain(double[] point) {
        return top.getY(point[0]) >= point[1] && below.getY(point[0]) < point[1];
    }

    boolean beyondPoint(double[] point) {
        return below.getY(point[0]) > point[1];
    }

    boolean belowPoint(double[] point) {
        return top.getY(point[0]) < point[1];
    }
}

public class SegmentsBinarySearch {

    public static LinearEquation[] segmentsBinarySearch(LinearEquation[] s, double[] point) {
        Area[] areas = new Area[s.length+1];
        for (int i=0; i<areas.length; i++) {
            if (i==0) {
                areas[i] = new Area(new LinearEquation(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY), s[i]);
            } else if (i==s.length) {
                areas[i] = new Area(s[i-1], new LinearEquation(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY));
            } else {
                areas[i] = new Area(s[i-1], s[i]);
            }
        }
        int l = 0;
        int r = s.length;
        while (true) {
            int mid = (r+l)/2;
            if (areas[mid].contain(point)) {
                return new LinearEquation[]{areas[mid].below, areas[mid].top};
            } else if (areas[mid].belowPoint(point)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
    }

    public static void printPointInfo(LinearEquation[] s, double[] point) {
        LinearEquation[] result = segmentsBinarySearch(s, point);
        print("point: (" + point[0] + ", " + point[1] + ")'s closest segment");
        for (LinearEquation linearEquation: result) {
            print("a: " + linearEquation.a + ", b: " + linearEquation.b);
        }
    }

    public static void main(String[] args) {
        long startAt = currentTimeMillis();

        // 构造[a0, a1, a(n-2)]与[b0, b1, b(n-2)].
        // 使x=0，则显然递增；
        // 使x=1，则ak+bk > a(k-1)+b(k-1), 之后有ak > a(k-1)+b(k-1)-bk;
        double[] a = new double[10];
        double[] b = new double[10];
        LinearEquation[] s = new LinearEquation[10];
        for (int i=0; i<a.length; i++) {
            b[i] = i;
            if (i==0) {
                a[i] = -2;
            } else {
                a[i] = a[i-1] + b[i-1] - b[i] + Math.random();
            }
            s[i] = new LinearEquation(a[i], b[i]);
        }
        double[] point = {0.1, -0.19};
        double[] point2 = {0.8, 0};
        printPointInfo(s, point);
        printPointInfo(s, point2);


        long endAt = currentTimeMillis();
        print("Program cost time: " + (float) (endAt - startAt) / 1000 + 's');
    }
}
