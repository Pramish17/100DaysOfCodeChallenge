import java.util.Arrays;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // If the total gas is less than the total cost, return -1 (not possible)
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
            return -1;
        }

        int total = 0; // Tracks the running balance of gas
        int res = 0;   // Stores the starting index of the circuit

        // Loop through each gas station
        for (int i = 0; i < gas.length; i++) {
            total += (gas[i] - cost[i]); // Update the balance

            // If the balance goes negative, reset and try the next station
            if (total < 0) {
                total = 0; // Reset balance
                res = i + 1; // Update starting index
            }
        }

        return res; // Return the starting index of the valid circuit
    }

    public static void main(String[] args) {
        GasStation solution = new GasStation();

        // Example input
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        // Call the method and print the result
        int result = solution.canCompleteCircuit(gas, cost);
        System.out.println("The starting gas station index is: " + result);
    }
}
