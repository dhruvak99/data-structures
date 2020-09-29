import java.util.*;
public class Trie
{
  private class TrieNode
  {
    Map<Character,TrieNode> children;
    boolean endOfWord;

    //constructor
    public TrieNode()
    {
      children = new HashMap<>();
      endOfWord = false;
    }
  }//end of node class

  private final TrieNode root;

  public Trie()
  {
    root = new TrieNode();
  }

  public void insert(String word)
  {
    TrieNode current = root;
    for(int i=0;i<word.length();i++)
    {
      char ch=word.charAt(i);
      TrieNode node = current.children.get(ch);
      if(node == null)
      {
        node = new TrieNode();
        current.children.put(ch, node);
      }
      current=node;
    }
    current.endOfWord=true;
    System.out.println("Successfully inserted "+word);
  }
  public boolean search(String word)
  {
    TrieNode current = root;
    for(int i=0;i<word.length();i++)
    {
      char ch = word.charAt(i);
      TrieNode node = current.children.get(ch);
      //case1 if the node does not exits for that String
      if(node == null)
      {
        System.out.println("Word: " + word + " does not exists in Trie !");
        return false;
      }
      current=node;
    }
      if(current.endOfWord==true)
      {
        System.out.println("Word: " + word + " exists in Trie !");
      }
      else
      {
        System.out.println("Word: " + word + " does not exists in Trie ! But this is a Prefix of another Word !");
      }
    return current.endOfWord;
  }
}
