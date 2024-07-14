//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Searching {
    public static void main(String[] args) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String a[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(a[0]);
            long x = Long.parseLong(a[(int)1]);
            String st[] = read.readLine().trim().split("\\s+");

            long arr[] = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(st[i]);
            }

            out.println(new Solution().findFloor(arr, n, x));
        }
        out.close();
    }
}
// } Driver Code Ends


class Solution {
    static int findFloor(long arr[], int n, long x) {
        int start = 0;
        int end = arr.length-1;
        int index = -1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] == x){
                return mid;
            }
            else if(arr[mid] < x){
                start = mid + 1;
                index = mid;
            }else{
                end = mid - 1;
            }
        }
        return index;
    }
}
