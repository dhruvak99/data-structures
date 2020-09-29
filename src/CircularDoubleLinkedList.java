import java.io.*;
public class CircularDoubleLinkedList {
    Dnode head = new Dnode();
    Dnode tail = new Dnode();
    int len;
    PrintStream obj = System.out;
    CircularDoubleLinkedList(int data)
    {
        Dnode firstnode = newnode(data);
        head.next=firstnode;
        tail=firstnode;
        firstnode.next=firstnode.previous=firstnode;
        ++len;
    }
    public void insertatstart(int data)
    {
        Dnode newnode=newnode(data);
        newnode.next=head.next;
        head.next.previous=newnode;
        newnode.previous=tail;
        head.next=newnode;
        ++len;
    }
    public void insertatend(int data)
    {
        Dnode newnode=newnode(data);
        head.next.previous=newnode;
        newnode.next=head.next;
        Dnode temp=tail;
        temp.next=newnode;
        newnode.previous=temp;
        tail=newnode;
        ++len;
    }
    public void insertatloc(int loc,int data)
    {
        Dnode newnode=newnode(data);
        Dnode temp=head;
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
    public void display()
    {
        Dnode temp=head.next;
        for(int i=1;i<=len;i++)
        {
            System.out.println(temp.data);
            temp=temp.next;
        }
        System.out.println("No of nodes :"+len);
    }
    public void deleteatstart()
    {
        Dnode temp=tail;
        head.next=head.next.next;
        head.next.previous=temp;
        temp.previous=head.next;
        --len;
    }
    public void deleteatend()
    {
        Dnode temp=head.next;
        for(int i=1;i<=len-1;i++)
        {
            temp=temp.next;
        }
        temp.next=head.next;
        head.next.previous=temp;
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
    public void deleteCDLL()
    {
        head=null;
        tail=null;
    }
    public void displayback() {
       Dnode temp = head;
       for(int i=1;i<=len;i++)
       {
           temp=temp.next;
       }
       for(int i=1;i<=len;i++)
       {
           System.out.println(temp.data);
           temp=temp.previous;
       }
//       obj.println("No of nodes: "+len);
//        Dnode temp=tail;
//        while(temp.previous!=tail)
//        {
//            System.out.println(temp.data);
//            temp=temp.previous;
//        }
        System.out.println("No of nodes :"+len);
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
private Dnode newnode(int data)
{
    Dnode newnde = new Dnode();
    newnde.data=data;
    return newnde;
}
}
