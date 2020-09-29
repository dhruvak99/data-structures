public class CircularSingleLinkedListMain {
    public static void main(String args[])
    {
        CircularSingleLinkedList obj = new CircularSingleLinkedList(50);
        obj.insertatstart(56);
        obj.insertatstart(74);
        obj.display();
        System.out.println();
        obj.insertatend(100);
        obj.display();
        System.out.println();
        obj.insertatloc(10,2);
        obj.display();
        System.out.println();
        obj.deleteatstart();
        obj.display();
        System.out.println();
        obj.deleteatend();
        obj.display();
        System.out.println();
        obj.insertatloc(3,1);
        obj.display();
        System.out.println();
        obj.deleteatloc(2);
        obj.display();
        System.out.println();
        obj.search(50);
    }
}
