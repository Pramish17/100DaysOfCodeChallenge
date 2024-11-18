public class DeleteNodeInALinkedList {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        // Copy the value of the next node to the current node
        node.val = node.next.val;
        // Skip the next node
        node.next = node.next.next;
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
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
        DeleteNodeInALinkedList solution = new DeleteNodeInALinkedList();

        // Create a linked list
        ListNode head = createList(new int[]{4, 5, 1, 9});
        System.out.print("Original List: ");
        printList(head);

        // Assuming we want to delete the node with value 5
        ListNode nodeToDelete = head.next; // The node with value 5
        solution.deleteNode(nodeToDelete);

        System.out.print("List After Deleting Node 5: ");
        printList(head); // Expected Output: 4 -> 1 -> 9
    }
}
