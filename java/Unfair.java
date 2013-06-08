import java.util.Random;
import java.util.HashMap;

public class Unfair {
    Random random;
    
    public Unfair() {
        this.random = new Random();
    } 

    public String draw() {
        int draw = this.random.nextInt(6); 

        if (draw == 1 || draw == 2) {
            return "H";
        } else {
            return "T";
        }
    }

    public static void main(String[] args) {
        Unfair uf = new Unfair();
        HashMap<String, Integer> al = new HashMap<>();
        al.put("T", 0);
        al.put("H", 0);
        
        for (int i = 0; i < 100000; i++) {

            String key = "";
            while (key.equals("")) {
                String first = uf.draw();
                String second = uf.draw();
                String result = first + second;

                if (result.equals("TH")) {
                    key = "T";
                    break;
                } else if (result.equals("HT")) {
                    key = "H";
                    break;
                }
            }
            System.out.println(key);
            al.put(key, al.get(key) + 1);
        }

        System.out.println("Number of tails: " + al.get("T"));
        System.out.println("Number of heads: " + al.get("H"));
    }
}

