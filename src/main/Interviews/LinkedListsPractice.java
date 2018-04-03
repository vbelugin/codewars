package Interviews;

public class LinkedListsPractice {
    /**
     *  Definition for singly-linked list:
     *  class ListNode<T> {
     *    ListNode(T x) {
     *      value = x;
     *    }
     *    T value;
     *    ListNode<T> next;
     *  }
     *
     */

    ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
        ListNode<Integer> node = l;
        ListNode<Integer> prev = null;
        while(node != null) {
            if(node.value == k) {
                if(prev != null) {
                    prev.next = node.next;
                } else {
                    l = node.next;
                }
            } else {
                prev = node;
            }
            node = node.next;
        }

        return l;
    }
}
