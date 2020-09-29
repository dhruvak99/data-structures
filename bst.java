import java.io.*;
class bst
{
  Node root;
  public Node addnode(int data,Node root)
  {

    if(root==null)
    {
      Node nodetobeadded = new Node(data);
      root=nodetobeadded;
    }
    else if(data<root.data)
    {
      root.leftchiild=addnode(data, root.leftchiild);
    }
    else
    {
      root.rightchild=addnode(data, root.rightchild);
    }
    return root;
  }

    public void inorder(Node root)
    {
      while(root!=null)
      {
        inorder(root.leftchiild);
        System.out.println(root.data);
        inorder(root.rightchild);
      }
    }
  public static void main(String args[])
    {
        bst obj = new bst();
        obj.addnode(56,obj.root);
        obj.addnode(34,obj.root);
        obj.addnode(67,obj.root);
        obj.inorder(obj.root);

  }
}
