import java.util.*;

public class DDistrictsConnection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0 ){
            int n = sc.nextInt();
            int[] arr = new int[n];

            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }

            int count = 0;
            List<List<Integer>> ans = new ArrayList<>();
            boolean possible = false;

            for(int i=0; i<n; i++){
                for(int j=i+1; j<n; j++){
                    if(count == n-1){
                        possible = true;
                        break;
                    }
                    if(arr[i] != arr[j]){
                        count++;
                        List<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        ans.add(temp);
                    }
                }
                if(possible) break;
            }

            if(!possible){
                System.out.println("NO");
            }else{
                System.out.println("YES");
                for(List<Integer> a : ans){
                    System.out.println(a.get(0) + " " + a.get(1));
                }
            }
        }
    }
}