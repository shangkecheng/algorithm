package algorithm;

import static java.lang.Math.floor;

//You are given an n x n 2D matrix representing an image.
//
//        Rotate the image by 90 degrees (clockwise).
//
//        Note:
//        You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
//
//        Example 1:
//Given input matrix =
//        [
//        [1,2,3],
//        [4,5,6],
//        [7,8,9]
//        ],
//
//        rotate the input matrix in-place such that it becomes:
//        [
//        [7,4,1],
//        [8,5,2],
//        [9,6,3]
//        ]
public class RotateImage90 {

    /**
     * Rotate.
     * @param matrix the matrix
     * first change row
     * second rotate diagonal
     */
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        if (matrix.length != matrix[0].length) {
            return;
        }
        rotateRow(matrix);
        rotateDiagonal(matrix);
    }

    public void rotateDiagonal(int[][] matrix) {
        for (int row = 0; row <= matrix.length - 1; row++) {
            for (int col = 0; col <= matrix[row].length - 1; col++) {
                if (col - row > 0) {
                    swap(matrix, row, col, col, row);
                }
            }
        }
    }

    public void rotateColumn(int[][] matrix) {
        for (int row = 0; row <= matrix.length - 1; row++) {
            int colNums = matrix[row].length;
            for (int col = 0; col <= floor(colNums / 2) - 1; col++) {
                swap(matrix, row, col, row, colNums - 1 - col);
            }
        }
    }

    public void rotateRow(int[][] matrix) {

        for (int row = 0; row <= floor(matrix.length / 2) - 1; row++) {
            int colNums = matrix[row].length;
            for (int col = 0; col <= colNums - 1; col++) {
                swap(matrix, row, col, matrix.length - 1 - row, col);
            }
        }

    }

    public void swap(int[][] matrix, int i, int j, int l, int m) {
        int a = matrix[i][j];
        matrix[i][j] = matrix[l][m];
        matrix[l][m] = a;
    }

    public void anotherSolution(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        if (matrix.length != matrix[0].length) {
            return;
        }

        int length = matrix.length;

        for (int i = 0; i < length / 2; i++) {
            for (int j = i; j < length - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length - j - 1][i];
                matrix[length - j - 1][i] = matrix[length - i - 1][length - j - 1];
                matrix[length - i - 1][length - j - 1] = matrix[j][length - i - 1];
                matrix[j][length - i - 1] = temp;

            }
        }

    }
}

