import java.io.*;
public class DoubleLinkedList {
    PrintStream obj = System.out;
    Dnode head = new Dnode();
    Dnode tail = new Dnode();
    int len;
    DoubleLinkedList(int data)
    {
        Dnode startnode = new Dnode();
        startnode.data=data;
        head.next=startnode;
        tail=startnode;
        startnode.next=startnode.previous=null;
        ++len;
    }
    public void insertatbeginning(int data)
    {
        Dnode cuurentnode = newnode(data);
        cuurentnode.next=head.next;
        head.next.previous=cuurentnode;
        head.next=cuurentnode;
        ++len;
    }
    public void insertatend(int data)
    {
        Dnode newnode=newnode(data);
        Dnode temp=head.next;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=newnode;
        newnode.next=null;
        newnode.previous=temp;
        tail=newnode;
        ++len;
    }
    public void insertinbetween(int data,int loc)
    {
        Dnode temp=head;
        Dnode newnode = newnode(data);
        for(int i=1;i<=loc-1;i++)
        {
            temp=temp.next;
        }
        newnode.next=temp.next;
        newnode.previous=temp;
        temp.next.previous=newnode;
        temp.next=newnode;
        ++len;
    }
    public void deleteatstart()
    {
        head.next.previous=null;
        head.next=head.next.next;
        --len;
    }
    public void deleteatend()
    {
        Dnode temp=head;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp=temp.previous;
        temp.next=null;
        tail=temp;
        --len;
    }
    public void deleteatloc(int loc)
    {
        Dnode temp = head;
        for(int i=1;i<=loc-1;i++)
        {
            temp=temp.next;
        }
        temp.next.next.previous=temp;
        temp.next=temp.next.next;
        --len;
    }
    public void deleteDLL()
    {
        Dnode temp=head;
        for(int i=0;i<=len;i++)
        {
            temp.next=temp.previous=null;
        }
        head=null;
        tail=null;
    }
    public void search(int ele)
    {
        boolean flag=false;
        Dnode temp=head.next;
        for(int i=1;i<=len;i++)
        {
            if(temp.data==ele)
            {
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag==true)
            obj.println("Element found");
        else
            obj.println("Element not found");
    }
    public void display()
    {
        Dnode temp=head.next;
        for(int i=1;i<=len;i++)
        {
            obj.println(temp.data);
            temp=temp.next;
        }
        obj.println("No of nodes :"+len);
    }
    public void displayback()
    {
        Dnode temp=tail;
        while(temp.previous!=null)
        {
            System.out.println(temp.data);
            temp=temp.previous;
        }
        System.out.println("No of nodes :"+len);
    }
    private Dnode newnode(int data)
    {
        Dnode newnode = new Dnode();
        newnode.data = data;
        return newnode;
    }
}
