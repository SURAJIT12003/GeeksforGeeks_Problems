//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String val[] = in.readLine().trim().split("\\s++");
            int N = Integer.parseInt(val[0]);
            int K = Integer.parseInt(val[1]);
            String arr[] = in.readLine().trim().split("\\s++");
            int[] A = new int[N];
            for(int i = 0;i < N; i++)
                A[i] = Integer.parseInt(arr[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maxAmount(N, K, A));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxAmount(int N, int k, int A[])
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int v:A){
            pq.add(v);
        }
        //System.out.println(pq);
        int sum =0;
        while(k!=0){
            sum+=pq.peek();
            sum= sum%1000000007;
            int t = pq.peek();
            pq.poll();
            t--;
            pq.add(t);
            k--;
        }
        return sum ;
    }
}