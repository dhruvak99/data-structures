public class QueueMain
{
  public static void main(String args[])
  {
    Queue obj = new Queue(10);
    obj.add(24);
    obj.add(45);
    obj.add(76);
    obj.add(1000);
    obj.display();
    System.out.println();
    obj.delete();
    obj.display();
    System.out.println();
    obj.add(200);
    obj.display();
    obj.delete();
    obj.display();
  }
}
