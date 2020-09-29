import java.util.*;
import java.io.*;
public class QuadraticProbing
{
  String[] hashtable;
  int noOfcellsused;
  PrintStream obj = System.out;
  QuadraticProbing()
  {
    hashtable = new String[13];
    noOfcellsused=0;
  }
  public int SimpleHashFunction(String str , int M)
  {
    char[] ch;
    ch=str.toCharArray();
    int sum,i;
    for(sum=0, i=0;i<str.length();i++)
    {
      sum=sum+ch[i];
    }
    obj.println(sum%M);
    return sum*M;
  }
  public double getFillRatio()
  {
    return noOfcellsused*1.0/hashtable.length;
  }
  public void insertIntoHashTable(String stringtobeinserted)
  {
    double fillratio = getFillRatio();
    if(fillratio> 0.75)
    {
      rehash(stringtobeinserted);
    }
    else
    {
      int insertindex = SimpleHashFunction(stringtobeinserted, hashtable.length);
      int counter=0;
      for(int i=insertindex;i<  insertindex+hashtable.length;i++)
      {
        int newindex = (insertindex+(counter*counter))%hashtable.length;
        obj.println(newindex);
        if(hashtable[newindex]==null)
        {
          obj.println("inserted at "+newindex);
          hashtable[newindex]=stringtobeinserted;

          return;
        }
        else
        {
          obj.println("cell occupied finding next empty cell");
        }
        counter++;
      }
      noOfcellsused++;
    }
  }
  public void deleteFromHashTable(String stringtobedeleted)
  {
    int deleteindex = SimpleHashFunction(stringtobedeleted, hashtable.length);
    for(int i=deleteindex;i<deleteindex+hashtable.length;i++)
    {
      int newindex=i%hashtable.length;
    if(hashtable[newindex]!=null && hashtable[newindex].equals(stringtobedeleted))
    {
      obj.println("String deleted");
      hashtable[newindex]=null;
      return;
    }
  }
  obj.println("String not found");

  }
  public void rehash(String stringtobeinserted)
  {
    noOfcellsused=0;
    ArrayList<String> data = new ArrayList<String>();
    for(String s : hashtable)
    {
      if(s!=null)
      data.add(s);
    }
    data.add(stringtobeinserted);
    hashtable = new String[hashtable.length*2];
    for(String s:data)
    insertIntoHashTable(s);
  }
  public void displayhashtable()
  {
    for(int i=0;i<hashtable.length;i++)
    {
      obj.println(hashtable[i]);
    }
  }
  public static void main(String[] args) {
    QuadraticProbing object = new QuadraticProbing();
    object.insertIntoHashTable("abc");
    object.insertIntoHashTable("abc");
    object.displayhashtable();
  }
}
