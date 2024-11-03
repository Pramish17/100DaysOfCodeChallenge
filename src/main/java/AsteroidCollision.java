import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] asteroids = {5, 10, -5};
        System.out.println(asteroidCollision(asteroids));
    }

    private static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < asteroids.length; i++) {
            if (stack.isEmpty() || asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else {
                while (true) {
                    int peek = stack.peek();
                    if (peek < 0) {
                        stack.push(asteroids[i]);
                        break;
                    } else if (peek == -asteroids[i]) {
                        stack.pop();
                        break;
                    } else if (peek > -asteroids[i]) {
                        break;
                    } else {
                        stack.pop();
                        if (stack.isEmpty()) {
                            stack.push(asteroids[i]);
                            break;
                        }
                    }

                }
            }
        }
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result; /* Time Complexity O(n) */
    }
}
