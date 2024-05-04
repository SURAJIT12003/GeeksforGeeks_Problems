//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.charAt(0) == 'N') return null;

        // Creating array of Strings from input
        // String after spliting by space
        String ip[] = str.split(" ");

        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));

        // Push the root to the queue
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // Starting from the second element
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static Node inputTree(BufferedReader br) throws IOException {
        return buildTree(br.readLine().trim());
    }

    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int target;
            target = Integer.parseInt(br.readLine());

            Node root = Node.inputTree(br);

            Solution obj = new Solution();
            int res = obj.minSubtreeSumBST(target, root);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    static int ans  = Integer.MAX_VALUE;
    
    public static boolean check(Node root,int left,int right){
        if(left==right){
            return true;
        }
        if(root==null){
            return true;
        }

        if(left>=root.data || root.data>=right){
            return false;
        }
        boolean l = check(root.left,left,root.data);
        boolean r = check(root.right,root.data,right);
        if(l==false || r==false){
            return  false;
        }
        return true;


    }
    public static int total(Node root){
        if(root==null){
            return 0;
        }
        int left = total(root.left);
        int right = total(root.right);
        return left+right+root.data;
        
    }
    
    public static int count(Node root){
        if(root==null){
            return 0;
        }
        int left = count(root.left);
        int right = count (root.right);
        return left+right+1;
    }

    public static void rec(Node root,int target){
        if(root==null){
            return;
        }
      
        boolean bst = check(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
        if(bst){
            int sum = total(root);
            if(sum==target){
                int number = count(root);
                ans = Math.min(ans,number);
            }
        }
        rec(root.left,target);
        rec(root.right,target);
    }
    public static int minSubtreeSumBST(int target, Node root) {
        rec(root,target);
        int ff = ans;
        ans = Integer.MAX_VALUE;
        if(ff==Integer.MAX_VALUE){
            return -1;
        }
        return ff;
    }
}
