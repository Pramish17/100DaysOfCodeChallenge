public class IsPalindrome {
    public static void main(String[] args) {
        String s = "Was it a car or a cat I saw?";
        System.out.println(isPalindrome(s));
    }

    private static boolean isPalindrome(String s) {
        StringBuilder value = new StringBuilder();
        for (char c: s.toCharArray()){
            if (Character.isDigit(c) || Character.isLetter(c)) {
                value.append(c);
            }
        }
        String processedValue = value.toString().toLowerCase();

        int leftPointer = 0;
        int rightPointer = processedValue.length() - 1;

        while (leftPointer <= rightPointer) {
            if (processedValue.charAt(leftPointer) != processedValue.charAt(rightPointer)) {
                return false;
            }
            leftPointer += 1;
            rightPointer -= 1;
        }
        return true;  /* Time Complexity O(n) */
    }
}
