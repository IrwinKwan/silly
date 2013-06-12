public class StringReverse {

    StringBuilder rev; // StringBuilders are mutable, unlike String in Java.
    public StringReverse(String in) {
        char tmp;
        this.rev = new StringBuilder(in);

        for (int i = 0; i < this.rev.length()/2; i++) {
            tmp = this.rev.charAt(i);
            this.rev.setCharAt(i, this.rev.charAt(this.rev.length() - 1 - i));
            this.rev.setCharAt(this.rev.length() - 1 - i, tmp);
        }
    }

    public String toString() {
        return this.rev.toString();
    }

    public static void main(String[] args) {
        StringReverse sr = new StringReverse(args[0]);
        System.out.println(args[0]);
        System.out.println(sr.toString());
    }
}

