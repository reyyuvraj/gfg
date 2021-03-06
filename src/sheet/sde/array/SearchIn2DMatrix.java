package sheet.sde.array;

public class SearchIn2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }

    public boolean binary(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int low;
        int high;

        // first search in first column, use binary search
        for (low = 0, high = matrix.length - 1; low <= high; ) {
            int middle = (low + high) / 2;
            if (matrix[middle][0] < target) {
                low = middle + 1;
            } else if (matrix[middle][0] > target) {
                high = middle - 1;
            } else {
                return true;
            }
        }

        // when above loop ends, search in row[high]
        int row = high;
        if (row >= 0) {
            for (low = 0, high = matrix[row].length - 1; low <= high; ) {
                int middle = (low + high) / 2;
                if (matrix[row][middle] < target) {
                    low = middle + 1;
                } else if (matrix[row][middle] > target) {
                    high = middle - 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {//linearly searching
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] > target) j--;
            else i++;
        }
        return false;
    }
}