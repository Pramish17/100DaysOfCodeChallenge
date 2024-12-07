public class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        int[] count = new int[n + 1];
        for (int[] t : trust) {
            count[t[0]]--; // Decrease the count for the person who trusts someone
            count[t[1]]++; // Increase the count for the person being trusted
        }
        for (int i = 1; i <= n; i++) {
            if (count[i] == n - 1) return i; // The town judge is trusted by everyone else
        }
        return -1; // If no town judge is found
    }

    // Main method to test the function
    public static void main(String[] args) {
        FindTheTownJudge solution = new FindTheTownJudge();
        int n = 3;
        int[][] trust = {{1, 3}, {2, 3}};
        int result = solution.findJudge(n, trust);
        System.out.println("The town judge is: " + result); // Expected output: 3
    }
}
