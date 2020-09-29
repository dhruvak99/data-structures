public class Queue
{
  int queue[];
  int front,rear;
  int max;
  Queue(int size)
  {
    queue= new int[size];
    this.max=size;
    front=rear=-1;
    System.out.println("Queue of size "+size+" has been created");
  }
  void add(int ele)
  {
    if(rear==max-1)
    {
      System.out.println("Queue OVERFLOW");
    }
    else
    {
      rear=rear+1;
      queue[rear]=ele;
      if(front==-1)
      {
        front=0;
      }
    }
  }
  void delete()
  {
    int ele;
    if(front==-1)
    {
      System.out.println("Queue Underflow");
    }
    else
    {
    System.out.println("Deleted element is "+queue[front]);
      if(front==rear)
      {
        front=-1;
        rear=-1;
      }
      else
      {
        front=front+1;
      }
    }
  }
  void display()
  {
    if(front==-1)
    System.out.println("Q is empty");
    else
    {
    for(int i=front;i<=rear;i++)
    {
      System.out.println("|"+queue[i]+"|");
    }}
  }
}
