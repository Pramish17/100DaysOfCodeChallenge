// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    // Default constructor
    ListNode() {}

    // Constructor to initialize value
    ListNode(int val) {
        this.val = val;
    }

    // Constructor to initialize value and next node
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Temporary node to build the result list
        ListNode tempNode = new ListNode(0);
        ListNode currentNode = tempNode;

        // Merge the two lists
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                currentNode.next = list1;
                list1 = list1.next;
            } else {
                currentNode.next = list2;
                list2 = list2.next;
            }
            currentNode = currentNode.next;
        }

        // Append the remaining nodes from either list1 or list2
        if (list1 != null) {
            currentNode.next = list1;
        } else {
            currentNode.next = list2;
        }

        // Return the merged list (skipping the dummy head)
        return tempNode.next;   /* Time Complexity O(n+m) */
    }

    public static void main(String[] args) {
        // Example usage
        MergeTwoSortedList result = new MergeTwoSortedList();

        // Create two sorted linked lists
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        // Merge the lists
        ListNode mergedList = result.mergeTwoLists(list1, list2);

        // Print the merged list
        System.out.print("Merged List: ");
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }
}
