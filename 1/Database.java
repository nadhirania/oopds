import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;

public class Database {
  //DISPLAY MENU FROM CSV FILE
  public static ArrayList<FoodeliverMenu> readFoodeliverMenuFromFile() throws IOException {
    ArrayList<FoodeliverMenu> menu = new ArrayList<>();

    // read menu.csv into a list of lines.
    Path menu_path = Paths.get("menu.csv");
    try {
      List<String> lines = Files.readAllLines(menu_path);

      for (int i = 0; i < lines.size(); i++) { //0 is from ArrayList
        // split a line by comma
        String[] items = lines.get(i).split(",");
        // items[0] is code, items[1] is name, items[2] is price
        int code = Integer.parseInt(items[0]);
        double price = Double.parseDouble(items[2]);
        menu.add (new FoodeliverMenu(code, items[1], price));

        System.out.println(code + " " + items[1] + " RM" + price + "0");
      }
    } catch (IOException e) {
        System.out.println("File " + menu_path + " is not found!");
      }return menu;
  }

  private static void saveFoodeliverMenuToFile(ArrayList<FoodeliverMenu> menu) throws IOException {
    // read menu.csv into a list of lines.
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < menu.size(); i++) {
      sb.append (menu.get(i).toCSVString() + "\n");
    }
    Files.write(Paths.get("menu.csv"), sb.toString().getBytes());
  }
}
