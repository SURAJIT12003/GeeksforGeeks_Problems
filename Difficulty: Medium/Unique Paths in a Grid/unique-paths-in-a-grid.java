//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            
            int [][] grid = new int[n][m];
            for(int i=0; i<n; i++)
            {
                String S1[] = read.readLine().split(" ");
                for(int j=0; j<m; j++)
                {
                    grid[i][j] = Integer.parseInt(S1[j]);
                }
            }

            Solution ob = new Solution();
            System.out.println(ob.uniquePaths(n,m,grid));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static int rec(int r,int c,int n,int m,int grid[][],int dp[][]){
        if(grid[r][c]==0){
            return 0;
        }
        if(r==n-1 && c==m-1){
            return 1;
        }
        if(dp[r][c]!=-1){
            return dp[r][c];
        }
        
        grid[r][c] = 0;
        int right =0;
        if(c+1<m){
            right  = rec(r,c+1,n,m,grid,dp);
        }
        int down =0;
        if(r+1<n){
            down  = rec(r+1,c,n,m,grid,dp);
        }
        dp[r][c] = (right+down) % 1000000007;
        grid[r][c] =1;
        return dp[r][c];
    }
    static int uniquePaths(int n, int m, int[][] grid) {
        // code here
        int dp[][] = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans = rec(0,0,n,m,grid,dp);
        return ans;
    }
};