//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.stream.*;

class GFG {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String str = br.readLine();
            String s1 = str.split(" ")[0];
            String s2 = str.split(" ")[1];

            Solution obj = new Solution();

            if (obj.isAnagram(s1, s2)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function is to check whether two strings are anagram of each other or not.
    public static boolean isAnagram(String a, String b) {

        
        HashMap<Character,Integer> hs  = new HashMap<>();
        for(int i=0;i<a.length();i++){
            char ch = a.charAt(i);
            if(hs.containsKey(ch)){
                int t = hs.get(ch);
                t++;
                hs.put(ch,t);
            }
            else{
                hs.put(ch,1);
            }
        }
        
         
        HashMap<Character,Integer> map  = new HashMap<>();
        for(int i=0;i<b.length();i++){
            char ch = b.charAt(i);
            if(map.containsKey(ch)){
                int t = map.get(ch);
                t++;
                map.put(ch,t);
            }
            else{
                map.put(ch,1);
            }
        }
        
        for(char ch:hs.keySet()){
            if(map.containsKey(ch)==false){
                return false;
            }
            int g =hs.get(ch);
            int nb = map.get(ch);
            if(g!=nb){
                return false;
            }
        }
          for(char ch:map.keySet()){
            if(hs.containsKey(ch)==false){
                return false;
            }
           
        }
        
        return true ;
        
        
    }
}