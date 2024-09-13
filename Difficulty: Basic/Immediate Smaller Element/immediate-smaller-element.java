//{ Driver Code Starts
//Initial Template for Java




import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().immediateSmaller(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    void immediateSmaller(int arr[], int n) {
        // code here
        Stack<Integer>st = new Stack<>();
        int ans[] = new int [n];
        for(int i=n-1;i>=0;i--){
            if(st.isEmpty()){
                st.push(arr[i]);
                ans[i] = -1;
            }
            else{
                while(!st.isEmpty() && st.peek()>=arr[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    ans[i] = -1;
                }
                else{
                    ans[i] = st.pop();
                }
                st.push(arr[i]);
            }
        }
        
        for(int i=0;i<n;i++){
            arr[i] = ans[i];
        }
    }
}