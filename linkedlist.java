import java.util.*;

public class LinkedListDemo{
    Node head;
    class Node{
        int data;
        Node next;
        Node(int d){data =d; next = null;}
    }

    public void push(int new_data){
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    public void insertAfter(Node givenNode, int new_data){
        if(givenNode == null)
            System.out.println("Given node cannot be empty");

        Node new_node = new Node(new_data);
        new_node.next = givenNode.next;
        givenNode.next = new_node;
    }

    public void append(int new_data){
        Node new_node = new Node(new_data);
        if(head == null)
            head = new_node;

        else{
        Node last = head;

        while(last.next != null)
            last = last.next;

        last.next = new_node;
    }
    }

    public void printList(){
        Node temp = head;

        while(temp != null){
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
    }

    void deleteNode(int key){
        // Store head node
        Node temp = head, prev=null;
        // If head node itself holds the key or multiple occurrences of key
        while(temp != null && temp.data == key){
            head = temp.next;
            temp = head;
        }
        // Delete occurrences other than head
        while(temp != null){
            // Search for the key to be deleted, keep track of the
            // previous node as we need to change 'prev.next'
            while(temp != null && temp.data != key){
                prev = temp;
                temp = temp.next;
            }
            // If key was not present in linked list
            if(temp == null) return;
            // Unlink the node from linked list
            prev.next = temp.next;
            //Update Temp for next iteration of outer loop
            temp = prev.next;
        }
    }

     public static void main(String[] args){
         LinkedList llist = new LinkedList();

         llist.push(6);
         llist.append(7);
         llist.append(7);
         llist.append(7);
         llist.append(9);
         llist.push(10);
         llist.deleteNode(7);
         llist.printList();
     }
}