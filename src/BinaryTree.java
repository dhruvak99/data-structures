import java.util.*;
import java.io.*;
public class BinaryTree {
  Bnode root;//create root
  PrintStream o = System.out;
  BinaryTree()//constructor to initialize root to null
  {
    this.root=null;
  }
  void insert(int data)//find the deepest point in the tree and insert the node
  {
    Bnode addnode = new Bnode();//create a newnode
    addnode.data=data;//set data as data of that node
    if(root==null)//if this is the first node then it will be equal to null
    {
      root=addnode;//assign the newly created node to root
      o.println("Successfully inserted element");
      return;//return after setting root = newly created node
    }
    Queue<Bnode> queue = new LinkedList<Bnode>();//create a queue of type binary node to store the nodes
    //add the root to the queue at the begining
    queue.add(root);
    while(!queue.isEmpty())
    //loop until queue isNOTEmpty
    {
      Bnode presentNode = queue.remove();//move the front of the queue to presentnode
      //if presentNode has no leftchild then add the newly created node to the left child of presentnode and break the loop
      if(presentNode.getLeftChild()==null)
      {
        presentNode.leftChild=addnode;
        o.println("Successfully inserted element");
        break;
      }
      //if the presentNode has leftChild adn does not have rightchild then set the newly created node as the rightchild of the present node
      else if(presentNode.getRightchild()==null)
      {
        presentNode.rightchild=addnode;
        o.println("Successfully inserted element");
        break;
      }
      //if the node has two children then add the left and right child to the queue
      else {
        queue.add(presentNode.getLeftChild());
        queue.add(presentNode.getRightchild());
      }//end of if-elseif-else
    }//end of loop
  }//end of method
  void search(int searchelement)
  {
    Queue<Bnode> q = new LinkedList<Bnode>();
    q.add(root);
    while(!q.isEmpty())
    {
      Bnode presentNode = q.remove();
      if(presentNode.data==searchelement)
      {
        o.println("Element "+searchelement+" found");
        break;
      }
      if(presentNode.getLeftChild()!=null)
      q.add(presentNode.getLeftChild());
      if(presentNode.getRightchild()!=null)
      q.add(presentNode.getRightchild());
    }
  }
  /*deletion of node : first find the deepestnode in the binary tree and replace it with the element we want to delete
  delete the DeepestNode
  */
  void deleteNodeOfBinaryTree(int data)
  {
    Queue<Bnode> q = new LinkedList<Bnode>();
    q.add(root);
    while(!q.isEmpty())
    {
      Bnode presentNode = q.remove();
      if(presentNode.data == data)
      {
        presentNode.data = getDeepestNode().data;
        DeleteDeepestNode();
        o.println("Node deleted");
        return;
      }
      else{
      if(presentNode.getLeftChild()!=null)
      q.add(presentNode.leftChild);
      if(presentNode.getRightchild()!=null)
      q.add(presentNode.getRightchild());
    }
  }
  o.println("Node not found");
}
  void DeleteDeepestNode()
  {
    Queue<Bnode> q = new LinkedList<Bnode>();
    q.add(root);
    Bnode previousNode,presentNode=null;
    while(!q.isEmpty())
    {
      presentNode=q.remove();
      previousNode=presentNode;
      if(presentNode.getLeftChild()==null)
      {
        previousNode.rightchild=null;
        return;
      }
      else if(presentNode.getRightchild()==null)
      {
        presentNode.leftChild=null;
        return;
      }
      q.add(presentNode.getLeftChild());
      q.add(presentNode.getRightchild());
    }
  }
  Bnode getDeepestNode()
  {
    Queue<Bnode> q = new LinkedList<Bnode>();
    q.add(root);
    Bnode deepestnode = null;
    while(!q.isEmpty())
    {
      deepestnode=q.remove();
      if(deepestnode.getLeftChild()!=null)
      {
      q.add(deepestnode.leftChild);
      }
      if(deepestnode.getRightchild()!=null)
      {
      q.add(deepestnode.rightchild);
      }
    }
    //last node in the queue is the deepest node
    return deepestnode;
  }
  void inorder(Bnode root)
  {
    if(root==null)
    return;
    else
    {
      inorder(root.getLeftChild());
      o.println(root.getData());
      inorder(root.getRightchild());
    }
  }
  void preorder(Bnode root)
  {
    if(root==null)
    return;
    else
    {
      o.println(root.getData());
      preorder(root.getLeftChild());
      preorder(root.getRightchild());
    }
  }
  void postorder(Bnode root)
  {
    if(root==null)
    return;
    else
    {
      postorder(root.getLeftChild());
      postorder(root.getRightchild());
      o.println(root.getData());
    }
  }
  void levelOrder()
  {
    Queue<Bnode> q = new LinkedList<Bnode>();
    q.add(root);
    while(!q.isEmpty())
    {
      Bnode presentNode = q.remove();
      System.out.print(presentNode.data+" ");
      if(presentNode.getLeftChild()!=null)
    {  q.add(presentNode.getLeftChild()); }
      if(presentNode.getRightchild()!=null)
    {  q.add(presentNode.getRightchild());}
    }
  }
  //deletes the entire tree
  void deleteTree
  {
    root=null;
    System.out.println("Tree has been deleted");
  }
  }
