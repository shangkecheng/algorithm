package test;

import algorithm.RotateImage90;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RotateImage90Test {
    private RotateImage90 solution;
    int[][] input_matrix =
            new int[][]{
            {1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int[][] output_matrix =
            new int[][]{
                    {7,4,1}, {8,5,2}, {9,6,3}};


    @Before
    public void setUp() {
        solution = new RotateImage90();
    }

    @Test
    public void TestRotate90() {
        solution.rotate(input_matrix);
        Assert.assertArrayEquals("not equal",output_matrix,input_matrix);
    }

    @Test
    public void TestRotateColumn() {
        int[][] output_matrix =
                new int[][]{
                        {3,2,1}, {6,5,4}, {9,8,7}};
        solution.rotateColumn(input_matrix);
        Assert.assertArrayEquals("not equal",output_matrix,input_matrix);
    }
    //        [1,2,3], 3,2,1
    //        [4,5,6], 6,5,4
   //         [7,8,9]  9,8,7

//    @Test
//    public void TestRotateDiagonal() {
//        int[][] output_matrix =
//                new int[][]{
//                        {7,8,9}, {4,5,6}, {1,2,3}};
//        solution.rotateDiagonal(input_matrix);
//        Assert.assertArrayEquals("not equal",output_matrix,input_matrix);
//    }


    @Test
    public void TestRow() {
        int[][] output_matrix =
                new int[][]{
                        {7,8,9}, {4,5,6}, {1,2,3}};
        solution.rotateRow(input_matrix);
        Assert.assertArrayEquals("not equal",output_matrix,input_matrix);
    }
}
