import java.util.Arrays;
import java.util.Stack;

public class CarFleet {
    public static void main(String[] args) {
    int target = 10;
    int[] position = {1,4};
    int[] speed = {3,2};
        System.out.println(carFleet(target,position,speed));
    }
    public static int carFleet (int target, int[] position, int[] speed){
        int n = position.length;
        if (n == 0) return 0;

        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }

        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            double time = cars[i][1];
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
        }

        return stack.size(); /* Time Complexity O(nlogn) */
    }
}
