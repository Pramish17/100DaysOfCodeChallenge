import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        KthLargestElementInAnArray solution = new KthLargestElementInAnArray();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int result = solution.findKthLargest(nums, k);
        System.out.println("The " + k + "th largest element is: " + result);
    }
}
