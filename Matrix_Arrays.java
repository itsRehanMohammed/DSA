package DSA;

public class Matrix_Arrays {
    public static boolean searchKey(int matrix[][], int key) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == key) {
                    System.out.println("Found key at " + "(" + i + "," + j + ")");
                    return true;
                }
            }
        }
        return false;
    }

    public static void maxValue(int matrix[][]) {
        int max_Value = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (max_Value < matrix[i][j]) {
                    max_Value = matrix[i][j];
                }
            }
        }
        System.out.println(max_Value);
    }

    public static void minValue(int matrix[][]) {
        int min_Value = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (min_Value > matrix[i][j]) {
                    min_Value = matrix[i][j];
                }
            }
        }
        System.out.println(min_Value);
    }

    // Google, Microsoft, Amazon, Apple, Oracle, Adobe
    public static void spiralMatrix(int matrix[][]) {
        int startRow = 0, startCol = 0, endRow = matrix.length - 1, endCol = matrix[0].length - 1;
        while (startRow <= endRow && startCol <= endCol) {
            // Top
            for (int j = startCol; j <= endCol; j++) {
                System.out.print(matrix[startRow][j] + " ");
            }
            // Right
            for (int i = startRow + 1; i <= endRow; i++) {

                System.out.print(matrix[i][endCol] + " ");
            }
            // Bottom
            for (int j = endCol - 1; j >= startCol; j--) {
                if (startRow == endRow) {
                    break;
                }
                System.out.print(matrix[endRow][j] + " ");
            }

            // Left
            for (int i = endRow - 1; i >= startRow + 1; i--) {
                if (startCol == endCol) {
                    break;
                }
                System.out.print(matrix[i][startCol] + " ");
            }
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
    }

    // Microsoft, Amazon, Samsung
    public static int diagonalSum(int matrix[][]) {
        int sum = 0;

        // Brute force approach O(n2)
        // for (int i = 0; i < matrix.length; i++) {
        // for (int j = 0; j < matrix[0].length; j++) {
        // if (i == j) {
        // sum += matrix[i][j]; // primary_diagonal
        // } else if ((i + j) == matrix.length - 1) {
        // sum += matrix[i][j]; // secondary_diagonal
        // }
        // }
        // }

        // Optimise Solution O(n)
        for (int i = 0; i < matrix.length; i++) {
            // primary_diagonal
            sum += matrix[i][i];
            // secondary_diagonal
            if (i != (matrix.length - 1 - i)) {
                sum += matrix[i][matrix.length - 1 - i];
            }
        }
        return sum;
    }

    // Adobe
    public static boolean search_In_Sorted_Matrix(int matrix[][], int key) {
        // O(n+m)
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == key) {
                System.out.println("key found at = " + "(" + row + "," + col + ")");
                return true;
            } else if (matrix[row][col] < key) {
                row++;
            } else {
                col--;
            }
        }
        System.out.println("Key Not Found");
        return false;
    }

    public static void main(String args[]) {
        int matrix[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
    }
}
