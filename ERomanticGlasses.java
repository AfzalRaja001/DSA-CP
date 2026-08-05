import java.util.*;

public class ERomanticGlasses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];

            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }

            long[] preOdd = new long[n];
            long[] preEven = new long[n];
            Map<Long, Integer> map = new HashMap<>();

            preEven[0] = arr[0];
            map.put(preOdd[0]-preEven[0], 1);
            boolean found = false;

            for(int i=1; i<n; i++){
                preEven[i] += preEven[i-1];
                preOdd[i] += preOdd[i-1];

                if(i%2 == 0){
                    preEven[i] += arr[i];
                }else{
                    preOdd[i] += arr[i];
                }

                long diff = preOdd[i]-preEven[i];
                map.put(diff, map.getOrDefault(diff, 0)+1);

                if(map.get(diff) == 2 || diff == 0){
                    found = true;
                    break;
                }
            }

            if(found){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}