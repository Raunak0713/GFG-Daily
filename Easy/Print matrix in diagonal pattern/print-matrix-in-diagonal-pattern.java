//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] mat = new int[n][n];
            String[] S = br.readLine().trim().split(" ");
            int i = 0;
            int j = 0;
            for(int k = 0; k < S.length; k++){
                mat[i][j] = Integer.parseInt(S[k]);
                j++;
                if(j == n){
                    i++;
                    j = 0;
                }
            }
            Solution obj = new Solution();
            int[] ans = obj.matrixDiagonally(mat);
            for(int it = 0; it < ans.length; it++){
                System.out.print(ans[it] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution 
{
    public int[] matrixDiagonally(int[][] mat) 
    {
        int n = mat.length, m = mat[0].length, i = 0, j = 0;
        ArrayList<Integer> res = new ArrayList<>();
        boolean isUp = true;
    
        for(int k = 0; k < m * n; ) 
        {
            if(isUp)
            {
                for(;i >= 0 && j < m; i--, j++) 
                {
                    res.add(mat[i][j]);
                    k++;
                }
                
                if(i < 0 && j < m)
                    i = 0;
                    
                if(j == m) 
                {
                    i += 2;
                    j--;
                }
            }
            else 
            {
                for(;j >= 0 && i < n; i++, j--) 
                {
                    res.add(mat[i][j]);
                    k++;
                }
                
                if(j < 0 && i < n)
                    j = 0;
                    
                if(i == n) 
                {
                    j += 2;
                    i--;
                }
            }
            
            isUp = !isUp;
        }
        
        int arr[] = new int[res.size()];
        for(i = 0; i < res.size(); i++)
            arr[i] = res.get(i);
        
        return arr;        
    }
}