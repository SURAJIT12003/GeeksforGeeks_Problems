//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int w;
            w = Integer.parseInt(br.readLine());

            int[] cost = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.minimumCost(n, w, cost);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends




class Solution
{
    
    public int rec(int i,int W,int cost[],int dp[][]){
        
        if(W==0){
            return 0;
        }
        
        if(i==0){
            if(cost[0]!=-1){
                return cost[0]*W;
            }
            return Integer.MAX_VALUE;
        }
        if(dp[i][W]!=-1){
            return dp[i][W];
        }
        int take = Integer.MAX_VALUE;
        if(W>=(i+1) && cost[i]!=-1){
            take = rec(i,W-(i+1),cost,dp);
            if(take!=Integer.MAX_VALUE){
                take = take + cost[i];
            }
            
        }
        int non = rec(i-1,W,cost,dp);
        int min =  Math.min(non,take);
        dp[i][W] = min;
        return min ;
        
        
    }
	public int minimumCost( int N,int W,int cost[])
	{
	    int dp[][] = new int [N][W+1];
	    for(int i=0;i<N;i++){
	        for(int j=0;j<=W;j++){
	            dp[i][j] = -1;
	        }
	    }
	    int ans = rec(N-1,W,cost,dp);
	    if(ans==Integer.MAX_VALUE){
	        return -1;
	    }
	    
	    return ans ;
	}
}