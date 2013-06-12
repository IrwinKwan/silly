import java.util.Arrays;
import java.util.Stack;
/**
 * Given a string of questions, check if the parentheses are balanced.
 */
public class Balanced {

    Stack<Character> parentheses;

    public Balanced() {
        parentheses = new Stack<>();
    }

    public boolean isBalanced(String expr) {
        for (int i = 0; i < expr.length(); i++) {
            if (isOpenParentheses(expr.charAt(i))) {
                parentheses.push(expr.charAt(i));
            } else if (isClosedParentheses(expr.charAt(i))) {

                if (!parentheses.empty()) {
                    char closed = expr.charAt(i);
                    char open = parentheses.pop();

                    System.out.println(open + " " + closed);
                    if (matchParentheses(open, closed)) {
                        // Yay!
                    } else {
                        // Oh no!
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        System.out.println(Arrays.toString(parentheses.toArray()));

        if (parentheses.empty()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean matchParentheses(char open, char closed) {
        if ((open == '{' && closed == '}')
                || (open == '(' && closed == ')')
                || (open == '[' && closed == ']')) {
            return true;
        } else {
            return false;
        }

    }

    private boolean isOpenParentheses(char b) {
        return (b == '{'
                || b == '('
                || b== '[');
    }

    private boolean isClosedParentheses(char b) {
        return (b == '}'
                || b == ')'
                || b == ']');
    }


    public static void main(String[] args) {
        Balanced b = new Balanced();
        boolean isBalanced = b.isBalanced(args[0]);
        System.out.println("Expression " + args[0] + " result is " + isBalanced);
    }
}

