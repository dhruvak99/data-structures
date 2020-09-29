public class interview {
    public static String reverseString(String str)
    {
        String reverse="";
        for(int i=str.length();i>=0;i--)
            reverse+=i;
        return reverse;
    }
    public static void main(String[] args) {
        System.out.print(reverseString("dhurva"));
    }
}
