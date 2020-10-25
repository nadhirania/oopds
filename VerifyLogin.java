import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

public class VerifyLogin {
  private static Scanner x;

  public void VerifyLogin(String username, String password, String filepath) {
    boolean found = false;
    String tempUsername = "";
    String tempPassword = "";

    try {
      x = new Scanner(new File(filepath));
      x.useDelimiter("[,\n]");

      while(x.hasNext() && !found) {
        tempUsername = x.next();
        tempPassword = x.next();

        if(tempUsername.trim().equals(username.trim()) && tempPassword.trim().equals(password.trim())) {
          found = true;
          System.out.println("\n\tWelcome " + username + "!\n");
        }
      }
      x.close();
    } catch(IOException e) {
        System.out.println("File " + filepath + " not found!");
      }
  }
}
