//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().majorityElement(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int majorityElement(int arr[]) {
        // your code here
        HashMap<Integer,Integer> hs = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int g = arr[i];
            if(hs.containsKey(g)){
                int t = hs.get(g);
                t++;
                hs.put(g,t);
            }
            else{
                hs.put(g,1);
            }
        }
        
        int max =0;
        int ans =-1;
        for(int v:hs.keySet()){
           if(hs.get(v)>arr.length/2){
               ans = v;
           }
        }
        
        return ans;
    }
}