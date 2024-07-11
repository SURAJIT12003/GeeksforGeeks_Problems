//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            int X = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.closest3Sum(Arr, N, X));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int closest3Sum(int A[], int n, int X)
    {
          // Your code Here
       Arrays.sort(A);
       
       boolean yt = true;
       //int n = A.length;
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