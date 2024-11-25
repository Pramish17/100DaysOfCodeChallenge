import java.util.PriorityQueue;
import java.util.Collections;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        // Create a max-heap (priority queue with reverse order)
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        // Add all stones to the priority queue
        for (int stone : stones) {
            queue.add(stone);
        }

        // Process the stones until only one or none remains
        while (queue.size() > 1) {
            int a = queue.poll(); // Heaviest stone
            int b = queue.poll(); // Second heaviest stone

            if (a > b) {
                queue.offer(a - b); // Add the remaining weight if stones are not equal
            }
        }

        // Return the last remaining stone or 0 if no stones are left
        return queue.isEmpty() ? 0 : queue.poll();
    }

    // Main method for testing
    public static void main(String[] args) {
        LastStoneWeight solution = new LastStoneWeight();
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println("Last stone weight: " + solution.lastStoneWeight(stones)); // Output: 1
    }
}
