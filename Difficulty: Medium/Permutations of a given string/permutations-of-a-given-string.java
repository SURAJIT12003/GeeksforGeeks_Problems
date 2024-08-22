//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    
    
    public void rec(String S,List<String>ans,HashSet<Integer>hs,String str){
        if(str.length()==S.length()){
            if(!ans.contains(str)){
                ans.add(str);
            }
            return;
        }
        for(int i=0;i<S.length();i++){
            if(!hs.contains(i)){
                hs.add(i);
                rec(S,ans,hs,str+S.charAt(i)); 
                hs.remove(i);
            }
        }
       
    }
    public List<String> find_permutation(String S) {
        // Code here
        List<String> ans = new ArrayList<>();
        rec(S,ans,new HashSet<>(),"");
        Collections.sort(ans);
        return ans ;
    }
}