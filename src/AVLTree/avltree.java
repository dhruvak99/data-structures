import java.io.*;
import java.util.*;
public class avltree
{
 node root;
 avltree()
 {
   root=null;
 }
 void insert(int value)
 {
   root=insert(root,value);
 }
 node insert(node curnode,int value)
 {
   if(curnode==null)
   {
     System.out.println("Succesfully inserted "+value);
     return createnewnode(value);
   }
   else if(value <= curnode.getData())
   {
     curnode.setLeftChild(insert(curnode.getLeftChild(), value));
   }
   else
   {
     curnode.setRightChild(insert(curnode.getRightChild(), value));
   }
   int balance = checkBalance(curnode.getLeftChild(), curnode.getRightChild());
   if (balance > 1) {
     if (checkBalance(curnode.getLeftChild().getLeftChild(), curnode.getLeftChild().getRightChild()) > 0) {
       curnode = rightrotate(curnode);// LL Condition
     } else {
       curnode.setLeftChild(leftrotate(curnode.getLeftChild())); // LR Condition
       curnode = rightrotate(curnode);
     }
   }
   else if (balance < -1) {
     if (checkBalance(curnode.getRightChild().getRightChild(), curnode.getRightChild().getLeftChild()) > 0) {
       curnode = leftrotate(curnode);// RR Condition

     } else {
       curnode.setRightChild(rightrotate(curnode.getRightChild()));// RL Condition
       curnode = leftrotate(curnode);

     }
   }
   if (curnode.getLeftChild() != null) {
     curnode.getLeftChild().setHeight(calculateHeight(curnode.getLeftChild()));
   }
   if (curnode.getRightChild() != null) {
     curnode.getRightChild().setHeight(calculateHeight(curnode.getRightChild()));
   }
   curnode.setHeight(calculateHeight(curnode));
   return curnode;
 }
 void delete(int value)
 {
   root=delete(root, value);
 }
 node delete(node root,int value)
 {
   if(root==null)
   {
     System.out.println("Value not present in the Tree...");
     return null;
   }
   if(value < root.getData())
     root.setLeftChild(delete(root.getLeftChild(),value));
   else if(value > root.getData())
     root.setRightChild(delete(root.getRightChild(), value));
   else
   {
     //if the node has two children
     if(root.getLeftChild()!=null && root.getRightChild()!=null)
     {
       node temp = root;
       node minimumnode = getminimumnode(temp.getRightChild());
       root.setdata(minimumnode.getData());
       root.setRightChild(delete(root.getRightChild(),minimumnode.getData()));
     }
     else if(root.getLeftChild()==null)
     root=root.getRightChild();
     else if(root.getRightChild()==null)
     root=root.getLeftChild();
     else
     root=null;

     return root;
   }
   int balance=checkBalance(root.getLeftChild(), root.getRightChild());
   if(balance>1)
   {
     if(checkBalance(root.getLeftChild().getLeftChild(), root.getLeftChild().getRightChild())>0)
     {
       root=rightrotate(root);
     }
     else
     {
       root.setLeftChild(leftrotate(root.getLeftChild()));
       root=rightrotate(root);
     }
   }
   if(balance<-1)
   {
     if(checkBalance(root.getRightChild().getRightChild(), root.getRightChild().getLeftChild())>0)
     {
       root=leftrotate(root);
     }
     else
     {
       root.setRightChild(rightrotate(root.getRightChild()));
       root=leftrotate(root);
     }
   }
   if(root.getLeftChild()!=null){
   root.getLeftChild().setHeight(calculateHeight(root.getLeftChild()));
 }
 if(root.getRightChild()!=null)
 {
   root.getRightChild().setHeight(calculateHeight(root.getRightChild()));
 }
 root.setHeight(calculateHeight(root));
 return root;
 }
 node leftrotate(node curNode)
 {
   node newroot=curNode.getRightChild();
   curNode.setRightChild(curNode.getRightChild().getLeftChild());
   newroot.setLeftChild(curNode);
   curNode.setHeight(calculateHeight(curNode));
   newroot.setHeight(calculateHeight(newroot));
   return newroot;
 }
 node rightrotate(node curNode)
 {
   node newroot=curNode.getLeftChild();
   curNode.setLeftChild(curNode.getLeftChild().getRightChild());
   newroot.setRightChild(curNode);
   curNode.setHeight(calculateHeight(curNode));
   newroot.setHeight(calculateHeight(newroot));
   return newroot;
 }
 private int checkBalance(node rootLeft, node rootRight) {
   if((rootLeft == null) && (rootRight == null)) { //if current node is a leaf node then no need to check balance of its children
     return 0;
   }else if (rootLeft == null) {
     return -1 * (rootRight.getHeight() + 1); // if left node node is not there then simply return right node's
                           // height + 1
                           // we need to make it -1 because blank height is considered
                           // having height as '-1'
   } else if (rootRight == null) {
     return rootLeft.getHeight() + 1;
   } else {
     return rootLeft.getHeight() - rootRight.getHeight(); // +1 is not required, as both right and left child
                                 // exits and 1 gets nullified
   }
 }
 private int calculateHeight(node currentNode) {
   if (currentNode == null) {
     return 0;
   }
   return 1 + Math.max((currentNode.getLeftChild() != null ? currentNode.getLeftChild().getHeight() : -1),
       (currentNode.getRightChild() != null ? currentNode.getRightChild().getHeight() : -1));

 }
 node createnewnode(int value)
 {
   node newnode = new node();
   newnode.setdata(value);
   newnode.setHeight(0);
   return newnode;
 }

 private node getminimumnode(node root)
 {
   if(root.getLeftChild()==null)
   return root;
   else
   return getminimumnode(root.getLeftChild());
 }
 void inorderTraversal(node root)
 {
   if(root==null)
   return;
   else
   {
     inorderTraversal(root.getLeftChild());
     System.out.println(root.getData());
     inorderTraversal(root.getRightChild());
   }
 }
 void deleteTree()
 {
   root=null;
   System.out.println("Succesfully deleted the tree");
 }
 void levelOrderTraversal()
 {
   Queue<node> q= new LinkedList<node>();
   q.add(root);
   while(!q.isEmpty())
   {
     node presentnode=q.remove();
     System.out.print(presentnode.getData()+" ");
     if(presentnode.getLeftChild()!=null)
     q.add(presentnode.getLeftChild());
     if(presentnode.getRightChild()!=null)
     q.add(presentnode.getRightChild());
   }
 }
  public static void main(String[] args) {
    avltree obj = new avltree();
    obj.insert(100);
    obj.insert(10);
    obj.insert(200);
    obj.insert(5);
    obj.insert(1);
    obj.insert(2);
    obj.levelOrderTraversal();
    System.out.println();
    obj.delete(1);
    obj.delete(2);
  // obj.insert(100);
  // obj.insert(10);
  // obj.insert(200);
    obj.levelOrderTraversal();
    System.out.println();
    obj.insert(300);
    obj.levelOrderTraversal();

  }
}
