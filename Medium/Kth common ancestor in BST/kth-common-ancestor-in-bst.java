//{ Driver Code Starts
import java.io.*;
import java.math.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

public class GFG {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N')) return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the curr node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the curr node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length) break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the curr node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine().trim();
            Node root = buildTree(s);

            String[] snums = br.readLine().split(" ");
            int k = Integer.parseInt(snums[0]);
            int x = Integer.parseInt(snums[1]);
            int y = Integer.parseInt(snums[2]);

            Solution T = new Solution();
            // Call the function with the needed parameters
            System.out.println(T.kthCommonAncestor(root, k, x, y));

            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
      ArrayList<Integer> f = new ArrayList<>();
    boolean yt = true;
    void in (Node root,int n1){
        if(root==null){
            return ;
        }
        if(yt==true){
            f.add(root.data);
        }
        if(root.data==n1){
            yt=false;
        }
        in(root.left,n1);
        in(root.right,n1);
        
         if(f.contains(n1)==false){
            int s = f.size();
          
            f.remove(s-1);
           
        }
    }
    boolean y  = true;
    ArrayList<Integer> s = new ArrayList<>();
    
    void ink (Node root,int n2){
        if(root==null){
            return ;
        }
        if(y==true){
            s.add(root.data);
        }
        if(root.data==n2){
            y=false;
        }
        ink(root.left,n2);
        ink(root.right,n2);
        
         if(s.contains(n2)==false){
            int sx = s.size();
          
            s.remove(sx-1);
           
        }
    }
    public int kthCommonAncestor(Node root, int k, int n1, int n2) {
       	in(root,n1);
		ink(root,n2);
// 		int i=f.size()-1;
// 		int j= s.size()-1;
		int ans =0;


        Collections.reverse(f);
        Collections.reverse(s);
        ArrayList<Integer> hs = new ArrayList<>();
        //	System.out.println(s);
 		//System.out.println(f);
        for(int i=0;i<f.size();i++){
            int t  = f.get(i);
           // System.out.println(t);
            if(s.contains(t)){
                ans = t;
                hs.add(t);
            }
        }
       if(k>hs.size()){
           return -1;
       }
       int sd = hs.get(k-1);
       return sd;
    }
}
