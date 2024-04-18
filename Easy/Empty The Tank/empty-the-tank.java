//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int c = Integer.parseInt(read.readLine());
            int l = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.minDaysToEmpty(c, l));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static long minDaysToEmpty(long C, long l) {
        // code here
        long main = C;
        long ans =0;
        long index = 1;
        while(true){
            long t = C-index;
            if(t<=0){
                return index;
            }
            index++;
            C=t+l;
            if(C>main){
                C = main;
            }
        }
        
       // return -1;
    }
}