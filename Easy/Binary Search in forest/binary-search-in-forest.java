//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG
{
    public static void main (String[] args)
	{
        Scanner in = new Scanner(System.in);
        
        int t = in.nextInt();
        while(t-->0)
        {
            int n = in.nextInt();
            
            int tree[]= new int[n];
            for(int i=0; i<n; i++)
                tree[i] = in.nextInt();
            int k = in.nextInt();
            
            Solution x = new Solution();
            System.out.println( x.find_height(tree,n,k) );
        }
	}
}
// } Driver Code Ends


class Solution
{
    public static int check(int tree[],int mid){
        int t = 0;
        for(int v:tree){
            
            if(v>mid){
                t = t+ (v-mid);
            }
        }
        
        return t;
    }
    static int find_height(int tree[], int n, int k)
    {
        int low =0;
        int high =0;
        Arrays.sort(tree);
        low = 0;
        high = tree[n-1];
        int ans =0;
        
        while(low<=high){
            int mid = (low+high)/2;
            int t = check(tree,mid);
            if(t==k){
                return mid;
            }
            if(t<k){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        
        return -1;
    }
}