import java.util.*;

public class TimeBasedKeyValueStore {

    private Map<String, List<Pair<Integer, String>>> map = new HashMap<>();

    public TimeBasedKeyValueStore() {
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        List<Pair<Integer, String>> list = map.get(key);
        list.add(new Pair<>(timestamp, value));
    }

    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> values = map.getOrDefault(key, new ArrayList<>());
        int left = 0, right = values.size() - 1;
        String result = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (values.get(mid).getKey() <= timestamp) {
                result = values.get(mid).getValue();
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        TimeBasedKeyValueStore timeMap = new TimeBasedKeyValueStore();

        // Example usage
        timeMap.set("foo", "bar", 1);
        System.out.println(timeMap.get("foo", 1)); // Output: bar
        System.out.println(timeMap.get("foo", 3)); // Output: bar
        timeMap.set("foo", "bar2", 4);
        System.out.println(timeMap.get("foo", 4)); // Output: bar2
        System.out.println(timeMap.get("foo", 5)); // Output: bar2
    }
}
