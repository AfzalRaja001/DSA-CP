import java.util.*;

public class CChatBan {
    static long getMsg(long m, long k){
        if(m <= k){
            return (m*(m+1))/2;
        }else{
            long extra = m-k;

            return (k*(k+1)/2) + (extra*(2*k-extra-1))/2;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){
            long k = sc.nextLong();
            long x = sc.nextLong();

            long low = 1, high = 2*k-1;

            while(low < high){
                long mid = low + (high-low)/2;

                if(getMsg(mid, k) >= x){
                    high = mid;
                }else{
                    low = mid+1;
                }
            }

            System.out.println(low);
        }
    }
}