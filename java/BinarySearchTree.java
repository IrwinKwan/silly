public class BinarySearchTree {

    class Node {
        Object item;
        Node parent;
        Node left;
        Node right;

        public Node(Object item) {
            this.item = item;
            this.parent = null;
            this.left = null;
            this.right = null;
        }

        public Object get() {
            return this.item;
        }

        public Node getParent() {
            return this.parent;
        }

        public Node getLeft() {
            return this.left;
        }

        public Node getRight() {
            return this.right;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    Node root;

    public BinarySearchTree(Object item) {
        this.root = new Node(item);
    }

    BinarySearchTree search(Object item) {
        if () {
        }

    }


    public static void main(String[] args) {
    }
}
