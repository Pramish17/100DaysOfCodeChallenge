import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {

    // Encodes a list of strings to a single string
    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s.length()).append('#').append(s);
        }
        return res.toString();
    }

    // Decodes a single string to a list of strings
    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') { // Find the position of the delimiter '#'
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j)); // Get the length of the next string
            i = j + 1; // Move to the start of the actual string
            j = i + length; // Find the end of the string using the extracted length
            res.add(str.substring(i, j)); // Extract and add the string to the result
            i = j; // Move to the next encoded segment
        }
        return res;
    }

    // Main method for testing the encode and decode functions
    public static void main(String[] args) {
        EncodeAndDecodeStrings solution = new EncodeAndDecodeStrings();

        // Example list of strings to encode
        List<String> strs = List.of("hello", "world", "java", "encode#decode");
        System.out.println("Original Strings: " + strs);

        // Encode the list of strings
        String encoded = solution.encode(strs);
        System.out.println("Encoded String: " + encoded);

        // Decode the encoded string back to a list of strings
        List<String> decoded = solution.decode(encoded);
        System.out.println("Decoded Strings: " + decoded);
    }
}
