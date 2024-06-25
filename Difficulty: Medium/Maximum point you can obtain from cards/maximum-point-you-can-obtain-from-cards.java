//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            long ans = obj.maxScore(a, n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static long maxScore(int cardPoints[], int N, int k) {
         int n = cardPoints.length;
        int total=0;
        int size = n-k;
        int left =0;
        int right =0;
        int sum =0;
        int max =0;
        for(int v:cardPoints){
            total+=v;
        }
        for(int i=0;i<size;i++){
            sum+=cardPoints[i];
        }
        right = size;
        max = Math.max(max,total-sum);
     


        for(int i=1;i<n;i++){
            sum = sum-cardPoints[left];
            left++;
            sum=sum+cardPoints[right];
            max = Math.max(max,total-sum);
            right++;
            if(right==n){
                break;
            }
        }

        return max;
    }
}
