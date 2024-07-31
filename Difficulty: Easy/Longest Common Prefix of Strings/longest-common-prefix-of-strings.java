//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    public boolean check(String arr[],int index,char ch){
        for(String v:arr){
            char f = v.charAt(index);
            if(f!=ch){
                return false;
            }
        }
        
        return true;
    }
    public String longestCommonPrefix(String arr[]) {
       
        int len = Integer.MAX_VALUE;
        String s = "";
        for(String v:arr){
            if(v.length()<len){
                len = v.length();
                s  = "";
                s += v;
            }
        }
        
        int index =0;
        
        while(index<s.length()){
            char ch = s.charAt(index);
            
            if(!check(arr,index,ch)){
                if(index==0){
                    return "-1";
                }
                return s.substring(0,index);
            }
            index++;
        }
        
        return s;
    }
}