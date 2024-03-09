//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String S = sc.next();
                    int R = sc.nextInt();
                    int N = sc.nextInt();
                    Solution obj = new Solution();
                    System.out.println(obj.nthCharacter(S,R,N));
                }
                
        }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public char nthCharacter(String s, int r, int n)
    {
        //code here
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < r; i++){
            for (int j = 0; j < sb.length(); j += 2){
                if (sb.charAt(j) == '1') sb.insert(j + 1, '0');
                else sb.insert(j + 1, '1');
                
                if (j > n) break;
            }
        }
        return sb.charAt(n);
    }
}