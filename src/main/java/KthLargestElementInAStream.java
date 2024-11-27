import java.util.PriorityQueue;

public class KthLargestElementInAStream {

    private final PriorityQueue<Integer> pq; // Min-heap to store the k largest elements
    private final int k; // The kth largest element

    // Constructor
    public KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>(k); // Initialize the priority queue with a capacity of k
        for (int num : nums) {
            add(num); // Add each number to the priority queue
        }
    }

    // Add a value to the stream and return the kth largest element
    public int add(int val) {
        // If the heap has less than k elements, or the new value is greater than the smallest in the heap
        if (pq.size() < k || val > pq.peek()) {
            pq.offer(val); // Add the new value to the heap
            if (pq.size() > k) {
                pq.poll(); // Remove the smallest element if the heap exceeds k elements
            }
        }
        return pq.peek(); // The smallest element in the heap is the kth largest in the stream
    }

    // Main method for testing
    public static void main(String[] args) {
        int k = 3;
        int[] nums = {4, 5, 8, 2};
        KthLargestElementInAStream kthLargest = new KthLargestElementInAStream(k, nums);
        System.out.println(kthLargest.add(3)); // Output: 4
        System.out.println(kthLargest.add(5)); // Output: 5
        System.out.println(kthLargest.add(10)); // Output: 5
        System.out.println(kthLargest.add(9)); // Output: 8
        System.out.println(kthLargest.add(4)); // Output: 8
    }
}
