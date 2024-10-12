//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            int[] ans = new Solve().findTwoElement(arr);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[]) {
       
      int fre[] = new int [arr.length+1];
     
       for(int i=0;i<arr.length;i++){
           int t  = arr[i];
           if(fre[t]!=0){
               int f = fre[t];
               f++;
               fre[t] = f;
           }
           else{
               fre[t] = 1;
           }
       }
       
       
       int mis = 0;
       for(int i=1;i<=arr.length;i++){
           if(fre[i]==0){
               mis = i;
               break;
           }
       }
       
       int dou =0;
       for(int i=1;i<fre.length;i++){
           if(fre[i]==2){
               dou = i;
           }
       }
       
       int ans [] = new int [2];
       ans[0]  = dou;
       ans[1]  = mis;
       return ans ;
    }
}
