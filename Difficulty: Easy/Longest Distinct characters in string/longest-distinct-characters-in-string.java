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
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubstrDistinctChars(String s){
       HashSet<Character> hs = new HashSet<>();
        int first = 0;
        int last =0;
        int ans =0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            last =i;
            if(hs.contains(ch)){
                while(hs.contains(ch) && first<=last){
                    hs.remove(s.charAt(first));
                    first++;
                }
            }
            hs.add(ch);
            int dis = (last-first)+1;
            ans = Math.max(ans,dis);
        }
        return ans;
        
    }
}