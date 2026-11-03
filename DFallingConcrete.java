import java.util.*;

public class DFallingConcrete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){
            int n = sc.nextInt();
            long arr[] = new long[n];

            for(int i=0; i<n; i++){
                arr[i] = sc.nextLong();
                arr[i] = arr[i] - (i+1);
            }

            Arrays.sort(arr);
            int ans = 1;
            int count = 1;

            for(int i=1; i<n; i++){
                if(arr[i] == arr[i-1]+1){
                    count++;
                    ans = Math.max(ans, count);
                }else if(arr[i] == arr[i-1]){
                    continue;
                }
                else{
                    count = 1;
                }
            }

            System.out.println(ans);
        }
    }
}