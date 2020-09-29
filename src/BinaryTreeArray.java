public class BinaryTreeArray
{
int arr[];
int lastUsedIndex;

public BinaryTreeArray(int size)
{
  arr = new int[size+1];
  this.lastUsedIndex=0;
  System.out.println("Tree of size "+size+" has been created");
}

boolean isTreeFull()
{
  if(arr.length-1==lastUsedIndex)
  return true;
  else
  return false;
}
void insert(int value)
{
  if(!isTreeFull())
  {
    arr[lastUsedIndex+1]=value;
    lastUsedIndex++;
    System.out.println("Value "+value+" inserted");
  }
  else
  System.out.println("Tree is full..");
}
public void levelOrder()
{
  for(int i=1;i<=lastUsedIndex;i++)
  {
    System.out.println(arr[i]);
  }
}
public void preOrder(int index)
{
  if(index>lastUsedIndex)
  return;
  else
  {
    System.out.println(arr[index]);
    preOrder(index*2);
    preOrder(index*2+1);
  }
}
public void postOrder(int index)
{
    if(index>lastUsedIndex)
    return;
    else
    {

      postOrder(index*2);
      postOrder(index*2+1);
        System.out.println(arr[index]);
    }
}
public void inOrder(int index)
{

    if(index>lastUsedIndex)
    return;
    else
    {

      inOrder(index*2);
      System.out.println(arr[index]);
      inOrder(index*2+1);
    }
}
public int search(int ele)
{
  for(int i=1;i<=lastUsedIndex;i++)
  {
    if(arr[i]==ele)
    {
      System.out.println("element found");
      return i;
    }
  }
  System.out.println("Element not found");
  return -1;
}
public void delete(int ele)
{
  int loc=search(ele);
  if(loc==-1)
  {
    System.out.println("Element not present in tree");
  }
  else
  {
    arr[loc]=arr[lastUsedIndex];
    lastUsedIndex=lastUsedIndex-1;
    System.out.println("Successfully deleted " + ele + " from the Tree !");
  }
}

}
