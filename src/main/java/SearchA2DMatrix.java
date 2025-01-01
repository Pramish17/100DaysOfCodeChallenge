public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        /**
         * Use binary search to get an optimal solution.
         * To find the midpoint element in a 2D array,
         * midpointElement = matrix[midpoint / columns][midpoint % columns]
         */
        if (matrix.length == 0) return false;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int midpoint = left + (right - left) / 2;
            int midpointElement = matrix[midpoint / cols][midpoint % cols];

            if (midpointElement == target) {
                return true;
            } else if (target < midpointElement) {
                right = midpoint - 1;
            } else {
                left = midpoint + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        SearchA2DMatrix solution = new SearchA2DMatrix();

        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 3;

        boolean result = solution.searchMatrix(matrix, target);
        System.out.println("Target found: " + result); // Expected output: true
    }
}
