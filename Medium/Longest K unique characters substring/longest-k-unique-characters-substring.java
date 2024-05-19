//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
           int left =0;
           int right =0;
           int n  = s.length();
           int ans =-1;
           HashMap<Character,Integer> hs = new HashMap<>();
           
           while(right<n){
               char ch = s.charAt(right);
               if(hs.containsKey(ch)){
                   int t = hs.get(ch);
                   hs.put(ch,t+1);
               }
               else{
                   hs.put(ch,1);
               }
               
               if(hs.size()>k){
                 
                       int t = hs.get(s.charAt(left));
                       if(t!=0){
                           t--;
                           hs.put(s.charAt(left),t);
                       }
                       if(t==0){
                           hs.remove(s.charAt(left));
                       }
                       left++;
                   
               }
               if(hs.size()==k){
                    ans =  Math.max(ans,(right-left+1));
               }
              
               right++;
           }
           
           return ans;
    }
}