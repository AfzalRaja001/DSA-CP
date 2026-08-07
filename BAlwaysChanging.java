import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BAlwaysChanging {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String line = br.readLine();
        if (line == null) return;
        int t = Integer.parseInt(line.trim());

        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();

            int x0 = 0;
            int x1 = 0;
            boolean has0 = false;
            boolean has1 = false;

            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0') has0 = true;
                if (s.charAt(i) == '1') has1 = true;

                if (i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                    if (s.charAt(i) == '0') {
                        x0++;
                    } else {
                        x1++;
                    }
                }
            }

            int b0 = 0; // Available boundary '0's to drop
            int b1 = 0; // Available boundary '1's to drop

            if (!has0 || !has1) {
                // If the entire string is just '0's or just '1's, only 1 boundary element exists
                if (has0) b0 = 1;
                else b1 = 1;
            } else {
                // First and last characters of s are guaranteed to be the start and end of s'
                if (s.charAt(0) == '0') b0++;
                else b1++;

                if (s.charAt(n - 1) == '0') b0++;
                else b1++;
            }

            int ans = -1;

            if (x1 >= x0) {
                int diff = x1 - x0;
                if (diff <= 1) {
                    ans = x1 + x0;
                } else if (diff - 1 <= b0) {
                    int extraDeletions = diff - 1;
                    ans = x1 + x0 + extraDeletions;
                }
            } else { // x0 > x1
                int diff = x0 - x1;
                if (diff <= 1) {
                    ans = x1 + x0;
                } else if (diff - 1 <= b1) {
                    int extraDeletions = diff - 1;
                    ans = x1 + x0 + extraDeletions;
                }
            }

            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }
}