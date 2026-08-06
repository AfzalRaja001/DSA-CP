import java.util.*;

public class BAverageSleepTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        long[] arr = new long[n];


        for(int i=0; i<n; i++){
            arr[i] = sc.nextLong();
        }

        long currSum = 0;
        for(int i=0; i<=k; i++){
            currSum += arr[i];
        }
        long sum = 0;
        int l =0; r = k;
        while(r<n){
            sum += currSum
        }
    }
}