//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str = read.readLine().trim();
            String ans = ob.compareFrac(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {

    String compareFrac(String str) {
        // Split the input string into two parts using ", " as the delimiter
        String[] fractions = str.split(", ");
        
        // Split each fraction into numerator and denominator
        String[] fraction1 = fractions[0].split("/");
        String[] fraction2 = fractions[1].split("/");
        
        // Convert numerators and denominators to integers
        int a = Integer.parseInt(fraction1[0]);
        int b = Integer.parseInt(fraction1[1]);
        int c = Integer.parseInt(fraction2[0]);
        int d = Integer.parseInt(fraction2[1]);
        
        // Compare fractions by cross-multiplying
        int leftSide = a * d;
        int rightSide = b * c;
        
        if (leftSide > rightSide) {
            return fractions[0]; // First fraction is greater
        } else if (leftSide < rightSide) {
            return fractions[1]; // Second fraction is greater
        } else {
            return "equal"; // Both fractions are equal
        }
    }
}
