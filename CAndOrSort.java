import java.util.*;

public class CAndOrSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){
            int n = sc.nextInt();
            String s = sc.next();

            int[] suf = new int[n+1];
            suf[n] = 0; // Added missing semicolon
            int ans = Integer.MAX_VALUE;

            for(int i=n-1; i>=0; i--){
                suf[i] = suf[i+1];
                if(s.charAt(i) != '1'){
                    suf[i] += 1;
                }
            }

            if(s.charAt(0) == '1'){ // Fixed character comparison
                System.out.println(suf[0]);
            } else {
                int count = 0;
                for(int i=0; i<n; i++){
                    char ch = s.charAt(i);

                    if(ch == '1'){
                        ans = Math.min(ans, count+suf[i+1]);
                        count++;
                    }
                }
                System.out.println(Math.min(ans, count));
            }
        }
    }
}