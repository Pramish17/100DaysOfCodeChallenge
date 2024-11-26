import java.util.*;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        // Step 1: Count frequency of each task
        Map<Character, Integer> taskCountMap = new HashMap<>();
        for (char task : tasks) {
            taskCountMap.put(task, taskCountMap.getOrDefault(task, 0) + 1);
        }

        // Step 2: Use a priority queue (max-heap) to store the tasks by frequency
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(taskCountMap.values());

        // Step 3: Simulate the CPU cycles
        int cycles = 0;

        // Step 4: While there are tasks to process
        while (!maxHeap.isEmpty()) {
            int timeSlot = 0;
            List<Integer> temp = new ArrayList<>();

            // Process up to n + 1 tasks in each cycle
            while (timeSlot <= n) {
                if (!maxHeap.isEmpty()) {
                    int count = maxHeap.poll();
                    if (count > 1) {
                        temp.add(count - 1); // Decrease the frequency of the task
                    }
                }
                cycles++; // Increase the time slot (CPU cycle)

                if (maxHeap.isEmpty() && temp.isEmpty()) {
                    break; // If no tasks are left to process, break the loop
                }
                timeSlot++;
            }

            // Add the remaining tasks back to the max heap
            maxHeap.addAll(temp);
        }

        return cycles;
    }

    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        char[] tasks2 = {'A', 'A', 'A', 'B', 'C'};
        int n2 = 3;
        System.out.println("Minimum CPU cycles: " + scheduler.leastInterval(tasks2, n2)); // Output: 9
    }
}
