/*
 * Remove Duplicates from Sorted List 

Given a sorted linked list, delete all duplicates 
such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
 */

public class RemoveDuplicatesfromSortedList {
    public static ListNode deleteDuplicates(ListNode head) {
        // Note: The Solution object is instantiated only once and is reused by
        // each test case.
        if (head == null) {
            return null;
        }
        ListNode tempNode = head;
        while (tempNode.next != null) {
            if (tempNode.next.val == tempNode.val) {
                tempNode.next = tempNode.next.next;
            } else {
                tempNode = tempNode.next;
            }
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    static ListNode createList(int[] A) {
        if (A.length == 0) {
            return null;
        }
        ListNode head = new ListNode(A[0]);
        ListNode currentListNode = head;
        for (int i = 1; i < A.length; i++) {
            ListNode tempListNode = new ListNode(A[i]);
            currentListNode.next = tempListNode;
            currentListNode = tempListNode;
        }
        return head;
    }

    ListNode(int x) {
        val = x;
        next = null;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode temp = this;
        while (temp.next != null) {
            sb.append(Integer.toString(temp.val) + '\n');
            temp = temp.next;
        }
        sb.append(Integer.toString(temp.val) + '\n');
        return sb.toString();
    }
}

