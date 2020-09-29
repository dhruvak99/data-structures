import java.io.*;
public class bstmain{
  public static void main(String args[])
  {
    Node root;
      bst obj = new bst();
      obj.addnode(56);
      obj.addnode(34);
      obj.addnode(67);
      obj.inorder(root);
  }
}
