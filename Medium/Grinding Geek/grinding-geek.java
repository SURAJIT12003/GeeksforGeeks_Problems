//{ Driver Code Starts
import java.util.*;
import java.io.*;

public class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0)
        {
            int n = scanner.nextInt();
            int total = scanner.nextInt();
            int[] cost = new int[n];
            for (int i = 0; i < n; i++) {
                cost[i] = scanner.nextInt();
            }
            Solution solution = new Solution();
            int result = solution.max_courses(n, total, cost);
            System.out.println(result);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    public int rec(int total,int index,int cost[],int dp[][]){
        if(index==cost.length){
            return 0;
        }
        if(dp[index][total]!=-1){
            return dp[index][total];
        }
        int take =0;
        int not =0;
        if(total>=cost[index]){
            int t = total-cost[index];
            int per = (cost[index]*90)/100;
            int curr = t+per;
            take = 1+ rec(curr,index+1,cost,dp);
        }
        not  = rec(total,index+1,cost,dp);
        int max = Math.max(take,not);
        dp[index][total] =max;
        return max;
    }
    public int max_courses(int n, int total, int[] cost) {
        int c =0;
        for(int v:cost){
            c+=v;
        }
        int dp[][] = new int [n][10000];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return rec(total,0,cost,dp);
    }
}

