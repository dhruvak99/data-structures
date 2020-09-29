public class SingleLinkedListMain {
    public static void main(String args[])
    {
        SingleLinkedList obj = new SingleLinkedList(50);
        obj.insert(56);
        obj.insert(76);
        obj.insertatstart(10);
        obj.insertinbetween(34,2);
        obj.insert(100);
        obj.display();
       obj.deleteLL();
       obj.display();
    }
}
