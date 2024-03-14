//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj =
                new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < V; i++) adj.add(new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.dfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> mp) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        for (int i = 0; i < mp.size(); i++) {
            int vertex = i;
            ArrayList<Integer> neighbours = mp.get(i);
            adj.put(vertex, new ArrayList<>(neighbours));
        }
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Boolean> visited = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            visited.add(false);
        }
        
        DFS(adj, 0, visited, result);
        
        return result;
    }
    
    public void DFS(HashMap<Integer, ArrayList<Integer>> adj, int u, ArrayList<Boolean> visited, ArrayList<Integer> result) {
        if (visited.get(u)) {
            return;
        }
        visited.set(u, true);
        result.add(u);
        for (int v : adj.get(u)) {
            if (!visited.get(v)) {
                DFS(adj, v, visited, result);
            }
        }
    }
}
