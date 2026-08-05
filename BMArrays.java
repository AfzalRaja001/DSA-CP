import java.util.*;

public class BMArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arr = new int[n];
            Set<Integer> set = new HashSet<>();
            int max =0;

            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            int rem[] = new int[m];

            for(int i=0; i<n; i++){
                rem[arr[i]%m]++;
            }

            int ans = 0;
            for(int i=0; i<m; i++){
                int x = rem[i];
                int y = rem[(m-i)%m];

                if(x==0 && y == 0) continue;

                int temp =  Math.min(x, y);

                x -= Math.min(temp+1, x);
                y -= Math.min(temp+1, y);

                ans++;

                ans += (x+y);

                rem[i] = 0;
                rem[(m-i)%m] = 0;
            }

            System.out.println(ans);
        }
    }
}