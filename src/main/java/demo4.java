import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class demo4 {
    public static void main(String[] args) {
        int[] arr = new int[]{123,2,34,1,45};
        Node node = getList(arr);
        preOrder(node);
    }

    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            throw new RuntimeException("da");
        }
    }

    public static Node getList(int[] arr) {
        List<Node> list = new ArrayList();
        for (int as : arr) {
            list.add(new Node(as));
        }

        while (list.size() > 1) {
            Collections.sort(list);
            Node left = list.get(0);
            Node right = list.get(1);
            Node paren = new Node(left.value + right.value);
            paren.left = left;
            paren.right = right;
            list.remove(left);
            list.remove(right);
            list.add(paren);
        }
        return list.get(0);
    }
}

class Node implements Comparable<Node> {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}
