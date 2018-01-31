package ru.job4j.list;


/**
 * Finds the cycle in list using Floyd's cycle-finding algorithm
 *
 * @author AKats
 */
public class HasCycle {


    class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }


    boolean hasCycle(Node first) {
        boolean res = false;
        Node slow, fast;
        slow = first;
        fast = first;
        while (true) {
            slow = slow.next;
            if (fast.next == null) {
                break;
            }
            fast = fast.next.next;
            if (slow == null || fast == null) {
                break;
            }
            if (slow == fast) {
                res = true;
                break;
            }
        }
        return res;
    }
}
