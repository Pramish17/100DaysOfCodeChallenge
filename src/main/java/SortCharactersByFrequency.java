import java.util.*;

public class SortCharactersByFrequency {

    static class Element {
        char c;
        int frequency;

        public Element(char c, int frequency) {
            this.c = c;
            this.frequency = frequency;
        }
    }

    public String frequencySort(String s) {
        // Step 1: Count frequency of each character
        HashMap<Character, Integer> fMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            fMap.put(c, fMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Create a PriorityQueue with a custom comparator to sort by frequency in descending order
        PriorityQueue<Element> pq = new PriorityQueue<>(new Comparator<Element>() {
            @Override
            public int compare(Element e1, Element e2) {
                return e2.frequency - e1.frequency; // Sort by frequency in descending order
            }
        });

        // Step 3: Add elements to the priority queue
        for (Map.Entry<Character, Integer> entry : fMap.entrySet()) {
            pq.offer(new Element(entry.getKey(), entry.getValue()));
        }

        // Step 4: Build the result string based on the sorted frequencies
        StringBuilder str = new StringBuilder();
        while (!pq.isEmpty()) {
            Element element = pq.poll();
            // Append the character 'element.frequency' times
            for (int i = 0; i < element.frequency; i++) {
                str.append(element.c);
            }
        }

        return str.toString();
    }

    public static void main(String[] args) {
        SortCharactersByFrequency solution = new SortCharactersByFrequency();
        String result = solution.frequencySort("tree");
        System.out.println(result);  // Example: output could be "eetr"
    }
}
