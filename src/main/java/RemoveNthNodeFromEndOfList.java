public class RemoveNthNodeFromEndOfList {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node pointing to the head
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // Initialize slowPointer and fastPointer to dummyHead
        ListNode slowPointer = dummyHead;
        ListNode fastPointer = dummyHead;

        // Move fastPointer ahead by n+1 steps
        for (int i = 1; i <= n + 1; i++) {
            fastPointer = fastPointer.next;
        }

        // Move both pointers until fastPointer reaches the end
        while (fastPointer != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }

        // Remove the nth node from the end
        slowPointer.next = slowPointer.next.next;

        // Return the head of the modified list
        return dummyHead.next;  /*Time complexity O(n)*/
    }

    public static void main(String[] args) {
        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Remove the 2nd node from the end
        RemoveNthNodeFromEndOfList solution = new RemoveNthNodeFromEndOfList();
        ListNode modifiedHead = solution.removeNthFromEnd(head, 2);

        // Print the modified linked list
        printList(modifiedHead);
    }

    // Helper function to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
