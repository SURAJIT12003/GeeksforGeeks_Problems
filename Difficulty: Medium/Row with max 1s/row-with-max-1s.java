//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution {
    int max = Integer.MAX_VALUE;
    public void rec(int arr[],int start,int end){
        if(start>end){
            return; 
        }
        int mid = (start+end)/2;
        if(arr[mid]==1){
            max = Math.min(max,mid);
            rec(arr,start,mid-1);
        }
        else{
            rec(arr,mid+1,end);
        }
    }
    int rowWithMax1s(int arr[][]) {
        // code here
        int count =0;
        int ans =0;
        int index =-1;
        int n = arr.length;
        int m = arr[0].length;
        
        for (int i=0;i<n;i++){
            rec(arr[i],0,m-1);
            if(max!=Integer.MAX_VALUE){
                int t = (m-max)+1;
                if(ans<t){
                    ans = t;
                    index = i;
                }
                max = Integer.MAX_VALUE;
            }
        }
        
        if (index==-1){
            return -1 ;
        }
        
        return index ;
    }
}