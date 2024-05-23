//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] nums = IntArray.input(br, n);
            
            
            int k;
            k = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.countSubarray(n, nums, k);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int countSubarray(int n, int[] arr, int k) {
      for(int i=0;i<arr.length;i++){
           if(arr[i]%2==0){
            arr[i] = 0;
           } 
           else{
            arr[i]  = 1;
           }
        }
        HashMap<Integer,Integer> hs = new HashMap<>();
        hs.put(0,1);
        int sum=0;
        int ans =0;
        int N = arr.length;
        for(int i=0;i<N;i++){
        
            sum=sum+arr[i];  
            int t = sum-k;
            if(hs.containsKey(t)){
                ans = ans+hs.get(t);
            }
            if(hs.containsKey(sum)){
                int get = hs.get(sum);
                get=get+1;
                hs.put(sum,get);
            }
            else{
                hs.put(sum,1);
            }
        }
        
        return ans;
    }
}
        
