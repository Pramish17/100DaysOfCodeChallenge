public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (word.charAt(0) == board[r][c]) {
                    boolean found = dfs(board, word, r, c, 0);
                    if (found) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int wordIndex) {
        if (wordIndex == word.length()) {
            return true; // Word found
        }

        int rows = board.length;
        int cols = board[0].length;

        // Check boundaries and current character
        if (r < 0 || c < 0 || r >= rows || c >= cols || board[r][c] == ' ' || board[r][c] != word.charAt(wordIndex)) {
            return false;
        }

        // Save the current character and mark the cell as visited
        char ch = board[r][c];
        board[r][c] = ' ';

        // Explore in all 4 directions
        boolean found = dfs(board, word, r - 1, c, wordIndex + 1) || // Up
                dfs(board, word, r, c + 1, wordIndex + 1) || // Right
                dfs(board, word, r + 1, c, wordIndex + 1) || // Down
                dfs(board, word, r, c - 1, wordIndex + 1);   // Left

        // Restore the character (backtracking)
        board[r][c] = ch;

        return found;
    }

    // Main method for testing
    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();

        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word = "ABCCED";
        boolean result = wordSearch.exist(board, word);

        System.out.println("Word found: " + result); // Output: true
    }
}
