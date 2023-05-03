package linkedlist;


public class MergeOrderList {
   public static LinkedNode mergeNode(LinkedNode node1, LinkedNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        LinkedNode p1 = node1;
        LinkedNode p2 = node2;

        LinkedNode newHead, p;
        if (p1.getValue() < p2.getValue()) {
            newHead = p1;
        } else {
            newHead = p2;
        }
        p = newHead;
        while (p1 != null && p2 != null) {
            if (p1.getValue() < p2.getValue()) {
                p.setNext(p1);
                p1 = p1.getNext();
            } else {
                p.setNext(p2);
                p2 = p2.getNext();
            }
        }
        if (p1 == null) {
            p.setNext(p2);
        }
        if (p2 == null) {
            p.setNext(p2);
        }

        return newHead;
    }

    public static void main(String[] args) {

    }
}
