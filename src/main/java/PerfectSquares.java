public class PerfectSquares {
    public int numSquares(int n) {
        int[] cache = new int[n + 1];
        cache[0] = 0;

        for (int i = 1; i <= n; i++) {
            cache[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                cache[i] = Math.min(cache[i], cache[i - (j * j)] + 1);
            }
        }
        return cache[n];
    }

    public static void main(String[] args) {
        PerfectSquares solution = new PerfectSquares();
        int n = 12; // Example input
        System.out.println("The least number of perfect square numbers summing to " + n + " is: " + solution.numSquares(n));
    }
}
