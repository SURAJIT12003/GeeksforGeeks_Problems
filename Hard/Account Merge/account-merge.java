//{ Driver Code Starts
//Initial Template for Java

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
      List<List<String>> accounts=new ArrayList<>();
      for (int i = 0; i < n; i++)
       {
        ArrayList<String> temp=new ArrayList<>();
        int x=sc.nextInt();
        for(int j = 0; j < x; j++)
           {
             String s1=sc.next();
             temp.add(s1);
           }
        accounts.add(temp);
       }
      Solution obj = new Solution();
      List<List<String>> res = obj.accountsMerge(accounts);
      Collections.sort(res, new Comparator<List<String>>() {
                @Override   public int compare(List<String> a,
                                              List<String> b) {
                    int al = a.size();
                    int bl = b.size();
                    int min = Math.min(al, bl);
                    for (int i = 0; i < min; i++) {
                        String xx=a.get(i);
                        String yy=b.get(i);
                        if (xx.compareTo(yy)<0)
                            return -1;
                        else if (xx.compareTo(yy)>0)
                            return 1;
                    }
                    if (al < bl)
                        return -1;
                    else if (al > bl)
                        return 1;
                    return -1;
                }
            });
      System.out.print("[");
      for (int i = 0; i < res.size(); ++i)
        {
          System.out.print("[");
          for (int j = 0; j < res.get(i).size(); j++)
             {
                if (j != res.get(i).size() - 1)
                     System.out.print(res.get(i).get(j)+", ");
                else
                     System.out.print(res.get(i).get(j));
             }
          if (i != res.size() - 1)
             System.out.println("], ");
          else
             System.out.print("]");
        }
       System.out.println("]");
    }
  }
}

// } Driver Code Ends




//User function Template for Java

class Solution {
    
     public static void union(int parrent[], int i, int j,int size[]) {

        //Step - 1 parrent findParrent when value is similar it's parrent then stop 
        int t = findParrent(i, parrent);
       

        // //Same parrent findParrent 
        int tk =findParrent(j, parrent);
        
        int r1 = size[i];
        int r2 = size[j];
        
        if (r1 >= r2) {
           // System.out.println(j+" "+i);
            parrent[tk] = t;
            r1=r1+r2;
            size[t] = r1;
        } 
        //if r2 rank is greater then connect with r2 
        else {
            parrent[t] = tk;
            r2=r2+r1;
            size[tk] = r2;
        }


        
    }


    //findParrent - findParrent which is the parrent 
    public static int  findParrent(int i,int parrent[]){
        int t = parrent[i];
        if(i==t){
            return i;
        }

        int par = findParrent(t, parrent);
        parrent[i]  = par;
        return par;
       
    }
    
  static List<List<String>> accountsMerge(List<List<String>> account) {
      
      int n = account.size();
      int parrent[] = new int [n];
      for (int i = 0; i < n; i++) {
            parrent[i] = i;
       }
       int size[] = new int [n];
       Arrays.fill(size,1);
       HashMap<String,Integer> hs = new HashMap<>();
       for(int i=0;i<account.size();i++){
           int par = i;
           for(int j=1;j<account.get(i).size();j++){
               String s = account.get(i).get(j);
               if(hs.containsKey(s)){
                   int g = hs.get(s);
                   union(parrent,g,i,size);
               }
                else{
                     hs.put(s,i);
                }
               
               
           }
       }
     
      List<List<String>> ans = new ArrayList<>();
      
      TreeMap<Integer, TreeSet<String> > ts = new TreeMap<>();
      
      for(String v:hs.keySet()){
          
          int g = hs.get(v);
          int par = findParrent(g,parrent);
          if(ts.containsKey(par)){
              TreeSet<String> a = ts.get(par);
              a.add(v);
              ts.put(par,a);
          }
          else{
              TreeSet<String> a = new TreeSet<>();
              a.add(v);
              ts.put(par,a);
          }
         
      }
      
      for(int i:ts.keySet()){
          TreeSet<String> a = ts.get(i);
          List<String> f = new ArrayList<>();
          String head = account.get(i).get(0);
          f.add(head);
          for(String c:a){
              f.add(c);
          }
          ans.add(f);
      }
       return ans ;
       

  }
}
     