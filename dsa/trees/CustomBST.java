package trees;

public class CustomBST {
    private Node root;

    CustomBST() {

    }

    private class Node {
        private int value;
        private int height;
        private Node left;
        private Node right;

        Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }

    public int getHeight(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }
}
