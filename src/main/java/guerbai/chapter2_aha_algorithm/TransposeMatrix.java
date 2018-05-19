package guerbai.chapter2_aha_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import static guerbai.util.Print.print;
import static guerbai.util.Print.printMatrix;
import static java.lang.System.console;
import static java.lang.System.currentTimeMillis;

class MatrixItemWithRowColumnIndex<T> {
    int row;
    int column;
    T item;
    MatrixItemWithRowColumnIndex(int row, int column, T item) {
        this.row = row;
        this.column = column;
        this.item = item;
    }
}

public class TransposeMatrix {

    public static <T> void transpose(T[][] matrix) {
        int totalRow = 0;
        int totalColumn = 0;
        for (T[] rowItems: matrix) {
            totalRow++;
        }
        for (T item: matrix[0]) {
            totalColumn++;
        }
        ArrayList<MatrixItemWithRowColumnIndex<T>> matrixItemWithRowColumnIndices = new ArrayList<>();
        int row = 0;
        for (T[] rowItems: matrix) {
            int column = 0;
            for (T item: rowItems) {
                matrixItemWithRowColumnIndices.add(new MatrixItemWithRowColumnIndex(row, column, item));
                column++;
            }
            row++;
        }
        Collections.shuffle(matrixItemWithRowColumnIndices);
        matrixItemWithRowColumnIndices.sort((MatrixItemWithRowColumnIndex a, MatrixItemWithRowColumnIndex b)
                -> a.column==b.column? a.row-b.row: a.column-b.column);
        int lastIndex = 0;
        for (int i=0; i<totalRow; i++) {
            for (int j=0; j<totalColumn; j++) {
                matrix[i][j] = matrixItemWithRowColumnIndices.get(lastIndex).item;
                lastIndex++;
            }
        }
    }

    public static void main(String[] args) {
        long startAt = currentTimeMillis();

        Integer[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printMatrix(matrix);
        TransposeMatrix.transpose(matrix);
        print("After deal:");
        printMatrix(matrix);

        long endAt = currentTimeMillis();
        print("Program cost time: " + (float) (endAt - startAt) / 1000 + 's');
    }
}
