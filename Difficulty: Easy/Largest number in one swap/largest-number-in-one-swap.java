//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String N = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.LargestSwap(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String LargestSwap(String S){
        //code here
        int max = 0;
        int index =0;
        char c1 = 'o';
        for(int i=0;i<S.length();i++){
            int  c = S.charAt(i)-'0';
            if(c>=max){
                max = c;
                index =i;
                c1=S.charAt(i);
            }
            
        }
        
        ;
        int in =index;
        int min = max;
        char c2 ='p';
        for(int i=0;i<S.length();i++){
            int  c = S.charAt(i)-'0';
            if(c<min){
                c2 = S.charAt(i);
                min = c;
                in =i;
                break;
            }
        }
       if(index<=in){
           return S;
       }
       StringBuffer ans = new StringBuffer();
       ans.append(S);
       ans.setCharAt(index,c2);
       ans.setCharAt(in,c1);
        
        return ans.toString() ;
        
    }
}