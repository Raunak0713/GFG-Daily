//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
	static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            
            String s[] = br.readLine().trim().split(" ");
            
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                a[i] = Integer.parseInt(s[i]);
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(a, n, k);
            for(int ii = 0;ii<res.size();ii++)
                ot.print(res.get(ii) + " ");
            ot.println();
        }
        ot.close();
    }

}
// } Driver Code Ends


class Solution{
    public ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        int start = 0;
        int end = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        int sum = 0;

        while (end < n) {
            sum = sum + arr[end];

            while (sum > s && start <= end) {
                sum = sum - arr[start];
                start++;
            }

            if (sum == s && start <= end) {
                ans.add(start + 1);
                ans.add(end + 1);
                return ans;
            }

            end++;
        }

        ans.add(-1);
        return ans;
    }
}