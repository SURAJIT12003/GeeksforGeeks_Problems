//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // int arr[] = new int[10000];
        
        int t = sc.nextInt();
        
        while(t-->0)
        {
            int n = sc.nextInt();
            int arr[]=new int[n];
            for(int i=0; i<n; i++)
            {
                arr[i] = sc.nextInt();
            }
            
            solver x = new solver();
            int res[]=x.print_next_greater_freq(arr,n);
            StringBuffer sb=new StringBuffer("");
            for(int i : res){
                sb.append(i+" ");
            }
            System.out.println(sb);
        }
    }
}

// } Driver Code Ends

class pair{
    int data;
    int fre;
    public pair(int d,int f){
        this.data = d;
        this.fre  = f;
    }
}


class solver
{
    static int[] print_next_greater_freq(int arr[], int n)
    {
        HashMap<Integer,Integer> hs = new HashMap<>();
        
        for(int i=0;i<n;i++){
            int t = arr[i];
            if(hs.containsKey(t)){
                int g = hs.get(t);
                g++;
                hs.put(t,g);
            }
            else{
                hs.put(t,1);
            }
        }
        
        int ans[]  = new int [n];
        Stack<pair> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            int el = arr[i];
            int fr = hs.get(el);
            
            if(st.isEmpty()){
                 st.push(new pair(el,fr));
                 ans[i] = -1;
            }
            else{
                int yt =0;
                while(!st.isEmpty()){
                    int fr1 = st.peek().fre;
                    if(fr<fr1){
                        yt = 1;
                        ans[i] = st.peek().data;
                        break;
                    }
                    st.pop();
                }
                
                if(yt==0){
                    ans[i] = -1;
                }
                st.push(new pair(el,fr));
            }
        }
        
        
        return ans;
    }
}

