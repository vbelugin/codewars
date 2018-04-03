package Interviews;

import java.awt.*;

public class ListNode<T> extends List {
    public ListNode(T x) {
        value = x;
    }
    T value;
    ListNode<T> next;
}

