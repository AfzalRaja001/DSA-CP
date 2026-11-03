import java.util.*;

public class 15_10_01 {
    int MOD = (int)1e9+7;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();

        int coins[] = new int[n];
        for(int i=0; i<n; i++){
            coins[i] = sc.nextInt();
        }

        int[] dp = new int[x+1];
        dp[0] = 1;

        for(int c : coins){
            for(int w = coins[i]; w <=n; w++){
                dp[w] = (dp[w] + dp[w - c])%MOD;
            }
        }

        System.out.println(dp[n]);
    }
}