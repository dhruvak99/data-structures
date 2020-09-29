import java.io.PrintStream;

public class bstmain {
    public static void main(String args[])
    {
        PrintStream o = System.out;
        Bst obj = new Bst();
        obj.insert(100);
        obj.levelordertraversal();
    }
}
