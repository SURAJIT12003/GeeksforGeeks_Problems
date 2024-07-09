//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int key = Integer.parseInt(in.readLine().trim());

            out.println(new Solution().threeSumClosest(arr, key));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int threeSumClosest(int[] A, int X) {
        
       Arrays.sort(A);
       
       boolean yt = true;
       int n = A.length;
       int maxAbs = Integer.MAX_VALUE;
       int maxAns =Integer.MIN_VALUE;
       
       for(int i=0;i<n;i++){
           
           int lo = i+1,hi = n-1;
           while(lo<hi){
               int current = A[i]+A[lo]+A[hi];
               if(current==X){
                   return current;
               }
               if(current<X){
                   lo++;
                   int t = Math.abs(current-X);
                    if(t<maxAbs){
                       maxAns = current;
                       maxAbs = t;
                   }
                   else if(t<=maxAbs){
                       maxAns = Math.max(maxAns,current);
                   }
                   
                   
               }
               else{
                   int t = Math.abs(current-X);
                   if(t<maxAbs){
                       maxAns = current;
                       maxAbs = t;
                   }
                   else if(t<=maxAbs){
                       maxAns = Math.max(maxAns,current);
                   }
                   hi--;
               }
               
           }
           
       }
       
       return maxAns;
    
    }
}
