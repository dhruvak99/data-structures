import java.util.*;
public class maxheap
{
  private int capacity=10;
  private int size;
  int[] items = new int[capacity];

  private int getLeftChildIndex(int parentindex)
  {
    return 2*parentindex+1;
  }
  private int getRightChildIndex(int parentindex)
  {
    return 2*parentindex+2;
  }
  private int getParentIndex(int childindex)
  {
    return (childindex-1)/2;
  }
  private boolean hasLeftChild(int index)
  {
    return getLeftChildIndex(index)<size;
  }
  private boolean hasRightChild(int index)
  {
    return getLeftChildIndex(index)<size;
  }
  private boolean hasParent(int index)
  {
    return getParentIndex(index)>=0;
  }
  private int getLeftChild(int index)
  {
    return items[getLeftChildIndex(index)];
  }
  private int getRightChild(int index)
  {
    return items[getRightChildIndex(index)];
  }
  private int getParent(int index)
  {
    return items[getParentIndex(index)];
  }
  private void swap(int indexone,int indextwo)
  {
    int temp=items[indexone];
    items[indexone]=items[indextwo];
    items[indextwo]=temp;
  }
  private void ensureCapacity()
  {
    if(size==capacity)
    {
    items=Arrays.copyOf(items, capacity*2);
    capacity*=2;
  }
}
  public int peek()
  {
    if(size==0) throw new IllegalStateException();
    return items[0];
  }
  public int poll()
  {
    if(size==0) throw new IllegalStateException();
    int item=items[0];
    items[0]=items[size-1];
    size--;
    heapifydown();
    return item;
  }
  public void add(int value)
  {
    ensureCapacity();
    items[size]=value;
    size++;
    heapifyup();
  }
  private void heapifydown()
  {
    int index=0;
    while(hasLeftChild(index))
    {
      int greaterindex=getLeftChildIndex(index);
      if(hasRightChild(index) && getRightChild(index)>getLeftChild(index))
      {
        greaterindex=getRightChild(index);
      }
      if(items[index]>items[greaterindex])
      {
        break;
      }
      else
      {
        swap(index, greaterindex);
      }
      index=greaterindex;
    }
  }
  private void heapifyup()
  {
    int index=size-1;
    while(hasParent(index) && getParent(index) < items[index])
    {
      swap(getParentIndex(index),index);
      index=getParentIndex(index);
    }
  }
  public void display()
  {
    for(int i=0;i<=size-1;i++)
    {
      System.out.print(items[i]+" ");
    }
  }
  public static void main(String[] args) {
    maxheap obj = new maxheap();
    obj.add(10);
    obj.add(5);
    obj.add(2);
    obj.add(100);
    System.out.println("Root of max heap : "+obj.peek());
    obj.display();
    obj.poll();
    System.out.println();
    obj.display();
    System.out.println("Root of max heap : "+obj.peek());
  }
}
