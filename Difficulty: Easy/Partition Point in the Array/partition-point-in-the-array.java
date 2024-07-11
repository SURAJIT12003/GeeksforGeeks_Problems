//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

// Position this line where user code will be pasted.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            int n = Integer.parseInt(br.readLine());
            //            String line = br.readLine();
            //            String[] a2 = line.trim().split("\\s+");
            //            int n =Integer.parseInt(a2[0]);
            //            int m =Integer.parseInt(a2[1]);
            // int y =Integer.parseInt(a2[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
            Solution ob = new Solution();
            // ArrayList<Long> ans=ob.smallestDifferenceTriplet(a,b,c,n);
            long ans = ob.FindElement(a, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    long FindElement(long arr[], int N) {
        for(int i=0;i<N;i++){
            long curr = arr[i];
            int yt =0;
            for(int j=0;j<i;j++){
                if(curr<=arr[j]){
                    yt=1;
                    break;
                }
            }
            
            if(yt==1){
                continue;
            }
            
            for(int j=i+1;j<N;j++){
                //System.out.println(arr[j]+" "+curr);
                if(curr>=arr[j]){
                    yt=1;
                    break;
                }
            }
             if(yt==1){
                continue;
            }
            return arr[i];
        }
        
        return -1;
    }
}
