//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    public void rec(int r,int c,int mat[][],String s,int n,int m,ArrayList<String> ans){
        if(r==n-1 && c==m-1){
            ans.add(s);
           // System.out.println("ok");
            return;
        }
        if(mat[r][c]==0){
            return;
        }
        
        mat[r][c] = 0;
     //    System.out.println(r+" "+c);
        if(r-1>=0 && mat[r-1][c]==1){
            rec(r-1,c,mat,s+"U",n,m,ans);
        }
        
        if(r+1<n && mat[r+1][c]==1){
            rec(r+1,c,mat,s+"D",n,m,ans);
        }
        
        
        if(c-1>=0 && mat[r][c-1]==1){
            rec(r,c-1,mat,s+"L",n,m,ans);
        }
        
        
        if(c+1<m && mat[r][c+1]==1){
            rec(r,c+1,mat,s+"R",n,m,ans);
        }
        
        mat[r][c] = 1;
        
        
        
    }
    public ArrayList<String> findPath(int[][] mat) {
        // Your code here
        int n = mat.length;
        int m = mat[0].length;
        ArrayList<String> ans = new ArrayList<>();
        rec(0,0,mat,"",n,m,ans);
        if(ans.size()==0){
            ans.add("-1");
        }
        return ans;
    }
}