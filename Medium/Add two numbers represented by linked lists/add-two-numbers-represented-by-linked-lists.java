//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node num1 = new Node(val);
            Node tail = num1;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node num2 = new Node(val);
            tail = num2;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);
        }
    }
}

// } Driver Code Ends




/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second){
        // code here
        // return head of sum list
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        Node temp = first;
        while(temp!=null){
            a.add(temp.data);
            temp = temp.next;
        }
        temp = second ;
        
        while(temp!=null){
            b.add(temp.data);
            temp = temp.next;
        }
        
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
         Collections.reverse(arr);
        Node heads = new Node(-1);
        Node rt = heads;
         
        int yt =0;
        for(int r=0;r<arr.size();r++){
            if( arr.get(r)==0 && yt==1){
                 Node new_node = new Node(arr.get(r));
                 heads.next = new_node;
                 heads = heads.next;
            }
            else if(arr.get(r)!=0){
                //System.out.println(arr.get(r));
                 Node new_node = new Node(arr.get(r));
                 heads.next = new_node;
                 heads = heads.next;
                 yt=1;
            }
            
        }
        if(heads.data==-1){
                 Node new_node = new Node(0);
                 heads.next = new_node;
                 heads = heads.next;
        }
        return rt.next;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}