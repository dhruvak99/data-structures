public class DoubleLinkedListMain {
    public static void main(String args[])
    {
        DoubleLinkedList obj = new DoubleLinkedList(100);
        obj.insertatbeginning(1);
        obj.insertatbeginning(2);
        obj.insertatbeginning(3);
        obj.display();
        System.out.println();
        obj.insertatend(200);
        obj.display();
        System.out.println();
        obj.insertinbetween(30,1);
        obj.display();
        System.out.println();
        obj.deleteatend();
        obj.display();

        System.out.println();
        obj.deleteatloc(2);
        obj.display();

        System.out.println();
        obj.search(100);

        System.out.println();
        obj.displayback();
    }
}
