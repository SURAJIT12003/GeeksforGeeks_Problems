//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GFG {
    Node head;
    Node tail;

    public void addToTheLast(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Drier program to test above functions */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            GFG llist = new GFG();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < N; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }

            Solution ob = new Solution();
            head = ob.removeAllDuplicates(llist.head);
            llist.printList(head);

            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
    public Node removeAllDuplicates(Node head) {
       TreeMap<Integer,Integer> map = new TreeMap<>();
       
       Node temp = head;
       while(temp!=null){
           int t  = temp.data;
           int g = map.getOrDefault(t,0);
           g++;
           map.put(t,g);
           temp = temp.next;
       }
       
        head = null;
        temp = null;
        temp = new Node(-1);
       head = temp;
       
       for(int v:map.keySet()){
           if(map.get(v)==1){
               Node f = new Node(v);
               temp.next = f;
               temp = temp.next;
               
           }
       }
       
       return head.next;
       
    }
}