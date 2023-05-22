package org.troll.matrix;

import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
public class Matrix {
    private final double[][] data;
    private final int cols;
    private final int rows;

    public Matrix(double[][] a) {
        data = a;
        cols = a[0].length;
        rows = a.length;
    }

    public String toString() {
        String caption = "Matrix of size [" + cols + ", " + rows + "]: ";
        StringBuilder content = new StringBuilder("\n");

        for (int i=0; i<rows; i++) {
            for (int j=0; j < cols; j++) {
                content.append("   ").append(data[i][j]);
            }
            content.append('\n');
        }

        return caption + content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        return cols == matrix.cols && rows == matrix.rows && arraysAreEquals(data, matrix.data);
    }

    private boolean arraysAreEquals(double[][] a, double[][] b) {
        double delta = 0.00000001;

        for (int i=0; i<a.length; i++) {
            for (int j=0; j < a[i].length; j++) {
                if (java.lang.Math.abs(a[i][j] - b[i][j]) > delta) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(cols, rows);
        result = 31 * result + Arrays.deepHashCode(data);
        return result;
    }
}
