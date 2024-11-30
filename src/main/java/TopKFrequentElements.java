import java.util.*;

public class TopKFrequentElements {
    static class Number implements Comparable<Number> {
        int element;
        int frequency;

        Number(int element, int frequency) {
            this.element = element;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(Number that) {
            // Max-heap: Higher frequency first
            return Integer.compare(that.frequency, this.frequency);
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Number> pq = new PriorityQueue<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequencies
        for (int element : nums) {
            map.put(element, map.getOrDefault(element, 0) + 1);
        }

        // Insert into priority queue
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new Number(entry.getKey(), entry.getValue()));
        }

        // Extract top k elements
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().element;
        }

        return result;
    }

    // Main method for testing
    public static void main(String[] args) {
        TopKFrequentElements solution = new TopKFrequentElements();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = solution.topKFrequent(nums, k);

        // Output the result
        System.out.println(Arrays.toString(result)); // Should print [1, 2]
    }
}
