//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.findCoverage(matrix);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    public int check(int r,int c,int n,int m ,int matrix[][]){
        int t =0;
        if(r-1>=0 && matrix[r-1][c]==1){
            t++;
        }
        if(r+1<n && matrix[r+1][c]==1){
            t++;
        }
        if(c-1>=0 && matrix[r][c-1]==1){
            t++;
        }
        if(c+1<m && matrix[r][c+1]==1){
            t++;
        }
        return t;
    }
    
    public int findCoverage(int[][] matrix) {
        // code here
        int count =0;
        int n = matrix.length;
        int m = matrix[0].length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    int t = check(i,j,n,m,matrix);
                    count+=t;
                }
            }
        }
        
        return count ;
    }
}