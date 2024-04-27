//{ Driver Code Starts
import java.util.*;
import java.util.stream.*; 
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args)throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    String str = br.readLine();
		    String s1 = str.split(" ")[0];
		    String s2 = str.split(" ")[1];
		    
		    Solution obj = new Solution();
		    
		    if(obj.isAnagram(s1,s2))
		    {
		        System.out.println("YES");
		    }
		    else
		    {
		         System.out.println("NO");
		    }
		    
		    
		    
		}
	}
}
// } Driver Code Ends






class Solution
{    
    //Function is to check whether two strings are anagram of each other or not.
    public static boolean isAnagram(String a,String b)
    {
        int n= a.length();
        int m = b.length();
        char aa[] = new char [n];
for (int i=0;i<n;i++){
    aa[i] = a.charAt(i);
}

Arrays.sort(aa);
// String h ="";
// for (int i=0;i<n;i++){
//      h = h+aa[i];
// }

String string = new String(aa);
char ab[] = new char [m];
for (int i=0;i<m;i++){
    ab[i] = b.charAt(i);
}

Arrays.sort(ab);
// String hk ="";
// for (int i=0;i<m;i++){
//      hk = hk+ab[i];
// }

String str = new String(ab);
      
      
      boolean yt = false;
      if (string.equals(str)){
          yt = true;
      }
      else{
          yt = false;
        
      }
      
      return yt ;

    
    // char kk[] = new char[n];
    // for (int i=0;i<n;i++){
    //     char ch = a.charAt(i);
    //     kk[i]=ch;
    // }
    // Arrays.sort(kk);
     
    
     
//     char k[] = new char[m];
//     for (int i=0;i<m;i++){
//          char ch = b.charAt(i);
//          k[i]=ch;
//     }
//     Arrays.sort(k);
//     boolean yt = false;
//     for (int i=0;i<n;i++){
//         if (kk[i]!=k[i]){
//             yt = false;
//             break;
//         }
//         else{
//             yt = true;
//         }
//     }
    
    
    

//   return yt ;




























    }
}