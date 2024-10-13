import java.util.*;

public class Main{
    public static void main(String[] args){
        System.out.println(11/10);

        System.out.println("#1");
        System.out.println(isStrangePair("ratio", "orator"));
        System.out.println(isStrangePair("sparkling", "groups"));
        System.out.println(isStrangePair("bush", "hubris"));
        System.out.println(isStrangePair("", ""));

        System.out.println("\n#2");
        HashMap<String, Integer> products = new HashMap<>();
        products.put("Laptop", 124200);
        products.put("Phone", 51450);
        products.put("Headphones", 13800);
        System.out.println(sale(products, 25));

        System.out.println("\n#3");
        System.out.println(sucsessShoot(0,0,5,2,2));
        System.out.println(sucsessShoot(-2,-3,4,5,-6));

        System.out.println("\n#4");
        System.out.println(parityAnalysis(243));
        System.out.println(parityAnalysis(12));
        System.out.println(parityAnalysis(3));

        System.out.println("\n#5");
        System.out.println(rps("rock", "paper"));
        System.out.println(rps("paper", "rock"));
        System.out.println(rps("paper", "scissors"));
        System.out.println(rps("scissors", "scissors"));
        System.out.println(rps("scissors", "paper"));

        System.out.println("\n#6");
        System.out.println(bugger(39));
        System.out.println(bugger(999));
        System.out.println(bugger(4));

        System.out.println("\n#7");
        Object[][] input7 = {
                {"Скакалка", 550, 8},
                {"Шлем", 3750, 4},
                {"Мяч", 2900, 10}
        };
        System.out.println(mostExpensive(input7));


        System.out.println("\n#8");
        System.out.println(longestUnique("abcba"));
        System.out.println(longestUnique("bbb"));

        System.out.println("\n#9");
        System.out.println(isPrefix("automation", "auto-"));
        System.out.println(isPrefix("retrospect", "sub-"));
        System.out.println(isSuffix("arachnophobia", "-phobia"));
        System.out.println(isSuffix("vocation", "-logy"));

        System.out.println("\n#10");
        System.out.println(doesBrickFit(1, 1, 1, 1, 1));
        System.out.println(doesBrickFit(1, 2, 1, 1, 1));
        System.out.println(doesBrickFit(1, 2, 2, 1, 1));
    }


    //#1

    public static boolean isStrangePair(String s1, String s2){
        if(s1.length() == 0 && s2.length()==0)
            return true;
        else if((s1.charAt(0) == s2.charAt(s2.length()-1)) &&  (s1.charAt(s1.length()-1) == s2.charAt(0)))
            return true;
        else
            return false;
    }

    //#2

    public static HashMap<String, Integer> sale(HashMap<String, Integer> products, double discount){
        double discountCof = 1 - discount / 100;
        for(Map.Entry<String, Integer> item : products.entrySet()){
            item.setValue((int) Math.ceil(item.getValue() * discountCof));
            if(item.getValue() < 1)
                item.setValue(1);
        }
        return products;
    }

    //#3
    public static boolean sucsessShoot(int x, int y, int r, int n, int m){
        return (((n-x)*(n-x) + (m-y)*(m-y)) <= r*r);
    }


    //#4
    public static boolean parityAnalysis(int a){
        int sum=0, aa=a;
        while(a>0){
            sum+=a%10;
            a=a/10;
        }
        if(aa%2==0 && sum%2==0)
            return true;
        if(aa%2!=0 && sum%2!=0)
            return true;
        else return false;
    }

    //#5
    public static String rps(String s1, String s2){
        if(s1.equals(s2))
            return "Tie";
        switch (s1){
            case ("rock"):
                return((s2.equals("paper")) ? "Player 2 wins" : "Player 1 wins");
            case ("paper"):
                return ((s2.equals("scissors")) ? "Player 2 wins" : "Player 1 wins");
            case ("scissors"):
                return ((s2.equals("rock")) ? "Player 2 wins" : "Player 1 wins");
            default:
                return "something went wrong";
        }
    }

    //#6

    public static int bugger(int a){
        int count = 0;
        while(a/10!=0){
            int newA=1;
            while(a>0){
                newA = newA * (a%10);
                a=a/10;
            }
            a=newA;
            count++;
        }
        return count;
    }

    //#7
    public static String mostExpensive(Object[][] Items){
        int maxCost = 0;
        String mostExpItem = "";
        for(Object[] in : Items){
            String itemName = (String) in[0];
            int itemPrice = (int) in[1];
            int itemQuantity = (int) in[2];

            int cost = itemQuantity*itemPrice;

            if(cost > maxCost){
                maxCost=cost;
                mostExpItem = itemName;
            }
        }
        return "Наиб. общ. стоимость у предмета " + mostExpItem + " - " + maxCost;
    }

    //#8
    public static String longestUnique(String s){
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int maxLength = 0, start = 0, end = 0;
        String maxSubString = "";
        String currentSubString = "";

        for (end = 0; end < n; end++) {
            while (set.contains(s.charAt(end))) {
                set.remove(s.charAt(start));
                start++;
            }

            set.add(s.charAt(end));
            if (end - start + 1 > maxLength) {
                maxLength = end - start + 1;
                maxSubString = s.substring(start, end + 1);
            }
        }
        return maxSubString;
    }


    //#9
    public static boolean isPrefix(String s, String pr){
        pr = pr.replace("-", "");
        String pr2 = s.substring(0, pr.length());
        return pr.equals(pr2);
    }

    public static boolean isSuffix(String s, String sf){
        sf = sf.replace("-", "");
        String sf2 = s.substring(s.length()-sf.length());
        return sf.equals(sf2);
    }

    //#10
    public static boolean doesBrickFit(int a, int  b, int  c, int  w, int  h){
        int[] brick = {a, b, c};
        int[] hole = {w, h};
        Arrays.sort(brick);
        Arrays.sort(hole);
        return (brick[0] <= hole[0]) && (brick[1] <= hole[1]);
    }
}