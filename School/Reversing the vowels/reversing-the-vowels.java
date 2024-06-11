//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s;
            s = sc.next();
           
            Solution ob = new Solution();
            
            System.out.println(ob.modify(s));    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    String modify(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        int j = sb.length() - 1;
        
        while (i < j) {
            char f = sb.charAt(i);
            char se = sb.charAt(j);
            
            if (isVowel(f) && isVowel(se)) {
                char c = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(j));
                sb.setCharAt(j, c);
                i++;
                j--;
            } else {
                if (!isVowel(f)) {
                    i++;
                }
                if (!isVowel(se)) {
                    j--;
                }
            }
        }
        
        return sb.toString();
    }
    
    boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}
