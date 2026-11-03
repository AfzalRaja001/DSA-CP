import java.util.*;

public class Tree_Matching {
    static int count;

    static void dfs(int u, int parent, List<List<Integer>> adj, boolean[] vis){
        for(int v : adj.get(u)){
            if(v != parent)
                dfs(v, u, adj, vis);
        }

        for(int v : adj.get(u)){
            if(v != parent){
                if(!vis[u] && !vis[v]){
                    count++;
                    vis[u] = true;
                    vis[v] = true;
                    break;
                }
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        count = 0;
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        boolean vis[] = new boolean[n+1];
        for(int i=0; i<n-1; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        dfs(1, -1, adj, vis);

        System.out.println(count);

    }
}