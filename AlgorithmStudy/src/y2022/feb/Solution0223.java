package y2022.feb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution0223 {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Integer, Node> nodeMap = new HashMap<>();

        cloneNode(node, nodeMap);

        return nodeMap.get(node.val);
    }

    private Node cloneNode(Node node, Map<Integer, Node> nodeMap) {
        if (nodeMap.containsKey(node.val)) {
            return nodeMap.get(node.val);
        }
        Node cNode = new Node(node.val);
        nodeMap.put(node.val, cNode);

        for (Node neighbor : node.neighbors) {
            cNode.neighbors.add(cloneNode(neighbor, nodeMap));
        }

        return cNode;
    }

}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}