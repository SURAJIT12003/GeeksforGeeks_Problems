//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main(String[] args) throws IOException{
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		while(t-->0)
		{
		    int n=sc.nextInt();
		    sc.nextLine();
		    Solution obj = new Solution();
		    String arr[]=sc.nextLine().split(" ");
		    System.out.println(obj.mostFrequentWord(arr, n));
		    
		}
	}
}

// } Driver Code Ends
//User function Template for Java


class Solution
{
    //Function to find most frequent word in an array of strings.
    public String mostFrequentWord(String arr[],int n)
    {
        HashMap<String ,ArrayList<Integer> > hs = new HashMap<>();
        
        for(int i=0;i<n;i++){
            String s = arr[i];
            if(hs.containsKey(s)){
                ArrayList<Integer> d = hs.get(s);
                int t = d.get(1);
                t++;
                d.set(1,t);
                hs.put(s,d);
            }
            else{
                 ArrayList<Integer> d = new ArrayList<>();
                 d.add(i);
                 d.add(1);
                 hs.put(s,d);
            }
        }
        
        String ans ="";
        int max =0;
        int index =0;
        for(String s:hs.keySet()){
             ArrayList<Integer> d  = hs.get(s);
             if(d.get(1)>max){
                 max = d.get(1);
                 ans=s;
                 index = d.get(0);
             }
             else if(max==d.get(1)){
                 int newindex = d.get(0);
                 if(newindex>index){
                     index = newindex;
                     ans=s;
                 }
             }
        }
        
        return ans;
    }

}


//{ Driver Code Starts.
// } Driver Code Ends