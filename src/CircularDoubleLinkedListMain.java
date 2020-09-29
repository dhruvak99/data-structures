import java.io.PrintStream;

public class CircularDoubleLinkedListMain {
    public static void main(String args[])
    {
        PrintStream obj1 = System.out;
        CircularDoubleLinkedList obj = new CircularDoubleLinkedList(100);
        obj.insertatstart(1);
        obj.insertatstart(2);
        obj.insertatstart(10);
        obj.insertatend(1882);
        obj.insertatend(66);
        obj.displayback();
        obj.deleteatend();
        obj.displayback();
        obj.deleteatstart();
        obj.display();

    }
}
