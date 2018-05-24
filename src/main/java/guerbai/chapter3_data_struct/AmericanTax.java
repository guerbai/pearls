package guerbai.chapter3_data_struct;

import static guerbai.util.Print.print;
import static java.lang.System.currentTimeMillis;

public class AmericanTax {

    public static double formDrivenCountTax(double income) {
        // form head: income start, income end, base, tax_rate.
        // 当然此处亦可以写一个类，生成几个对象，再搞一个列表，可以更加语义化.
        double[][] taxInfoForm = {
                {0, 2200, 0, 0},
                {2200, 2700, 0, 0.14},
                {2700, 3200, 70, 0.15},
                {3200, 3700, 145, 0.16},
                {3700, 4200, 225, 0.17},
        };
        for (double[] taxInfoLine: taxInfoForm) {
            if (income>taxInfoLine[0] && income<=taxInfoLine[1]) {
                return taxInfoLine[2] + taxInfoLine[3] * (income - taxInfoLine[0]);
            }
        }
        throw new java.lang.RuntimeException("income incorrect.");
    }

    public static void main(String[] args) {
        long startAt = currentTimeMillis();

        double income = 3201;
        print(AmericanTax.formDrivenCountTax(income));

        long endAt = currentTimeMillis();
        print("Program cost time: " + (float) (endAt - startAt) / 1000 + 's');
    }
}
