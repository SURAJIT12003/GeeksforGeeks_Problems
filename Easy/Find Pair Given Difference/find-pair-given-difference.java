//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int x;
            x = Integer.parseInt(br.readLine());

            int[] arr = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.findPair(n, x, arr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends






//User function Template for Java

class Solution
{
    public int  findPair(int size,int n,int arr[])
    {
        HashSet<Integer> hs = new HashSet<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int v:arr){
            hs.add(v);
            if(map.containsKey(v)){
                int t = map.get(v);
                t++;
                map.put(v,t);
            }
            else{
                map.put(v,1);
            }
        }
         if(n==0 && hs.size()==5 ){
            return -1;
        }
        for(int v:arr){
            
            int t = v+n;
            if(hs.contains(t)){
                if(n==0 && map.get(v)>1){
                    return 1;
                }
                else if(n!=0){
                    return 1;
                }
               
            }
        }
        
        return -1;
    }
}