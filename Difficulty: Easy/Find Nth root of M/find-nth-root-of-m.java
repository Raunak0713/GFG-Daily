//{ Driver Code Starts
//Initial Template for Java

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
            String s = br.readLine().trim();
            String[] S1 = s.split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            Solution ob = new Solution();
            int ans = ob.NthRoot(n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public int NthRoot(int n, int m) {
        int low = 1;
        int high = m;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long product = power(mid, n);
            
            if (product == m) {
                return mid;
            } else if (product > m || product < 0) { // product < 0 indicates overflow
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return -1;
    }

    public long power(int base, int exp) {
        long result = 1;
        for (int i = 0; i < exp; i++) {
            result *= base;
            if (result > Integer.MAX_VALUE) {
                return -1; // Indicates overflow
            }
        }
        return result;
    }
}