//{ Driver Code Starts
//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;

import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		long t=sc.nextLong();
		
		while(t-->0)
		{
		  int n=sc.nextInt();
		  long arr[]=new long[n];
		  long brr[]=new long[n];
		  
		  for(int i=0;i<n;i++)
		  {
		      arr[i]=sc.nextLong();
		  }
		  
		  for(int i=0;i<n;i++)
		  {
		      brr[i]=sc.nextLong();
		  }
		  Solution ob = new Solution();
		  System.out.println(ob.check(arr,brr,n)==true?"1":"0");
		  
		  
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public static boolean check(long A[],long B[],int N){
        HashMap<Long,Long> a1 = new HashMap<>();
        HashMap<Long,Long> a2 = new HashMap<>();
        for(long a : A){
            a1.put(a,a1.getOrDefault(a,0L)+1);
        }
        for(long a : B){
            a2.put(a,a2.getOrDefault(a,0L)+1);
        }
        return a1.equals(a2);
    }
}