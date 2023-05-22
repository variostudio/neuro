package org.troll.matrix;

import org.junit.Assert;
import org.junit.Test;

public class MathTest {
    @Test
    public void sigmoidTest() {
        Assert.assertEquals(0.5, Math.sigmoid(0), 0.00001);
    }

    @Test
    public void matrixZeroSigmoidTest() {
        double[][] a = {{0, 0}};
        Matrix m_a = new Matrix(a);

        Matrix b = Math.sigmoid(m_a);

        double[][] e = {{0.5, 0.5}};
        Matrix expected = new Matrix(e);

        Assert.assertEquals(expected, b);
    }

    @Test
    public void matrixSigmoidTest() {
        double[][] a = {{1.16}, {0.42}, {0.62}};
        Matrix m_a = new Matrix(a);

        Matrix b = Math.sigmoid(m_a);

        double[][] e = {{0.7613327148429104}, {0.6034832498647263}, {0.6502185485738271}};
        Matrix expected = new Matrix(e);

        Assert.assertEquals(expected, b);
    }

    @Test
    public void testMultiplySmallMatrices() {
        double[][] aData = {{1,1},{1,1}};
        double[][] bData = {{1},{1}};
        double[][] eData = {{2},{2}};

        Matrix a = new Matrix(aData);
        Matrix b = new Matrix(bData);

        Matrix c = Math.multiply(a, b);
        Matrix expected = new Matrix(eData);

        Assert.assertEquals(expected, c);
    }

    @Test
    public void testMultiplySmallMatrices3by3() {
        double[][] aData = {{0.9, 0.3, 0.4}, {0.2, 0.8, 0.2}, {0.1, 0.5, 0.6}};
        double[][] bData = {{0.9}, {0.1}, {0.8}};
        double[][] eData = {{1.16}, {0.42}, {0.62}};

        Matrix a = new Matrix(aData);
        Matrix b = new Matrix(bData);

        Matrix c = Math.multiply(a, b);
        Matrix expected = new Matrix(eData);

        Assert.assertEquals(expected, c);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCannotMultiply() {
        double[][] aData = {{1,1},{1,1}};
        double[][] bData = {{1}};

        Matrix a = new Matrix(aData);
        Matrix b = new Matrix(bData);

        Math.multiply(a, b);
    }
}
