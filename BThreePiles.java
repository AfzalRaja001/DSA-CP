import java.util.*;

public class BThreePiles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){
            long a = sc.nextInt();
            long b = sc.nextInt();
            long c = sc.nextInt();

            if(a>=b){
                System.out.println((a+c)-b);
            }else{
                if(Math.abs(a-b) > Math.abs((a+c)-b)){
                    System.out.println(b-a);
                }else{
                    System.out.println(Math.abs((a+c)-b));
                }
            }

        }
    }
}