//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] fruits = new int[N];
            for (int i = 0; i < N; i++) fruits[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.totalFruits(N, fruits);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
     public static int check(  ArrayList<Integer> arr){
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<arr.size();i++){
            hs.add(arr.get(i));
        }
        return hs.size();
    }
    public static int totalFruits(int n, int[] A) {
        int left =0;
        int right =0;
        int length =-1;
        
        int k = 2;
        ArrayList<Integer> arr = new ArrayList<>();
        
        while(right<n){
            
          
            arr.add(A[right]);
            int count = check(arr);
           
            if(count>k){
                while(left<=right){
                    left++;
                    arr.remove(0);
                    int c = check(arr);
                    if(c==k){
                        length = Math.max(length,(right-left+1));
                        break;
                    }
                }
            }
            
            if(count==k){
                length = Math.max(length,(right-left+1));
            }
           // System.out.println(count);
            right++;
            
        }
        
        return length;
    }
}