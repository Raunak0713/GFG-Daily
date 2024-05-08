//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static String longestPalin(String s){
        // code here
        if (s.length() <= 1) return s;
        String lps = String.valueOf(s.charAt(0));
        for (int i = 1; i < s.length(); i++){
            String s1 = palindrome(s, i, i);
            if (s1.length() > lps.length()) lps = s1;
            s1 = palindrome(s, i - 1, i);
            if (s1.length() > lps.length()) lps = s1;
        }
        
        return lps;
    }
    
    static String palindrome(String str, int i, int j){
        while (str.charAt(i) == str.charAt(j)){
            i--;
            j++;
            
            if (i == -1 || j == str.length()) break;
        }
        return str.substring(i + 1, j);
    }
}