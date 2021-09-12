package model;

import java.util.LinkedList;
import java.util.Queue;

public class ListCodec {

    public ListNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String[] nodes = data.split(",");

        ListNode first = new ListNode(Integer.parseInt(nodes[0]));
        ListNode list = first;
        for ( int i = 1; i < nodes.length; i++) {
            int val = Integer.parseInt(nodes[i]);
            list.next = new ListNode(val);
            list = list.next;
        }

        return first;
    }

    public static void main(String[] args) {
        ListCodec codec = new ListCodec();
        System.out.println(codec.deserialize("1,2,3,4,5,6"));
    }
}
