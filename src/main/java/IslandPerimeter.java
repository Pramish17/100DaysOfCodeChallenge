public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    result += 4;

                    // Check for a land cell above
                    if (i > 0 && grid[i - 1][j] == 1) {
                        result -= 2;
                    }

                    // Check for a land cell to the left
                    if (j > 0 && grid[i][j - 1] == 1) {
                        result -= 2;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        IslandPerimeter solution = new IslandPerimeter();

        int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };

        int perimeter = solution.islandPerimeter(grid);
        System.out.println("The perimeter of the island is: " + perimeter);
    }
}
