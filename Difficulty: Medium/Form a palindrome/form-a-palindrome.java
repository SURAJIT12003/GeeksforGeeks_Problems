//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.countMin(str));
        }
    } 
} 
// } Driver Code Ends




//User function Template for Java

class Solution{
     public static int rec(String s1,String s2,int i1,int i2,int dp[][]){
	    if(i1==0 || i2==0){
			return 0;
		}

		if(dp[i1][i2]!=-1){
			return dp[i1][i2];
		}

		//Matching 
		int match =0;
		if(s1.charAt(i1-1)==s2.charAt(i2-1)){
			match =  1+rec(s1,s2,i1-1,i2-1,dp);
			dp[i1][i2]  = match;
			return match;
			
		}
		


		//Not Matching 
		int one = 0+rec(s1,s2,i1-1,i2,dp);
		int two = 0+rec(s1,s2,i1,i2-1,dp);
		int max =Math.max(one ,two);
		
		dp[i1][i2] = max;
		
		return max;
	}
    static int countMin(String str)
    {
         //LPS (longest palindrome subsequence)
        StringBuffer str2 = new StringBuffer();
		str2.append(str);
		str2.reverse();
		int n = str.length();
		int m = str.length();
		
		
		int dp[][] = new int [n+1][m+1];

		for (int i = 0; i <=n; i++) {
            for (int j = 0; j <=m; j++) {
                dp[i][j] = -1;
            }
        }

		int t = rec(str,str2.toString(),n,m,dp);
    
    	//add this work only 
        return n-t;
    }
}