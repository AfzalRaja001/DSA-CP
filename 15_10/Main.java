import java.util.*;

public class Main {
    // Counting Towers
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){
            int n = sc.nextInt();

            int dp[][] = new int[n+1][2];
            dp[1][0] =1;
            dp[1][1] = 1;

            for(int i=1; i<=n; i++){
                dp[i][0] = (4*dp[i-1][0] + dp[i-1][1]);
                dp[i][1] = (dp[i-1][0] + 2*dp[i-1][1]);
            }

            System.out.println(dp[n][0] + dp[n][1]);
        }
    }
}