//{ Driver Code Starts
import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) {
		
		//taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking total testcases
		int t = sc.nextInt();
		
		while(t-- > 0){
		    
		    //taking count of stairs
		    int m = sc.nextInt();
		    
		    //creating an object of class DynamicProgramming
		    Solution obj = new Solution();
		    
		    //calling method countWays() of class
		    //DynamicProgramming
		    System.out.println(obj.countWays(m));
		    
		}
		
	}
}
// } Driver Code Ends


class Solution
{
    //Function to count number of ways to reach the nth stair.
    public int rec(int i,int n,int dp[]){
        if(i>n){
            return 0;
        }
        if(i==n){
            return 1;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int one = rec(i+1,n,dp);
        int two = rec(i+2,n,dp);
        int total = (one+two)%1000000007;
        dp[i] = total;
        return total;
    }
    int countWays(int n)
    {
        
        // your code here
        int dp[] = new int [n];
        Arrays.fill(dp,-1);
        return rec(0,n,dp);
    }
}

