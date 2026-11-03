import java.util.*;

public class Main1 {
    static List<List<Integer>> tree = new ArrayList<>();
    static int LOG = 19;

    static int[][] up = new int[200005][LOG];
    static int[] depth;

    static void dfsLifting(int node, int parent){
        up[node][0] = parent;
        depth[node] = depth[parent]+1;

        for(int i=1; i<LOG; i++){
            up[node][i] = up[up[node][i-1]][i-1];
        }

        for(int neigh : tree.get(node)){
            if(neigh != parent){
                dfsLifting(neigh, node);
            }
        }
    }
    static int getLCA(int u, int v){
        if(depth[u] < depth[v]){
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for(int i=0; i<LOG; i++){
            if(((diff >> i)& 1) == 1){
                u = up[u][i];
            }
        }

        if(u == v) return u;

        for(int i = LOG-1; i>=0;i--){
            if(up[u][i] != up[v][i]){
                u = up[u][i];
                v = up[v][i];
            }
        }

        return up[u][0];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        depth = new int[n];

        for(int i=0; i<n; i++){
            tree.add(new ArrayList<>());
        }

        for(int i=0; i<n-1; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            tree.get(u).add(v);
            tree.get(v).add(u);
        }

    }
}