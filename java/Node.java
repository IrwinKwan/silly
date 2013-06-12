import java.util.Stack;
import java.util.LinkedList;

import java.util.Arrays;

public class Node {

    public Node parent;
    public Node left;
    public Node right;
    private String item;

    public Node(String item, Node parent) {
        this.item = item;
        this.parent = parent;
        this.left = null;
        this.right = null;
    }

    public Node(String item) {
        this.item = item;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    public String getItem() {
        return this.item;
    }

    public void prefix(Node n) {
        if (n == null) {
            return;
        }

        System.out.print(n.getItem() + " ");
        prefix(n.left);
        prefix(n.right);
    }

    public void postfix(Node n) {
        if (n == null) {
            return;
        }

        postfix(n.left);
        postfix(n.right);
        System.out.print(n.getItem() + " " );
    }

    public void infix(Node n) {
        if (n == null) {
            return;
        }
        infix(n.left);
        System.out.print(n.getItem() + " " );
        infix(n.right);
    }

    public static boolean isOp(String input) {
        switch (input) {
            case "+":
            case "-":
            case "*":
            case "/":
                return true;
            default:
                return false;
        }
    }

    public static boolean isInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isOpen(String input) {
        return input.equals("(");
    }

    public static boolean isClosed(String input) {
        return input.equals(")");
    }

    /**
     * Convert a postfix expression to a tree
     */
    public static Node postorderToTree(String expr) {
        String[] tokens = expr.split("\\s");
        Stack<Node> buffer = new Stack<>();
        String dataType;
        Node right;
        Node left;

        for (int i = 0; i < tokens.length; i++) {
            if (Node.isInt(tokens[i])) {
                Node tmp = new Node(tokens[i]);
                buffer.push(tmp);
            } else if (Node.isOp(tokens[i])) {
                right = buffer.pop();
                left = buffer.pop();

                if (buffer.empty()) {
                    // Error
                }

                Node op = new Node(tokens[i]);
                op.left = left;
                op.right = right;

                buffer.push(op);
            } else {

            }
        }

        // At the end we should only have the root
        return buffer.pop();
    }

    /**
     * This is Dijkstra's Shunting Yard algorithm
     */
    public static Node inOrderToTree(String expr) throws Exception {
        // Operators and parentheses go on the stack
        Stack<Node> operators = new Stack<>();

        // Numbers and trees go on the output queue
        Stack<Node> output = new Stack<>();

        Node op = null;
        // (55 + 45) * (33 + 34) + 5
        // Tree form:
        // (((55 + 45) * (33 + 34)) + 5)
        // Example 2: without operator precedence
        // 1 + 4 * 5 + 6

        String[] tokens = expr.split("\\s");

        // For each token, which can be a (), an op, or an integer:
        for (int i = 0; i < tokens.length; i++) {
            String t = tokens[i];

            if (Node.isInt(t)) {
                System.out.println(t);
                output.push(new Node(t));

            } else if (Node.isOpen(t)) {
                operators.push(new Node(t));

            } else if (Node.isOp(t)) {
                if (!operators.empty()) {
                    Node tmp = operators.peek();

                    while (Node.isOp(tmp.item)) {

                        System.out.println(tmp.item);
                        op = operators.pop();
                        // Here we can check if op is actually an op
                        if (!Node.isOp(op.item)) {
                            throw new Exception("Expected operator");
                        }
                        op.right = output.pop();
                        op.left = output.pop();
                        output.push(op);

                        tmp = operators.peek();
                    }
                }
                operators.add(new Node(t));

            } else if (Node.isClosed(t)) {
                op = operators.pop();
                while (!Node.isOpen(op.item)) {
                    op.right = output.pop();
                    op.left = output.pop();
                    output.push(op);
                    try {
                        op = operators.pop();
                    } catch (Exception e) {
                        throw new Exception("Mismatched parentheses");
                    }
                }
            }
        }

        while (!operators.empty()) {
            op = operators.pop();
            // Here we can check if op is actually an op
            if (!Node.isOp(op.item)) {
                throw new Exception("Mismatched parentheses");
            }
            op.right = output.pop();
            op.left = output.pop();
            output.push(op);
        }

        return output.pop();
    }

    public static Node preOrderToTree(String expr) {
        // 0 0 0 0 x x x x 0 x x

        Stack<Node> operators = new Stack<>();
        Node op;
        Node integer = null;

        String[] tokens = expr.split("\\s");

        for (int i = 0; i < tokens.length; i++) {
            if (Node.isOp(tokens[i])) {
                // Grab operator
                operators.push(new Node(tokens[i]));
            } else if (Node.isInt(tokens[i])) {

                if (integer == null) {
                    integer = new Node(tokens[i]);
                } else {
                    // We have two numbers available, so get the operator
                    op = operators.pop();
                    op.left = integer;
                    op.right = new Node(tokens[i]);

                    integer = op;
                }
            }
        }

        return integer;
    }

    public static void main(String[] args) {
        assert( true == Node.isOp("*"));
        assert( true == Node.isOp("/"));
        assert( false == Node.isOp("3"));
        assert( false == Node.isInt("/"));
        assert( true == Node.isInt("57"));
        assert( false == Node.isInt("329"));

        Node root;
        // Node root = Node.postOrderToTree("14 55 + 21 33 * -");
        // root = Node.preOrderToTree("+ + + 33 22 55 14 ");
        // Tree it up: (+ (+ (+ 33 22) 55) 14)
        root = Node.preOrderToTree("+ + 11 22 + 55 44");
        // Tree it up: (+ (+ 33 22) (+ 55 14))

        String expr = "( 1 + 2 ) * ( 3 + 4 )";
        try {
            root = Node.inOrderToTree(expr);
        } catch (Exception e) {
            root = null;
            e.printStackTrace(System.err);
            System.exit(1);
        }

        System.out.println(expr);

        root.prefix(root);
        System.out.println();

        root.infix(root);
        System.out.println();

        root.postfix(root);
        System.out.println();

    }
}

