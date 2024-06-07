//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String st = sc.next();
            
            char ans=new Solution().nonrepeatingCharacter(st);
            
            if(ans!='$')
            System.out.println(ans);
            else
            System.out.println(-1);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static char nonrepeatingCharacter(String S){
        HashMap<Character,Integer> ans = new HashMap<>();
        ArrayList<Character> arr = new ArrayList<>();
        for(char c : S.toCharArray()){
            ans.put(c,ans.getOrDefault(c,0)+1);
        }
        for(char c : ans.keySet()){
            if(ans.get(c) == 1){
                arr.add(c);
            }
        }
        for(char c : S.toCharArray()){
            if(arr.contains(c)){
                return c;
            }
        }
        return '$';
    }
}

