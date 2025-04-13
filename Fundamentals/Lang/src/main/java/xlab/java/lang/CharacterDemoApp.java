package xlab.java.lang;

/**
 * @author CodeKing
 */
public class CharacterDemoApp {

  public static void main(String[] args) {
    System.out.println(Character.toTitleCase('a'));
    System.out.println(Character.toTitleCase('A'));
    final Character c1 = '\u0001';
    final Character c2 = (char) 1;
    final char c3 = (char) 0;
    final char c4 = '\u0000';
    System.out.println(c1);
    System.out.println(c1 == c2);
    System.out.println(c3 == c4);
    System.out.println(c3 == '0');
    System.out.println('\u0030' == '0');
    System.out.println((int) '0');
  }
}
