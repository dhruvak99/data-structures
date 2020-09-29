import java.io.*;
public class SingleLinkedList {
    node head = new node() ;
    node tail = new node();
    int len;

    SingleLinkedList(int data)
    {
        node newnode = newnode(data);
        head.next = newnode;
        tail = newnode;
        ++len;
    }
   public void insert(int data)
    {
        node currentnode = newnode(data);
        currentnode.next = null;
        node temp;
        temp = head;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next = currentnode;
        tail = currentnode;
        ++len;
    }
   public void insertatstart(int data)
    {
        node currentnode = newnode(data);
        node temp;
        temp = head.next;
        head.next = currentnode;
        currentnode.next = temp;
        ++len;
    }
    public void insertinbetween(int data,int loc)
    {
        node curentnode = newnode(data);
        node temp=head;
        for(int i=1;i<loc;i++)
        {
            temp = temp.next;
        }
        node temp2=temp.next;
        temp.next=curentnode;
        curentnode.next = temp2;
        ++len;
    }
   public void deletenodeatstart()
    {
            node temp=head.next;
            head = temp;
            --len;
    }
   public void deletenodeatend()
    {
        node temp;
        temp = head;
        for(int i=1;i<len;i++)
        {
            temp=temp.next;
        }
        temp.next=null;
        tail = temp;
        --len;
    }
    public void deleteatlocation(int loc)
    {
        node temp = head;
        for(int i=0;i<loc-1;i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        --len;
    }
    public void deleteLL()
    {
        head=null;
    }
   public void display() {
       if (head == null) {
           System.out.println("Linked List empty");
       } else {
           node temp;
           temp = head.next;
           while (temp.next!= null) {
               System.out.println(temp.getData());
               temp = temp.next;
           }
           System.out.println("no of nodes : " + len);
       }
   }
    public void search(int value)
    {
        node temp ;
        temp= head.next;
        boolean flag=false;
        while(temp!=null)
        {
            if(temp.getData()==value)
            {
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag==true)
        {
            System.out.println("Value found");
        }
        else
        {
            System.out.println("Value not found");
        }
    }
    private node newnode(int data)
    {
        node newnode1 = new node();
        newnode1.data = data;
        return newnode1;
    }
}
