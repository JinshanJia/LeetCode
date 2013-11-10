/*
* Name: Jinshan Jia
* 11/10/2013
* Email: jiajinshan2009@gmail.com
*/
/*
 * Remove Nth Node From End of List
 * 
 * Given a linked list, remove the nth node from the end of list and return its head.
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 *   After removing the second node from the end, 
 *   the linked list becomes 1->2->3->5.
 * 
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 */

public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ListNode currentNode = head;
        ListNode tempNode = head;
        int step = 0;
        while (currentNode != null) {
            currentNode = currentNode.next;
            if(step > n) {
                tempNode = tempNode.next;
            }
            step++;
        }
        if (step <= n) {
            head = head.next;
        } else {
            tempNode.next = tempNode.next.next;
        }
        return head;
    }

//    public class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode(int x) {
//            val = x;
//            next = null;
//        }
//    }
}
