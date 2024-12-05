import java.util.Arrays;
import java.util.Collections;

public class MatchsticksToSquare {
    public boolean makesquare(int[] sticks) {
        if (sticks == null || sticks.length < 4) return false;

        int totalLength = Arrays.stream(sticks).sum();
        if (totalLength % 4 != 0) return false; // The total length must be divisible by 4 to form a square.

        int targetSideLength = totalLength / 4;

        // Sort the array in descending order using a comparator
        sticks = Arrays.stream(sticks)
                .boxed() // Convert to Integer stream
                .sorted(Collections.reverseOrder()) // Sort in descending order
                .mapToInt(Integer::intValue) // Convert back to int stream
                .toArray();

        int[] squareSides = new int[4];
        return canFormSquare(sticks, 0, squareSides, targetSideLength);
    }

    private boolean canFormSquare(int[] sticks, int currentIndex, int[] squareSides, int targetSideLength) {
        if (currentIndex == sticks.length) {
            // Check if all four sides are equal to the target side length
            return squareSides[0] == targetSideLength && squareSides[1] == targetSideLength &&
                    squareSides[2] == targetSideLength && squareSides[3] == targetSideLength;
        }

        for (int side = 0; side < 4; side++) {
            // Skip adding the stick to this side if it exceeds the target length
            if (squareSides[side] + sticks[currentIndex] > targetSideLength) continue;

            squareSides[side] += sticks[currentIndex];
            if (canFormSquare(sticks, currentIndex + 1, squareSides, targetSideLength)) return true;
            squareSides[side] -= sticks[currentIndex]; // Backtrack

            // Optimization: If the current side is empty, skip further attempts
            if (squareSides[side] == 0) break;
        }
        return false;
    }

    public static void main(String[] args) {
        MatchsticksToSquare solution = new MatchsticksToSquare();

        int[] sticks1 = {1, 1, 2, 2, 2};
        System.out.println("Input: " + Arrays.toString(sticks1));
        System.out.println("Output: " + solution.makesquare(sticks1)); // true

        int[] sticks2 = {3, 3, 3, 3, 4};
        System.out.println("Input: " + Arrays.toString(sticks2));
        System.out.println("Output: " + solution.makesquare(sticks2)); // false
    }
}
