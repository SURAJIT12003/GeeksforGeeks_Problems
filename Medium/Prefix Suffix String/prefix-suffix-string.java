//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

public class code1 
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            String s1[]=in.readLine().trim().split(" ");
            String s2[]=in.readLine().trim().split(" ");

            Solution ob=new Solution();
            int ans=ob.prefixSuffixString(s1,s2);
            out.println(ans);

        }
        out.close();
    }
}
// } Driver Code Ends

class node {
        node children[] = new node[26];
        boolean isEnd = false;

        node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }
//User function Template for Java
class Solution
{
    

    public  node root = new node();

    // insertion
    public  void insertion(String word) {
        node temp = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int idx = ch-'a';

            if (temp.children[idx]==null){

                temp.children[idx] = new node();
            }

            temp = temp.children[idx];
        }

        temp.isEnd = true;
    }
    
    
    // search
    public  boolean search(String word) {
        node temp = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (temp.children[index] == null) {
                return false;
            } else {
                temp = temp.children[index];
            }
        }
       return true;
    }

    public int prefixSuffixString(String s1[],String s2[])
    {
        for (int i = 0; i < s1.length; i++) {
            StringBuffer st = new StringBuffer();
            st.append(s1[i]);
            insertion(st.toString());
            st.reverse();
            insertion(st.toString());
        }
        
        
        int count =0;
        for(int i=0;i<s2.length;i++){
            StringBuffer st = new StringBuffer();
            st.append(s2[i]);
            if(search(st.toString())){
                count++;
            }
            else{
                 st.reverse();
                 if(search(st.toString())){
                     count++;
                 }
            }
           
        }
        
        return count ;
        
    }
}