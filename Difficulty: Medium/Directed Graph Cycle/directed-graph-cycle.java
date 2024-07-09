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
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int[] InDegree = new int[V];
        
        for(int i=0; i<V; i++){
            for(int v : adj.get(i)){
                InDegree[v]++;
            }
        }
        
        for(int i=0; i<V; i++){
            if(InDegree[i] == 0){
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()){
            int u = queue.poll();
            ans.add(u);
            
            for(int v : adj.get(u)){
                InDegree[v]--;
                if(InDegree[v] == 0){
                    queue.add(v);
                }
            }
        }
        
        return ans.size() != V;
    }
}