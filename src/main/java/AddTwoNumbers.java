public class AddTwoNumbers {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode tempNode = result;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            sum = sum % 10;

            tempNode.next = new ListNode(sum);
            tempNode = tempNode.next;
        }

        if (carry == 1) { // if the last element has carry
            tempNode.next = new ListNode(1);
        }

        return result.next; // Skip the dummy node
    }

    // Helper method to print the linked list
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
        System.out.println();
    }

    // Helper method to create a linked list from an array
    public static ListNode createList(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int num : nums) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummy.next; // Skip the dummy node
    }

    public static void main(String[] args) {
        AddTwoNumbers solution = new AddTwoNumbers();

        // Create two linked lists
        ListNode l1 = createList(new int[]{2, 4, 3}); // Represents 342
        ListNode l2 = createList(new int[]{5, 6, 4}); // Represents 465

        // Add the two numbers
        ListNode result = solution.addTwoNumbers(l1, l2);

        // Print the result
        printList(result); // Expected Output: 7 -> 0 -> 8 (Represents 807)
    }
}
