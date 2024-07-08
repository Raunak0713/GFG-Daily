//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        boolean[] inRecursion = new boolean[V];
        
        for(int i=0; i<V; i++){
            if(!vis[i] && Check(adj, vis, inRecursion, i)){
                return true;
            }
        }
        return false;
    }
    
    public boolean Check(ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] inRecursion, int u){
        vis[u] = true;
        inRecursion[u] = true;
        for(int v : adj.get(u)){
            if(!vis[v] && Check(adj, vis, inRecursion, v)){
                return true;
            }
            if(vis[v] && inRecursion[v]){
                return true;
            }
        }
        inRecursion[u] = false;
        return false;
    }
}