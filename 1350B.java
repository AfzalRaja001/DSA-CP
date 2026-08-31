import java.util.*;

public class 1350B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] s = new int[n + 1];
            int[] dp = new int[n + 1];
            
            // Read input and initialize the DP array
            for (int i = 1; i <= n; i++) {
                s[i] = sc.nextInt();
                dp[i] = 1; // Base case: every single model is a valid arrangement of length 1
            }
            
            int maxBeautifulArrangement = 1;
            
            // DP Transitions: Iterate through each index
            for (int i = 1; i <= n; i++) {
                // Only check valid multiples of i
                for (int j = i * 2; j <= n; j += i) {
                    // Strictly increasing condition
                    if (s[j] > s[i]) {
                        dp[j] = Math.max(dp[j], dp[i] + 1);
                    }
                }
                // Keep track of the maximum sequence length found overall
                maxBeautifulArrangement = Math.max(maxBeautifulArrangement, dp[i]);
            }
            
            System.out.println(maxBeautifulArrangement);
        }
        
        sc.close();
    }
}