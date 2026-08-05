import java.util.*;

public class AIskanderAndDrawings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){
            int n = sc.nextInt();
            String s = sc.next();
            int max = 0;
            int count = 0;

            for(int i=0; i<n; i++){
                if(s.charAt(i) == '#'){
                    count++;
                    max = Math.max(max, count);
                }else{
                    count = 0;
                }
            }

            System.out.println((max+1)/2);
        }
    }
}