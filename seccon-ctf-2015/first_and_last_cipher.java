import java.util.*;

public class Start_Seccon_CTF_2015
{
  private static char[] key = {'P','X','F','R','}','Q','I','V','T','M','S','Z','C','N','D','K','U','W','A','G','J','B','{','L','H','Y','E','O'};
  private static char[] alpha = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','{','}'};
  private static ArrayList<Character> keyList = new ArrayList<>();
  public static void main(String[] args) throws Exception
  {
    for(char c : key)
      keyList.add(c);
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter the cipher text: ");
    String cipherText = scan.nextLine();
    System.out.println(cipherText);
    
    
    System.out.println("decoded text: " + process(cipherText));
  }
  
  public static String process(String cipherText)
  {
    String result = "";
    
    for(int i = 0; i < cipherText.length(); i ++)
      result += alpha[keyList.indexOf(cipherText.charAt(i))];
    
    return result;
  }
}
