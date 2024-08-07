//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;


class Array {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		  
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling trappingWater() function
		    System.out.println(obj.trappingWater(arr, n));
		}
	}
}


// } Driver Code Ends


class Solution{
    
    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int arr[], int n) { 
       
       long ans =0;
       int left[]  = new int [n];
       int right[] = new int [n];
       int max =0;
       for(int i=0;i<n;i++){
           if(max<arr[i]){
               max = arr[i];
               left[i] = max;
           }
           else{
               left[i] = max;
           }
       }
       
       max =0;
       
       for(int i=n-1;i>=0;i--){
           if(max<arr[i]){
               max = arr[i];
               right[i] = max;
           }
           else{
               right[i] = max;
           }
       }
       
       for(int i=0;i<n;i++){
           int l = left[i];
           int r = right[i];
           int min = Math.min(l,r);
           int t = min-arr[i];
           ans+=t;
       }
       
       return ans;
       
       
    } 
}


