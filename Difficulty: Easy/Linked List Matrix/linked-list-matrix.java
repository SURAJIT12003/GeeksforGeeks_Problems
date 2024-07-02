//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.Scanner;
class Node
{
    int data;
    Node right,down;
    
    Node(int data){
        this.data = data;
        right = null;
        down = null;
    }
}
public class Linked_list_2D_Matrix {
 
    // node of linked list
 
    static void display(Node head) {
         
        Node Rp;
    	Node Dp = head;
    	while (Dp != null) {
    		Rp = Dp;
    		while (Rp != null) {
    			System.out.print(Rp.data + " ");
    			if(Rp.right != null) System.out.print(Rp.right.data + " ");
    			else System.out.print("Null ");
    			if(Rp.down != null)System.out.print(Rp.down.data + " ");
    			else System.out.print("Null ");
    			Rp = Rp.right;
    		}
    		
    		Dp = Dp.down;
    	}
    }
 
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
        int n=sc.nextInt();
        int [][]arr=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++){
            int p=sc.nextInt();arr[i][j]=p;}
        }
        GFG obj=new GFG();
        Node head = obj.construct(arr, n);
        display(head);
        System.out.println();
        }
    }
 
}
// } Driver Code Ends


//User function Template for Java

 /*class Node

class Node
{
    int data;
    Node right,down;
    
    Node(int data){
        this.data = data;
        right = null;
        down = null;
    }
}
*/
/*Function should return the head of the 2D LL.*/
class GFG
{
    static Node construct(int arr[][],int n)
    {
       Node head = null;
       Node temp = null;
       Node ptr  = null;
       for(int i=0;i<n;i++){
           
           if(i==0){
                ptr = new Node(arr[i][0]);
                temp = ptr;
                head = temp;
           }
       
          
           for(int j=0;j<n;j++){
               if(j+1<n){
                   Node newNode = new Node(arr[i][j+1]);
                   ptr.right = newNode;
               }
               if(i+1<n){
                    Node newNode = new Node(arr[i+1][j]);
                    ptr.down = newNode;
               }
               if(ptr.right!=null){
                   ptr = ptr.right;
               }
               
           }
           if(temp.down!=null){
               temp = temp.down;
               ptr = temp;
              // System.out.println(ptr.data);
           }
           
       }
       return head;
       
    }
}