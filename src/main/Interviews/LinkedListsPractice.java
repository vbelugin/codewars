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

    public static ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
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

    /**
     * Note: Try to solve this task in O(n) time using O(1) additional space, where n is the number of elements in l, since this is what you'll be asked to do during an interview.
     *
     * Given a singly linked list of integers, determine whether or not it's a palindrome.
     *
     * Example
     *
     * For l = [0, 1, 0], the output should be
     * isListPalindrome(l) = true;
     * For l = [1, 2, 2, 3], the output should be
     * isListPalindrome(l) = false.
     * Input/Output
     *
     * [execution time limit] 3 seconds (java)
     *
     * [input] linkedlist.integer l
     *
     * A singly linked list of integers.
     *
     * Guaranteed constraints:
     * 0 ≤ list size ≤ 5 · 105,
     * -109 ≤ element value ≤ 109.
     *
     * [output] boolean
     *
     * Return true if l is a palindrome, otherwise return false.
     */

    public static boolean isListPalindrome(ListNode<Integer> l) {

        return true;
    }
}
