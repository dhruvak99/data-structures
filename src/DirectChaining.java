import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.*;
public class DirectChaining {
    LinkedList<String>[] hashtable;//creating an array of linked list
    int maximumchainSize=5;
    PrintStream obj = System.out;
    DirectChaining()
    {
        hashtable = new LinkedList[13];
    }
    public int SimpleHashFunction(String str,int M)
    {
        char[] ch;
        ch=str.toCharArray();
        int i,sum;
        for(sum=0,i=0;i<str.length();i++)
        {
            sum=sum+ch[i];
        }
        return sum%M;
    }
    public void insertIntoHashTable(String str)
    {
        int index = SimpleHashFunction(str,hashtable.length);
        if(hashtable[index]==null)
        {
            //case 1 : the cell is empty so we can directly insert the value
            //we have to create a linked list at the index and add a new node
            obj.println("Inserting at index "+index);
            hashtable[index] = new LinkedList<String>();
            hashtable[index].add(str);
        }
        else
        {
            //the cell is not empty so we add a new node at that index
            obj.println("Inserting in the linked List since index value "+index+" is already occupied");
            hashtable[index].add(str);
        }
    }
    public boolean searchStringInHashTable(String str)
    {
        int newindex=SimpleHashFunction(str,hashtable.length);
        if(hashtable[newindex]!=null && hashtable[newindex].contains(str))
        {
            obj.println("The String "+str+" exists in the hashtable");
            return true;
        }
        else
        {
            obj.println("The string "+str+" does not exist");
            return false;
        }

    }
    public void deleteFromHashTable(String stringtobedeleted)
    {
        if(searchStringInHashTable(stringtobedeleted))
        {
            int deleteindex = SimpleHashFunction(stringtobedeleted,hashtable.length);
            hashtable[deleteindex].remove(stringtobedeleted);
        }
        else
        {
            obj.println("String does not exist in the hashtable");
        }
    }
    public void display()
    {
        for(int i=0;i<hashtable.length;i++)
        {
            obj.println("Index : "+i+" Value: "+hashtable[i]);
        }
    }
    public static void main(String[] args) {
        DirectChaining obj = new DirectChaining();
        obj.insertIntoHashTable("sbs");
        obj.insertIntoHashTable("sbs");
        obj.insertIntoHashTable("abc");obj.searchStringInHashTable("dbc");
        obj.searchStringInHashTable("abc");
        obj.display();
        obj.deleteFromHashTable("sbs");
        obj.display();
    }
}
