import java.util.*;


public class GWhiteBlackBalancedSubtrees {
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){
            int n = sc.nextInt();
            int[] par = new int[n];

            for(int i=1;i<n; i++ ){
                par[i] = sc.nextInt();
            }

            String color = sc.next();

            List<List<Integer>> graph = new ArrayList<>();
            for(int i=0; i<n; i++){
                graph.add(new ArrayList<>());
            }

            for(int i=1; i<n; i++){
                int parent = par[i]-1;
                graph.get(parent).add(i);
            }

            count = 0;

            dfs(0, graph, color);

            System.out.println(count);
        }
    }

    static int dfs(int u, List<List<Integer>> graph, String color){
        int balance = (color.charAt(u) == 'W') ? 1 : -1;

        for(int child : graph.get(u)){
            balance += dfs(child, graph, color);
        }

        if(balance == 0){
            count++;
        }

        return balance;
    }
}