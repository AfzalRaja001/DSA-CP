import java.util.*;

public class DMakeItRound {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();

            int c2 = 0;
            int c5 =0;

            int temp = n;
            while(temp%2 == 0){
                c2++;
                temp /=2;
            }

            temp = n;
            while(temp%5 == 0){
                c5++;
                temp /= 5;
            }

            for(int digit = 18; digit >=0; digit--){
                int extra2 = (digit-c2);
                int extra5 = (digit-c5);

                int 
            }
        }
    }
}