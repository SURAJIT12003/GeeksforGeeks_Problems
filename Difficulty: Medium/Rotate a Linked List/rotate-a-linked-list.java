//{ Driver Code Starts
// Initial Template for Java

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


// } Driver Code Ends




/* node of linked list:

class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}

*/

class Solution{
    //Function to rotate a linked list.
    public Node rotate(Node head, int k) {
        // add code here Node temp = head;
         ArrayList<Integer> arr = new ArrayList<>();
         Node temp = head;
         while (temp!=null){
             arr.add(temp.data);
             temp = temp .next ;
         }
         int n = arr.size();
         //System.out.println(arr);
          ArrayList<Integer> a = new ArrayList<>();
          for (int i=k;i<n;i++){
              a.add(arr.get(i));
               
          }
         
          for (int i=0;i<k;i++){
              a.add(arr.get(i));
          }
          // System.out.println(a);
          Node head3 = null;
          for (int i=0;i<a.size();i++){
              Node new_node = new Node (a.get(i));
              if (head3==null){
                  head3 = new_node;
              }
              else{
                  Node ptr = head3 ;
                  while (ptr.next!=null){
                      ptr = ptr .next ;
                  }
                  ptr .next = new_node;
              }
          }
          
          return head3;
          
    }
}


//{ Driver Code Starts.

public class GFG {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            if (!input.isEmpty()) {
                String[] numbers = input.split("\\s+");
                for (String num : numbers) {
                    if (!num.isEmpty()) {
                        arr.add(Integer.parseInt(num));
                    }
                }
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); ++i) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            head = ob.rotate(head, k);
            printList(head);
        }
    }
}

// } Driver Code Ends