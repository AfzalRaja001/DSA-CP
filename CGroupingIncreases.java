import java.util.*;

public class CGroupingIncreases {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){
            int n = sc.nextInt();
            int[] nums = new int[n];

            for(int i=0; i<n; i++){
                nums[i] = sc.nextInt();
            }

            int x = Integer.MAX_VALUE;
            int y = Integer.MAX_VALUE;
            int count = 0;

            for(int v : nums){
                if(x > y){
                    int temp =x;
                    x=y;
                    y=temp;
                }

                if(v <= x){
                    x = v;
                }else if(v <= y){
                    y = v;
                }else{
                    count++;
                    x = v;
                }
            }

            System.out.println(count);
        }
    }
}