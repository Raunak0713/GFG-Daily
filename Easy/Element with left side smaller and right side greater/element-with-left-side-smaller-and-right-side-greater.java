//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-- > 0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] a = new int[n];
            String[] inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Compute obj = new Compute();
            System.out.println(obj.findElement(a, n));
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java

class Compute {
    public int findElement(int arr[], int n){
        int leftmax[]=new int[n];
        int rightmax[]=new int[n];
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int j=n-1;
        for(int i=0;i<n;i++){
            if(arr[i]>=max)
                max=arr[i];
            leftmax[i]=max;
        }
         while(j>=0){  
            if(arr[j]<=min) 
                min=arr[j];
            rightmax[j]=min;
            j--;
         }    
         
    
        int ans=-1;
        for(int i=1;i<=n-2;i++) { 
            if(leftmax[i]==rightmax[i] ){
                ans=leftmax[i];
                break;
            }
        }
        return ans;
    }
}