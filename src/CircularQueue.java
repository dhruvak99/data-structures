public class CircularQueue{
  int q[];
  int front,rear;
  int max;
  CircularQueue(int size)
  {
    q=new int[size];
    front=rear=-1;
    this.max=size;
  }
  int getSize()
  {
    return size;
  }
  int getFront()
  {
    return front;
  }
  int getRear()
  {
    return rear;
  }
  boolean isFull()
  {
    if((front==0 && rear==max-1)||(rear+1==front))
    return true;
    else
    return false;
  }
  boolean isEmpty()
  {
    if(front==-1)
    return true;
    else
    return false;
  }
  void add(int ele)
  {
    if(isFull())
    {
      System.out.println("Queue is full");
    }
    else
    {
      if(rear==-1)
      front=rear=0;
      else if(rear==max-1)
      rear=0;
      else
      rear++;
      q[rear]=ele;
    }
  }
  void remove()
  {
    if(isEmpty())
    {
      System.out.println("Queue is Empty");
    }
    else
    {
      System.out.println("Deleted element is "+q[front]);
      if(front==rear)
      {
        front=rear=-1;
      }
      else if(front==max-1)
      {
        front=0;
      }
      else
      front++;
    }
  }
  void display()
  {
    if(front>rear)
    {
      for(int i=front;i<max;i++)
      System.out.println("|"+q[i]+"|");
      for(int i=0;i<=rear;i++)
      System.out.println("|"+q[i]+"|");
    }
    else
    {
      for(int i=front;i<=rear;i++)
      System.out.println("|"+q[i]+"|");
    }
  }
  public static void main(String args[])
  {
    CircularQueue obj = new CircularQueue(5);
    obj.add(45);
    obj.add(10);
    obj.add(5);
    obj.add(1);
    obj.add(6);
    obj.add(11);
    obj.display();
    obj.remove();
    obj.remove();
    obj.add(100);
    System.out.println();
    obj.display();
  }
}
