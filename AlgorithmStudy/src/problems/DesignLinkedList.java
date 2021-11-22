package problems;

public class DesignLinkedList {
    public static void main(String[] args) throws Exception {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);
        myLinkedList.get(1);
        myLinkedList.deleteAtIndex(1);
        myLinkedList.get(1);
    }
}

class MyLinkedList {
    Node head;

    class Node {
        Integer val;
        Node next;

        public Node(Integer val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public MyLinkedList() {
        this.head = new Node(null, null);
    }

    private Node getNode(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
            if (node == null) {
                return null;
            }
        }

        return node;
    }

    public int get(int index) {
        Node node = getNode(index);
        return node == null ? -1 : node.val;
    }

    public void addAtHead(int val) {
        head.next = new Node(val, head.next);
    }

    public void addAtTail(int val) {
        Node node = head;
        while(node.next != null) {
            node = node.next;
        }
        node.next = new Node(val, null);
    }

    public void addAtIndex(int index, int val) {
        Node node = getNode(index);
        if (node != null) {
            node.next = new Node(val, node.next);
        }
    }

    public void deleteAtIndex(int index) {
        Node node = getNode(index);
        if (node != null && node.next != null) {
            node.next = node.next.next;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */