public class SwapNodeInPairs {
    public static class ListNode {
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

    public ListNode swapPairs(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode result = temp;

        while (temp.next != null && temp.next.next != null) {
            ListNode curr = temp.next;
            ListNode nex = temp.next.next;
            temp.next = nex;
            curr.next = nex.next;
            nex.next = curr;
            temp = curr;
        }
        return result.next;  /*Time Complexity O(n)*/
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Test the code
    public static void main(String[] args) {
        SwapNodeInPairs swapper = new SwapNodeInPairs();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

        System.out.println("Original List:");
        printList(head);

        ListNode swappedHead = swapper.swapPairs(head);

        System.out.println("Swapped List:");
        printList(swappedHead);
    }
}
