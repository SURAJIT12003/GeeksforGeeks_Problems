//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            int m = Integer.parseInt(br.readLine().trim());

            int ans = new Solve().findZeroes(arr, n, m);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    // m is maximum of number zeroes allowed to flip
    int findZeroes(int nums[], int n, int k) {
      //Longest Subarray with at most k Zero (This Problem)
        int left =0;
        int right =0;
        int length =0;
        int ans =0;

        while(right<n){
            if(nums[right]==0 && k!=0){
                right++;
                k--;
            }
            else if(nums[right]==0 && k==0){
               
                while(nums[left]!=0 && left<=right){
                    left++;
                }
                left++;
                k++;
            }
            else{
                right++;
            }
            length  =Math.max(length,(right-left));
           
        }
        return length;
    }
}