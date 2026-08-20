import java.util.*;

public class LC3069 {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        l1.add(nums[0]);
        l2.add(nums[1]);

        for(int i=2; i<n; i++){
            int last1 = l1.get(l1.size()-1);
            int last2 = l2.get(l2.size()-1);

            if(last1 > last2){
                l1.add(nums[i]);
            }else{
                l2.add(nums[i]);
            }
        }

        int[] ans = new int[n];
        int i=0;
        for(int j=0; j<l1.size(); j++){
            ans[i++] = l1.get(j);
        }
        for(int j=0; j<l2.size(); j++){
            ans[i++] = l2.get(j);
        }

        return ans;
    }
    public static void main(String[] args) {
        
    }
}