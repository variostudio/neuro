package org.troll.matrix;

public class Math {
    public static Matrix multiply (Matrix a, Matrix b) {
        if (a.getCols() == b.getRows()) {
            double[][] res = new double[a.getRows()][b.getCols()];

            double[][] aData = a.getData();
            double[][] bData = b.getData();

            for (int i=0; i<a.getRows(); i++) {
                for (int j=0; j<b.getCols(); j++) {
                    for (int k=0; k<aData[0].length; k++) {
                        res[i][j] += aData[i][k] * bData[k][j];
                    }
                }
            }

            return new Matrix(res);
        } else {
            throw new IllegalArgumentException("Matrix's are incompatible");
        }
    }

    public static double sigmoid(double x) {
        return 1/(1 + java.lang.Math.exp(-x));
    }

    public static Matrix sigmoid(Matrix x) {
        double[][] a = new double[x.getRows()][x.getCols()];
        double[][] data = x.getData();

        for (int i=0; i<x.getRows(); i++) {
            for (int j = 0; j < x.getCols(); j++) {
                a[i][j] = sigmoid(data[i][j]);
            }
        }

        return new Matrix(a);
    }
}
