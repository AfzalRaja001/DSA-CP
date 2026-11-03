import java.util.*;

public class AOptimizePseudocode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }

            int ans = 0;
            int curr = 0;

            for(int i=0; i<n; i++){
                if(i==0 || arr[i] > arr[i-1]){
                    curr++;
                }else{
                    curr = 1;
                }
                ans = Math.max(ans, curr);
            }

            System.out.println(ans);
        }    
    }
}