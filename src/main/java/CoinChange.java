public class CoinChange {
    public int coinChange(int[] denominations, int targetAmount) {
        // Array to store the minimum number of coins needed for each amount
        int[] minCoins = new int[targetAmount + 1];

        // Initialize each entry with an unreasonably large value (unreachable state)
        for (int currentAmount = 1; currentAmount <= targetAmount; currentAmount++) {
            minCoins[currentAmount] = targetAmount + 1;
        }

        // Base case: 0 coins are needed to make amount 0
        minCoins[0] = 0;

        // Compute the minimum coins required for each amount
        for (int currentAmount = 1; currentAmount <= targetAmount; currentAmount++) {
            for (int coin : denominations) {
                if (currentAmount >= coin) {
                    minCoins[currentAmount] = Math.min(minCoins[currentAmount], minCoins[currentAmount - coin] + 1);
                }
            }
        }

        // If it's impossible to form the target amount, return -1
        return minCoins[targetAmount] > targetAmount ? -1 : minCoins[targetAmount];
    }

    public static void main(String[] args) {
        // Create an instance of the CoinChange class
        CoinChange coinChangeSolver = new CoinChange();

        // Example 1
        int[] coins1 = {1, 5, 10};
        int amount1 = 12;
        System.out.println("Minimum coins needed: " + coinChangeSolver.coinChange(coins1, amount1)); // Output: 3

        // Example 2
        int[] coins2 = {2};
        int amount2 = 3;
        System.out.println("Minimum coins needed: " + coinChangeSolver.coinChange(coins2, amount2)); // Output: -1

        // Example 3
        int[] coins3 = {1};
        int amount3 = 0;
        System.out.println("Minimum coins needed: " + coinChangeSolver.coinChange(coins3, amount3)); // Output: 0
    }
}
