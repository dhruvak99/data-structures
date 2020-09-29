public class q
{
  int queue[];
  int f,r;
  int max;
  q(int size)
  {
    max=size;
    queue = new int[size];
    f=r=-1;
  }
  void insert(int value)
  {
    if(r==max-1)
    {
      System.out.println("isfull");
    }
    else
    {
      if(r==-1)
      {r=0;f=0;}
      else
      r++;
      queue[r]=value;
      System.out.println("inserted "+value);
    }
  }
  void delete()
  {
    int value;
    if(f==-1)
    {
      System.out.println("isEmpty");
    }
    else
    {
      value=queue[f];
      if(f==r)
      {
        f=r=-1;
      }
      else
      f++;
      {
        System.out.println("deleted "+value);
      }
    }
  }
  void display()
  {
    if(f==-1)
    {
      System.out.println("isEmpty");
    }
    else
    for(int i=f;i<=r;i++)
    System.out.println(queue[i]);
  }
  public static void main(String[] args) {
    q queue = new q(5);
    for(int i=1;i<=6;i++)
    queue.insert(i*10);
    queue.display();
    for(int i=1;i<=6;i++)
    queue.delete();
    queue.display();
    queue.insert(100);
    queue.display();
  }
}
