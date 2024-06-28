//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class ReverseInSize
{
    static Node head;
    
    public static void main (String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int a1 = Integer.parseInt(s[0]);
            Node head = new Node(a1);
            Node tail = head;
            for(int i = 1; i < n; i++)
            {
                int a = Integer.parseInt(s[i]);
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail =tail.next;
            }
            
            int k = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            Node res = ob.reverse(head, k);
            printList(res,out);
            out.println();
        }
        out.close();
    }
    
    public static void printList(Node node,PrintWriter out)
    {
        while(node != null)
        {
            out.print(node.data + " ");
            node = node.next;
        }
    }
    
}


// } Driver Code Ends


/*node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution
{
    
     public static  Node reverseList(Node head)
    {
        // code here
        Node teemp = head;
        Node prev = null;
        while(teemp!=null){
            Node front = teemp.next;
            teemp.next=prev;
            prev= teemp;
            teemp = front;
        }
        
        
        return prev; // prev will be pointing to the new head of the reversed linked list 
    }
    public static Node getkthnode(Node temp,int k){
        k-=1; // one already decreased 
        while(temp!=null && k>0){
            k--;
            temp=temp.next;
        }
        
        return temp ; // returning the kth node 
    }
     public static Node reverse(Node node, int k) {
            Node head = node;
            Node temp = node;
            Node prevLast = null;
            while (temp != null) {
                Node kthNode = getkthnode(temp, k);
                Node nextnode = null;
                if (kthNode != null) {
                      nextnode = kthNode.next;
                      kthNode.next = null;
                }
                
                Node newHead = reverseList(temp);
                if (prevLast == null) {
                    head = newHead;
                } else {
                    prevLast.next = newHead;
                }
                prevLast = temp;
                temp = nextnode;
            }
            return head;
        }
}