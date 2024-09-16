//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to reverse words in a given string.
    String reverseWords(String str) {
        String ans = "";
        int n = str.length();
        StringBuffer st = new StringBuffer();
        for(int i=n-1;i>=0;i--){
            char ch = str.charAt(i);
            if(ch=='.'){
                st.reverse();
                ans=ans+st.toString();
                st.setLength(0);
                ans = ans+'.';
                continue;
            }
            st.append(ch);
        }
        st.reverse();
        ans=ans+st.toString();
        
        return ans;
        
    }
}