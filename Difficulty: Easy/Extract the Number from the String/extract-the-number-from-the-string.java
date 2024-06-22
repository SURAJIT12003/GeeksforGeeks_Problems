//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.ExtractNumber(S));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long ExtractNumber(String s) {
        // code here
        long max =-1;
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            if(curr>='0' && curr<='9'){
                int in =i;
                String str = "";
                for(int j=i;j<s.length();j++){
                    char c = s.charAt(j);
                    if(c>='0' && c<='9'){
                        str=str+c;
                        in=j;
                    }
                    else{
                        in=j;
                        break;
                    }
                }
                if(!str.contains("9")){
                    long t = Long.parseLong(str);
                    max = Math.max(max,t);
                }
                
                i = in;
                
            }
        }
        
        return max;
    }
}