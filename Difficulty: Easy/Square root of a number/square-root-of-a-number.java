//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			long a = sc.nextInt();
			Solution obj = new Solution();
			System.out.println(obj.floorSqrt(a));
		t--;
		}
	}
}
// } Driver Code Ends



class Solution{
    long floorSqrt(long x){
	    long low = 1;
	    long high = x;
	    long ans = 0;
	    
	    while(low <= high){
	        long mid = low + (high-low)/2;
	        
	        if((mid * mid) > x){
	            high = mid - 1;
	        }
	        
	        if( (mid*mid) <= x){
	            ans = mid;
	            low = mid + 1;
	        }
	    }
	    return ans;
    }
}
