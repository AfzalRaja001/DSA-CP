import java.util.*;

public class StoneGameIV {

    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];

        // dp[0] is automatically false (default in Java)

        for (int i = 1; i <= n; i++) {
            for (int k = 1; k * k <= i; k++) {
                // If removing k*k stones leaves the opponent in a losing position
                if (!dp[i - k * k]) {
                    dp[i] = true;
                    break; // Found a winning move, move to the next state
                }
            }
        }

        return dp[n];
    }
    public static void main(String[] args) {
        
    }
}