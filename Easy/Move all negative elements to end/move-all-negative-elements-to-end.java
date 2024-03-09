//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
            PrintWriter ot = new  PrintWriter(System.out);
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            obj.segregateElements(a, n);
            
            for(int i=0;i<n;i++)
            ot.print(a[i]+" ");
            
            ot.println();
        }
        ot.close();
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public void segregateElements(int arr[], int n){
        int[] ans = new int[n];
        int i = 0;

        // Copy positive elements to ans array
        for(int a : arr){
            if(a >= 0){
                ans[i++] = a;
            }
        }

        // Copy negative elements to ans array
        for(int a : arr){
            if(a < 0){
                ans[i++] = a;
            }
        }
        
        int j = 0;
        for(int a : ans){
            arr[j++] = a;
        }
    }
}
