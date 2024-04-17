//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxLength(String S){
        // code here
        int ans =0;
        int open =0;
        int close =0;
        for(int i=0;i<S.length();i++){
            char c = S.charAt(i);
            if(c=='('){
                open++;
            }
            else{
                close++;
            }
            
            if(open==close){
                ans= Math.max(ans,(open+close));
            }
            else if(close>open){
                open=0;
                close=0;
            }
        }
        
        open=0;
        close =0;
         for(int i=S.length()-1;i>=0;i--){
            char c = S.charAt(i);
            if(c=='('){
                open++;
            }
            else{
                close++;
            }
            
            if(open==close){
                ans= Math.max(ans,(open+close));
            }
            else if(close<open){
                open=0;
                close=0;
            }
        }
        return ans;
        
    }
}