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
    static long maxScore(int card[], int N, int k) {
        int left =0;
        int right =0;
        long sum =0;
        long ans =0;
        
        for(int i=0;i<k;i++){
            sum+=card[i];
        }
        ans = Math.max(ans,sum);
        right  = (k-1);
        
        int newRight =N-1;
        while(right>=0){
           sum-=card[right];
           sum+=card[newRight];
           right--;
           newRight--;
           ans = Math.max(ans,sum);
        }
        return ans;
    }
}
