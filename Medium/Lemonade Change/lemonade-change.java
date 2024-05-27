//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.lemonadeChange(n, a);
            System.out.println(ans ? "True" : "False");
        }
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    static boolean lemonadeChange(int N, int bills[]) {
        // code here
        TreeMap<Integer,Integer> ts  = new TreeMap<>();
        
        for(int i=0;i<N;i++){
            int t = bills[i];
            //System.out.println(ts);
            if(t==5){
                if(ts.containsKey(t)){
                    int g = ts.get(t);
                    g++;
                    ts.put(t,g);
                }
                else{
                    ts.put(t,1);
                }
            }
            else if(t==10){
                
                if(ts.containsKey(5)){
                    int g = ts.get(5);
                    if(g>0){
                        g--;
                        ts.put(5,g);
                    }
                    else{
                        return false;
                    }
                }
                else{
                    return false;
                }
                
                //update
                if(ts.containsKey(t)){
                    int g = ts.get(t);
                    g++;
                    ts.put(t,g);
                }
                else{
                    ts.put(t,1);
                }
                
            }
            else{
                
                if( ts.containsKey(5) || ts.containsKey(10) ){
                    int yt=0;
                    if( ts.containsKey(5) && ts.containsKey(10) ){
                    
                        int g = ts.get(5);
                        int k =ts.get(10);
                        if(g>0 && k>0){
                            g--;
                            k--;
                            yt=1;
                            ts.put(5,g);
                            ts.put(10,k);
                        }
                    }
                     
                    if(yt==0){
                        if(ts.containsKey(5)){
                             int g = ts.get(5);
                             
                             if(g>=3 ){
                              g=g-3;
                              ts.put(5,g);
                              yt=1;
                            }
                        }
                    }
                    
                    if(yt==0){
                        return false;
                    }
                    
                }
                     
                else{
                    return false;
                }
                
                
                 //update
                if(ts.containsKey(t)){
                    int g = ts.get(t);
                    g++;
                    ts.put(t,g);
                }
                else{
                    ts.put(t,1);
                }
                
            }
        }
        
        return true ;
    }
}
