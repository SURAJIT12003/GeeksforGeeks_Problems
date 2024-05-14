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

            ArrayList<Long> ans = new Solution().nthRowOfPascalTriangle(n);
            printAns(ans);
        }
    }
    public static void printAns(ArrayList<Long> ans) {
        for (Long x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
   ArrayList<Long> ans = new ArrayList<>();
    public void rec(int index, int row, ArrayList<Long> s) {
        if (index == row) {
            ans.addAll(s);
            return;
        }
        ArrayList<Long> arr = new ArrayList<>();
        arr.add(s.get(0));
        for (int i = 1; i < s.size(); i++) {
            long t = (s.get(i) + s.get(i - 1))%1000000007;
            arr.add(t);
        }
        arr.add(s.get(s.size() - 1));
       
        rec(index + 1, row, arr);
    }
    ArrayList<Long> nthRowOfPascalTriangle(int numRows) {
        ArrayList<Long> arr  = new ArrayList<>();
        long tt =1;
        arr.add(tt);
       
        if (numRows == 1) {
          
            return arr;
        }
        rec(1,numRows,arr);
        return ans;
    }
}