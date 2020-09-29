import java.io.*;
import java.util.Queue;
import java.util.LinkedList;
import java.math.*;
public class AVLTree
{
  Bnode root;
  AVLTree()
  {
    root=null;
  }
  public Bnode getRoot(){
    return root;
  }
  void insert(int value)
  {
    root=insert(root,value);
  }
  Bnode insert(Bnode currentNode,int value)
  {
    if(currentNode==null)
    return createnewnode(value);
    if(value <= currentNode.data)
    currentNode.leftChild=insert(currentNode.getLeftChild(), value);
    else if(value > currentNode.data)
    currentNode.rightchild=insert(currentNode.getRightchild(), value);
    currentNode.height = 1+Math.max(height(currentNode.leftChild), height(currentNode.rightchild));
    int balance = checkBalance(currentNode);
    if(balance > 1 && value < currentNode.leftChild.data)
     {rightRotate(currentNode);}
    else if(balance <-1 && value > currentNode.rightchild.data)
    {leftRotate(currentNode);}
    else if(balance > 1 && value>currentNode.leftChild.data)
    {
      currentNode.leftChild = leftRotate(currentNode.leftChild);
      rightRotate(currentNode);
    }
    else if(balance <-1 && value <currentNode.rightchild.data)
    {
      currentNode.rightchild=rightRotate(currentNode.rightchild);
      leftRotate(currentNode);
    }
    return currentNode;
  }
public int checkBalance(Bnode root)
{
  if(root==null)
  return 0;
  else
  return height(root.leftChild)-height(root.rightchild);
}
private int height(Bnode root)
{
  if(root==null)
  return -1;
  else
  return root.height;
}
private Bnode leftRotate(Bnode currentnode)
{
  Bnode newroot=currentnode.getRightchild();
  currentnode.leftChild=currentnode.getRightchild().getLeftChild();
  newroot.leftChild=currentnode;
  currentnode.height=1+Math.max(height(currentnode.leftChild), height(currentnode.rightchild));
  newroot.height=1+Math.max(height(newroot.leftChild), height(newroot.rightchild));
  return newroot;
}
private Bnode rightRotate(Bnode currentnode)
{
  Bnode newroot=currentnode.getLeftChild();
  currentnode.rightchild=currentnode.getLeftChild().getRightchild();
  newroot.rightchild=currentnode;
  currentnode.height=1+Math.max(height(currentnode.leftChild), height(currentnode.rightchild));
  newroot.height=1+Math.max(height(newroot.leftChild), height(newroot.rightchild));
  return newroot;
}
private Bnode createnewnode(int value)
{
  Bnode node = new Bnode();
  node.data=value;
  node.height=0;
  return node;
}
public void levelOrder()
{
  Queue<Bnode> q = new LinkedList<Bnode>();
  q.add(root);
  while(!q.isEmpty())
  {
    Bnode presentNode = q.remove();
    System.out.print(presentNode.data+" ");
    if(presentNode.leftChild!=null)
    q.add(presentNode.getLeftChild());
    if(presentNode.rightchild!=null)
    q.add(presentNode.getRightchild());
  }
}
public void inorder(Bnode root)
{
  if(root==null)
  return;
  else
  {
    inorder(root.leftChild);
    System.out.println(root.data);
    inorder(root.rightchild);
  }
}
public static void main(String args[])
{
  AVLTree obj = new AVLTree();
  obj.insert(100);
  obj.insert(200);
  obj.insert(300);
  obj.insert(400);
  obj.levelOrder();
}
}
