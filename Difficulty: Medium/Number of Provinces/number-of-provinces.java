//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] vis = new boolean[V];
        int count = 0;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        for(int i=0; i<V; i++){
            ans.add(new ArrayList<>());
        }
        
        for(int i=0; i<V; i++){
            for(int j=0; j<V; j++){
                if(i!=j && adj.get(i).get(j) == 1){
                    ans.get(i).add(j);
                    ans.get(j).add(i);
                }
            }
        }

        for(int i=0; i<V; i++){
            if(!vis[i]){
                DFS(ans, vis, i);
                count++;
            }
        }
        return count;
    }
    static void DFS(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int u){
        vis[u] = true;
        
        for(int v : adj.get(u)){
            if(!vis[v]){
                DFS(adj, vis, v);
            }
        }
    }
};