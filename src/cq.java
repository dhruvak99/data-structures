import java.io.*;
public class cq
{
  int queue[];
  int maxsize;
  int f,r;
  cq(int size)
  {
    maxsize=size;
    queue = new int[maxsize];
    f=r=-1;
  }
  public void insert(int ele)
  {
    if((f==0 && r==maxsize-1) || (r+1==f))
    {
      System.out.println("OVERFLOW");
    }
    else
    {
      if(r==-1)
      f=r=0;
      else if(r==maxsize-1)
      r=0;
      else
      r++;
      queue[r]=ele;
      System.out.println("Inserted "+ele);
    }
  }
  public void delete()
  {
    if(f==-1)
    System.out.println("UNDERFLOW");
    else
    {
      System.out.println("Deleted "+queue[f]);
      if(f==r)
      f=r=-1;
      else if(f==maxsize-1)
      f=0;
      else
      f++;
    }
  }
  void display()
  {
    if(f==-1)
    System.out.println("queue empty");
    else
    {
      if(f>r)
      {
        for(int i=f;i<maxsize;i++)
        System.out.println(queue[i]);
        for(int i=0;i<=r;i++)
        System.out.println(queue[i]);
      }
      else
    {
      for(int i=f;i<=r;i++)
      System.out.println(queue[i]);
    }
    }
  }
  public static void main(String[] args) {
    cq queue = new cq(5);
    queue.insert(10);
    queue.insert(16);
    queue.insert(1);
    queue.insert(5);
    queue.insert(34);
    queue.insert(12);
    queue.display();
    queue.delete();queue.delete();queue.delete();queue.delete();queue.delete();queue.delete();
    queue.display();
  }
}
