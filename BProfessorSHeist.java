import java.util.*;

public class BProfessorSHeist {
    static int MOD = (int)1e9+7;
    static class DSU{
        int[] parent;
        int components;

        DSU(int n){
            parent = new int[n];
            components = n;

            for(int i=0; i<n; i++){
                parent[i] = i;
            }
        }

        int find(int u){
            if(u == parent[u]) return u;

            return parent[u] = find(parent[u]);
        }

        void union(int u, int v){
            int parU = find(u);
            int parV = find(v);

            if(parU != parV){
                parent[parU] = parV;
                components--;
            }
        }
    }
    static long power(long base, int exponent){
        long res = 1;

        while(exponent > 0){
            if(exponent%2 != 0) res = (res*base)%MOD;
            base = (base*base)%MOD;

            exponent /= 2;
        }

        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){
            int n = sc.nextInt();
            int p = sc.nextInt();

            DSU d = new DSU(n);

            for(int i=0; i<p; i++){
                int L = sc.nextInt();
                int R = sc.nextInt();

                while(L < R){
                    d.union(L, R);
                    L++;
                    R--;
                }
            }
            int C = d.components;

            System.out.println(power(26, C));
        }
    }
}