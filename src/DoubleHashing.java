import java.util.*;
public class DoubleHashing
{
  String[] hashtable;
  int noOfcellsused;
  DoubleHashing()
  {
    hashtable = new String[13];
    noOfcellsused=0;
  }
  public int FirstHashFunction(String str , int M)
  {
    char[] ch;
    ch=str.toCharArray();
    int sum,i;
    for(sum=0,i=0;i<str.length();i++)
    {
      sum+=ch[i];
    }
    return sum%M;
  }
  public int secondhashfunction(String str , int M)
  {
    char ch[];
    ch=str.toCharArray();
    int i,sum;
    for(sum=0,i=0;i<str.length();i++)
    {
      sum+=ch[i];
    }
    while(sum>13)
      sum=addalldigits(sum);
    return sum%M;
  }
  int addalldigits(int sum)
  {
    int value;
    while(sum>0)
    {
      value = sum%10;
      sum=sum/10;
    }
    return value;
  }
  public static void main(String[] args) {

  }
}
