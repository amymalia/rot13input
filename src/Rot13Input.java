import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This program reads lines of text from the user, encodes them using the
 * trivial "Rot13" substitution cipher, and then prints out the encoded lines.
 * This example is from _Java Examples in a Nutshell_. (http://www.oreilly.com)
 * Copyright (c) 1997 by David Flanagan
 * This example is provided WITHOUT ANY WARRANTY either expressed or implied.
 * You may study, use, modify, and distribute it for non-commercial purposes.
 * For any commercial use, see http://www.davidflanagan.com/javaexamples
 */
public class Rot13Input {

  /**
   * Reads text from user.
   * @param args (not used)
   * @throws IOException when user input is invalid
   */
  public static void main(String[] args) throws IOException {
    // Get set up to read lines of text from the user
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    // Infinite loop
    while (true) {
      System.out.print("> ");
      String line = in.readLine();
      // If EOF or "quit" then break out of the loop
      if ((line == null) || line.equals("quit")) {
        break;
      }
        StringBuffer buf = new StringBuffer(line);
        // For each character, read, encode, put it back
        for (int i = 0; i < buf.length(); i++) {
          buf.setCharAt(i, rot13(buf.charAt(i)));
        }
        System.out.println(buf);

    }
  }

  /**
   * This method performs the Rot13 substitution cipher.  It "rotates"
   * each letter 13 places through the alphabet.  Since the Latin alphabet
   * has 26 letters, this method both encodes and decodes.
   * @param c   character to rotate
   * @return    resulting character
   */
  public static char rot13(char c) {
    // For uppercase letters
    if ((c >= 'A') && (c <= 'Z')) {
      c += 13;
      if (c > 'Z') {
        c -= 26;
      }
    }
    //For lowercase letters
    if ((c >= 'a') && (c <= 'z')) {
      c += 13;
      if (c > 'z') {
        c -= 26;
      }
    }
    return c;
  }
}