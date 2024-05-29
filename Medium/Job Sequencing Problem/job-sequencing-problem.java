//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job A[], int n)
    {
        int arr[][] = new int[n][3];
        int maxDeadline = 0;
        for(int i=0;i<n;i++){
            Job t = A[i];
            arr[i][0] = t.id;
            arr[i][1] = t.deadline;
            arr[i][2] = t.profit;
            maxDeadline = Math.max(maxDeadline,t.deadline);
        }
        
        int check[] = new int [maxDeadline+1];
        int c =0;
        int profit = 0;
        Arrays.fill(check,-1);
        
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[2], o1[2]); // Compare the third column (index 2)
            }
        });
        
        for(int i=0;i<n;i++){
            int t = arr[i][2];
            int in = arr[i][1];
            if(check[in]==-1){
                c++;
                profit+=t;
                check[in] = in;
            }
            else{
                while(in>=1 && check[in]!=-1){
                    in--;
                }
                if(in>=1){
                    check[in] = in;
                    c++;
                    profit+=t;
                }
            }
           // System.out.println(c+" "+profit+" "+in);
        }
        
        int ans [] = new int [2];
        ans[0] = c;
        ans[1] = profit;
        return ans; 
        
        
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/