import java.util.*;

public class CStepanAndPermutation {
    static int gcd(int a, int b){
        if(b == 0) return a;

        return gcd(b, a%b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }

            boolean possible = true;
            int d = gcd(x, y);
            for(int i=0; i<n; i++){
                if(arr[i]%d  != (i+1)%d){possible = false; break;} 
            }

            if(possible){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}