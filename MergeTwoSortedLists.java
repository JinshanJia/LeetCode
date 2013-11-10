/*
* Name: Jinshan Jia
* 11/10/2013
* Email: jiajinshan2009@gmail.com
*/
/*
 * Merge Two Sorted Lists
 *  Merge two sorted linked lists and return it as a new list. 
 *  The new list should be made by splicing together the nodes of 
 *  the first two lists.
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ListNode tempNode1 = l1;
        ListNode tempNode2 = l2;
        ListNode headListNode = null;
        ListNode currentNode = headListNode;
        if (tempNode1 != null && tempNode2 != null) {
            if (tempNode1.val < tempNode2.val) {
                headListNode = tempNode1;
                tempNode1 = tempNode1.next;
            } else {
                headListNode = tempNode2;
                tempNode2 = tempNode2.next;
            }
            currentNode = headListNode;
        } else {
            return (tempNode1 == null? tempNode2 : tempNode1);
        }
        while (tempNode1 != null && tempNode2 != null) {
            if (tempNode1.val < tempNode2.val) {
                currentNode.next = tempNode1;
                tempNode1 = tempNode1.next;
            } else {
                currentNode.next = tempNode2;
                tempNode2 = tempNode2.next;
            }
            currentNode = currentNode.next;
        }
        currentNode.next = (tempNode1 == null? tempNode2 : tempNode1);
        return headListNode;
    }
}
