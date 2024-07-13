//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int[] ans = new Solve().getStarAndSuperStar(arr, n);
            for (int i = 1; i < ans.length; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            System.out.println(ans[0]);
        }
    }
}
// } Driver Code Ends


//User function Template for Java




class Solve {
    public static int[] getStarAndSuperStar(int[] arr, int n) {
       
        ArrayList<Integer> hs = new ArrayList<>();
        int max = arr[n-1];
        hs.add(n-1);
        for(int i=n-2;i>=0;i--){
           if(max<arr[i]){
               hs.add(i);
               max = arr[i];
           }   
        }
        
        max =arr[0];
        int sp =-1;
        if(hs.contains(0)){
            sp=arr[0];
        }
       // System.out.println(hs);
        for(int i=1;i<n;i++){
            if(max<arr[i]){
                if(hs.contains(i)){
                    sp= arr[i];
                    break;
                }
                max = arr[i];
            }
        }
        Collections.reverse(hs);
        int ans [] = new int [hs.size()+1];
        ans[0] = sp;
        int c=1;
        for(int v=0;v<hs.size();v++){
            ans[c] = arr[hs.get(v)];
            c++;
        }
        
        return ans;
        
    }
}
