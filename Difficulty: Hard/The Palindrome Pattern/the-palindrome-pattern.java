//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input_line[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(input_line[0]);
            String input_line1[] = read.readLine().trim().split("\\s+");
            int[][] a = new int[n][n];
            int c = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = Integer.parseInt(input_line1[c]);
                    c++;
                }
            }
            String ans = ob.pattern(a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution{
    boolean check (ArrayList<Integer> list){
        int size = list.size();
        for (int i = 0; i < size / 2; i++) {
            if (!list.get(i).equals(list.get(size - i - 1))) {
                return false;
            }
        }
        return true;
    }
    String pattern(int [][]a){
        // Code here
        int N = a.length;
        boolean yt = false;
        for(int i=0;i<N;i++){
            ArrayList<Integer> arr = new ArrayList<>();
            for(int j=0;j<N;j++){
                arr.add(a[i][j]);
            }
            if(check(arr)){
                String str="";
                str=str+i;
                str=str+" ";
                str=str+"R";
                return str ;
            }
        }
        
        
        for(int i=0;i<N;i++){
            ArrayList<Integer> arr = new ArrayList<>();
            for(int j=0;j<N;j++){
                arr.add(a[j][i]);
            }
            if(check(arr)){
                String str="";
                str=str+i;
                str=str+" ";
                str=str+"C";
                return str ;
            }
        }
        
        return "-1";
    }
    
}
