//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String s = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubsttr(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    int longestUniqueSubsttr(String s){
         int n = s.length();
        if(n==0){
            return 0;
        }
        int left =0;
        int right =0;
        ArrayList<Character> arr = new ArrayList<>();
        int length =1;
        arr.add(s.charAt(0));

        while(right<n-1){
            right++;
            if(arr.contains(s.charAt(right))){
                while(arr.contains(s.charAt(right)) && left<=right){
                    arr.remove(0);
                    left++;
                }
                arr.add(s.charAt(right));
            }
            else{
                arr.add(s.charAt(right));
            }
            length = Math.max(length,(right-left+1));
            //System.out.println(right+" "+left);
        }

        return length;
    }
}