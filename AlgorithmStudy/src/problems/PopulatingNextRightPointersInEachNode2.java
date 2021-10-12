package problems;

public class PopulatingNextRightPointersInEachNode2 {

    public Node connect(Node root) {
        sibling(root);
        siblingChild(root);

        return root;
    }
    private void sibling(Node node) {
        if (node == null) {
            return ;
        }

        // 기본적으로 자식끼리 연결해줌
        if (node.left != null) {
            node.left.next = node.right;
        }

        sibling(node.left);
        sibling(node.right);
    }

    private void siblingChild(Node node) {
        if (node == null) {
            return ;
        }

        // 자식을 자신의 형재의 자식과 연결해줌
        Node child = findChildEdge(node, false); // 오른쪽 위주로 찾기
        if (child != null) {
            Node siblingChild = null;
            Node sibling = node.next;
            while (sibling != null) {
                siblingChild = findChildEdge(sibling, true); // 왼쪽 위주로 찾기
                if (siblingChild != null) break;
                sibling = sibling.next;
            }
            child.next = siblingChild;
        }

        // 오른쪽 부터 탐색시키기
        siblingChild(node.right);
        siblingChild(node.left);
    }

    private Node findChildEdge(Node node, boolean leftFirst) {
        if (node != null) {
            if (leftFirst) {
                if (node.left != null) return node.left;
                if (node.right != null) return node.right;
            } else {
                if (node.right != null) return node.right;
                if (node.left != null) return node.left;
            }
        }

        return null;
    }

}
