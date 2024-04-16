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
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{
    
    public int rec(int index,int arr[],int totalsum,int sum ,int dp[][] ){
        if(index==arr.length){
            if(totalsum==sum){
                return 1;
            }
            return 0;
        }
        
        if(dp[index][totalsum]!=-1){
            return dp[index][totalsum];
        }
       // System.out.println(index+ " "+totalsum);
        
        int take = rec(index+1,arr,totalsum+arr[index],sum,dp);
        int nontake = rec(index+1,arr,totalsum,sum,dp);
        int count = (take+nontake)%1000000007;
        dp[index][totalsum] = count;
        return count;
    }
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    int total =0;
	    for(int v:arr){
	        total+=v;
	    }
	    int dp[][] = new int[n+1][total+1]; 
	    for(int i=0;i<=n;i++){
	        Arrays.fill(dp[i],-1);
	    }
	    return rec(0,arr,0,sum,dp);
	} 
}