//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        }
    }
}
// } Driver Code Ends




/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution
{
    public static Node addOne(Node hed) 
    { 
        //code here.
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        Node temp = hed;
        while(temp!=null){
            a.add(temp.data);
            temp = temp.next;
        }
        // temp = second ;
        
        // while(temp!=null){
        //     b.add(temp.data);
        //     temp = temp.next;
        // }
        b.add(1);
        int n = a.size();
        int m = b.size();
        ArrayList<Integer> arr = new ArrayList<>();
        
        int i= n-1;
        int j = m-1;
        int carry =0;
        
         while(i>=0&&j>=0){
             int v = a.get(i);
             int k = b.get(j);
             int s = v+k+carry;
             carry = s/10;
             s = s%10;
             arr.add(s);
             i--;
             j--;
         }
         
         while(i>=0){
             int s = a.get(i)+carry;
              carry = s/10;
             s = s%10;
             arr.add(s);
             i--;
             
         }
          while(j>=0){
             int s = b.get(j)+carry;
              carry = s/10;
             s = s%10;
             arr.add(s);
             j--;
             
         }
          while(carry!=0){
             int s =carry;
              carry = s/10;
             s = s%10;
             arr.add(s);
            
             
         }
    // Collections.reverse(arr);
      
         Node new_node = new Node(-1);
         Node point = new_node;
        for(int r=arr.size()-1;r>=0;r--){
            Node rt  = new Node(arr.get(r));
            point.next = rt;
            point = point.next;
        }
        
        return new_node.next;
        
        
    }
}
