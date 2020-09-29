public class TrieMain
{
  public static void main(String[] args) {
    Trie obj = new Trie();
    obj.insert("abc");
    obj.insert("bcd");
    obj.insert("abcd");
    obj.search("abcde");
    obj.search("abc");
    obj.search("ab");
  }
}
