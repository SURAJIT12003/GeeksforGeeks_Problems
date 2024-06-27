//{ Driver Code Starts
import java.util.*;

class Check_IsToepliz {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int arr[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) arr[i][j] = sc.nextInt();
            }

            Solution g = new Solution();
            boolean b = g.isToeplitz(arr);

            if (b == true)
                System.out.println("true");
            else
                System.out.println("false");

            T--;
        }
    }
}
// } Driver Code Ends


class Solution {
    
    /*You are required to complete this method*/
    
    
    public boolean rec(int r,int c,int n,int m,int v,int mat[][]){
        if(mat[r][c]!=v){
            return false;
        }
        boolean yt = true;
        if(r+1<n && c+1<m){
            yt = rec(r+1,c+1,n,m,v,mat);
        }
        return yt;
    }
    boolean isToeplitz(int mat[][]) {
        // Your code here
        int n = mat.length;
        int m = mat[0].length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                boolean t  = rec(i,j,n,m,mat[i][j],mat);
                if(!t){
                    return false;
                }
            }
        }
        
        return true;
    }
}