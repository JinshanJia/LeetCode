/*
* Name: Jinshan Jia
* 11/10/2013
* Email: jiajinshan2009@gmail.com
*/
/*
 * Swap Nodes in Pairs 
 *  Given a linked list, swap every two adjacent nodes and return its head.
 *  For example,
 *      Given 1->2->3->4, you should return the list as 2->1->4->3.
 *      
 *  Your algorithm should use only constant space. 
 *  You may not modify the values in the list, only nodes itself can be changed.
 */
public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = head.next;
        ListNode tempNode = null;
        while (swapTwoNodes(head, tempNode)) {
            tempNode = head;
            head = head.next;
        }
        return result;
    }
    
    public boolean swapTwoNodes(ListNode first, ListNode beforeFirst) {
        if (first == null || first.next == null) {
            return false;
        }
        if (beforeFirst != null) {
            beforeFirst.next = first.next;
        }
        ListNode tempNode = first.next.next;
        first.next.next = first;
        first.next = tempNode;
        return true;
    }
}
