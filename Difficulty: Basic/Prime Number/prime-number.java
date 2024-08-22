//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.isPrime(N));
        }
    }
}
// } Driver Code Ends


class Solution{
    static int isPrime(int number){
         if(number==1 || number==0){
            return 0;
        }
        if(number==2){
            return 1 ;
        }

        for(int i=2;i<=Math.sqrt(number);i++){
            if(number%i==0){
                return 0;
            }
        }

        return 1;
    }
}