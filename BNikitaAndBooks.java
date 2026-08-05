import java.util.*;

public class BNikitaAndBooks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];

            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }

            boolean notFound = false;

            long extra = 0;
            for(int i=0; i<n; i++){
                int req = i+1;
                if(arr[i] >= req){
                    extra += arr[i] - i -1;
                }else{
                    extra -= i+1 - arr[i];
                }

                if(extra < 0){
                    notFound = true;
                    break;
                }
            }

            if(!notFound){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}