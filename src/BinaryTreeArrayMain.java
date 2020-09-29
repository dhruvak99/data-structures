public class BinaryTreeArrayMain{
  public static void main(String args[])
  {
    BinaryTreeArray obj = new BinaryTreeArray(10);
    obj.insert(100);
    obj.insert(1);
    obj.insert(60);
    obj.insert(23);
    obj.insert(10);
    obj.insert(11);
    System.out.println();
    obj.search(100);
    System.out.println();
    obj.levelOrder();
    System.out.println();
    obj.delete(23);
    System.out.println();
    obj.levelOrder();
  }
}
