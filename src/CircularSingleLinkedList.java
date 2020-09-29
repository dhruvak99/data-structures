import java.io.*;
import java.lang.System;
public class CircularSingleLinkedList {
    node head = new node();
    node tail = new node();
    int len;
    CircularSingleLinkedList(int data)
    {
        node firstnode = newnode(data);
        head.next = firstnode;
        tail = firstnode;
        firstnode.next = firstnode;
        ++len;
    }
    public void insertatstart(int data)
    {
        node newnode = newnode(data);
        newnode.next=head.next;
        head.next = newnode;
        node temp;
        temp=head;
        while(temp.next!=head.next)
        {
            temp=temp.next;
        }
        temp.next= newnode;
        ++len;
    }
    public void insertatend(int data)
    {
        node newnode = newnode(data);
        node temp = head.next;
//        do{
//            temp=temp.next;
//        }while(temp.next!=head.next);
        for(int i=1;i<=len;i++)
            temp=temp.next;
        temp.next=newnode;
        newnode.next=head.next;
        ++len;
    }
    public void insertatloc(int data,int loc)
    {
        node newnode = newnode(data);
        node temp=head;
        for(int i=1;i<loc;i++)
        {
            temp=temp.next;
        }
        node temp2 = temp.next;
        temp.next=newnode;
        newnode.next=temp2;
        ++len;
    }
    public void deleteatstart()
    {
        head.next = head.next.next;
        node temp=head;
        do {
            temp=temp.next;
        }while(temp.next!=head.next);
        temp.next=head.next;
        --len;
    }
    public void deleteatend()
    {
        node temp=head;
        for(int i=1;i<len;i++)
        {
            temp=temp.next;
        }
        temp.next=head.next;
        tail = temp;
        --len;
    }
    public void deleteatloc(int loc)
    {
        node temp=head;
        for(int i=0;i<loc-1;i++)
        {
            temp=temp.next;
        }
        temp.next=temp.next.next;
        --len;
    }
    public void deleteLL()
    {
        head=null;
    }
    public void display()
    {
        if(head==null)
        {
            System.out.println("Linked List empty");
        }
        else
        {
            node temp = head.next;
            for(int i=1;i<=len;i++)
            {
                System.out.println(temp.getData());
                temp=temp.next;
            }
            System.out.println("No of nodes "+len);
        }
    }
    public void search(int ele)
    {
        boolean flag=false;
        PrintStream obj = System.out;
        if(head==null)
            obj.println("Linked list empty");
        else
        {
            node temp=head.next;
           for(int i=1;i<=len;i++){
                if(temp.data==ele) {
                    flag = true;
                    break;
                }
               temp=temp.next;
            }
        }
        if(flag==true)
            obj.println("Element found");
        else
            obj.println("Element Not found");
    }
    private node newnode(int data)
    {
        node newnde = new node();
        newnde.data=data;
        return newnde;
    }
}
