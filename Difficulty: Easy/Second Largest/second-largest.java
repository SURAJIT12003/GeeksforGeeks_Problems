//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = sc.nextLine();
            Scanner ss = new Scanner(input);
            while (ss.hasNextInt()) {
                arr.add(ss.nextInt());
            }
            Solution ob = new Solution();
            int ans = ob.print2largest(arr);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends



  


//User function Template for Java

class Solution {
    int print2largest(List<Integer>arr) {
      int n = arr.size();
        int max =0;
        for(int i=0;i<arr.size();i++){
            max = Math.max(max,arr.get(i));
        }
        int se = -1;
        for(int i=0;i<arr.size();i++){
            if(max>arr.get(i)){
                se = Math.max(se,arr.get(i));
            }
        }
        
        return se;
    }
}