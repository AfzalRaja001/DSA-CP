import java.util.*;

public class BWowFactor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s= sc.next();

        long w= 0;
        long wo = 0;
        long wow = 0;

        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == 'v' && s.charAt(i-1) == 'v'){
                wow += wo;
                w++;
            }else if(s.charAt(i) == 'o'){
                wo += w;
            }
        }

        System.out.println(wow);
    }
}