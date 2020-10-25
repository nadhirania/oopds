import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Database {

  //public static ArrayList<Order> OrderDB = new ArrayList<>();

  //DISPLAY MENU FROM CSV FILE
  public static ArrayList<FoodeliverMenu> readFoodeliverMenuFromFile() throws IOException {
    ArrayList<FoodeliverMenu> menu = new ArrayList<>();

    // read menu.csv into a list of lines.
    Path menu_path = Paths.get("menu.csv");
    try {
      List<String> lines = Files.readAllLines(menu_path);
      Collections.sort(lines);

      for (int i = 0; i < lines.size(); i++) { //0 is from ArrayList
        // split a line by comma
        String[] items = lines.get(i).split(",");
        // items[0] is code, items[1] is name, items[2] is price
        int code = Integer.parseInt(items[0]);
        double price = Double.parseDouble(items[2]);
        menu.add (new FoodeliverMenu(code, items[1], price));

        //System.out.println(code + " " + items[1] + " RM" + price + "0");
      }
    } catch (IOException e) {
        System.out.println("File " + menu_path + " is not found!");
      } return menu;
  }

  public static void saveFoodeliverMenuToFile(ArrayList<FoodeliverMenu> menu) throws IOException {
    // read menu.csv into a list of lines.
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < menu.size(); i++) {
      sb.append (menu.get(i).toCSVString() + "\n");
    }
    Files.write(Paths.get("menu.csv"), sb.toString().getBytes());
  }

  public static void printFoodeliverMenuFromFile(ArrayList<FoodeliverMenu> menu) throws IOException {
    //ArrayList<FoodeliverMenu> tempmenu = new ArrayList<>();
    // read menu.csv into a list of lines.
    Path menu_path = Paths.get("menu.csv");
    try {
      List<String> lines = Files.readAllLines(menu_path);
      Collections.sort(lines);

      for (int i = 0; i < lines.size(); i++) { //0 is from ArrayList
        // split a line by comma
        String[] items = lines.get(i).split(",");
        // items[0] is code, items[1] is name, items[2] is price
        int code = Integer.parseInt(items[0]);
        double price = Double.parseDouble(items[2]);
        //tempmenu.add (new FoodeliverMenu(code, items[1], price));

        System.out.println(code + " " + items[1] + " RM" + price + "0");
      }
    } catch (IOException e) {
        System.out.println("File " + menu_path + " is not found!");
      }
  }

  public static ArrayList<Order> readOrderFromFile() throws IOException {
    ArrayList<Order> OrderList = new ArrayList<>();

    // read menu.csv into a list of lines.
    Path OrderList_path = Paths.get("Order.csv");
    try {
      List<String> lines = Files.readAllLines(OrderList_path);
      Collections.sort(lines);

      for (int i = 0; i < lines.size(); i++) { //0 is from ArrayList
        // split a line by comma
        String[] items = lines.get(i).split(",");
        // items[0] is orderID, items[1] is status, items[2] is FoodMenu
        int orderID = Integer.parseInt(items[0]);
        int status = Integer.parseInt(items[1]);
        OrderList.add (new Order(orderID, status, items[2]));

        //System.out.println(code + " " + items[1] + " RM" + price + "0");
      }
    } catch (IOException e) {
        System.out.println("File " + OrderList_path + " is not found!");
      } return OrderList;
  }

  public static void saveOrderToFile(ArrayList<Order> OrderList) throws IOException {
    // read menu.csv into a list of lines.
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < OrderList.size(); i++) {
      sb.append (OrderList.get(i).toCSVString() + "\n");
    }
    Files.write(Paths.get("Order.csv"), sb.toString().getBytes());
  }

  public static ArrayList<Order> OrderDatabase(ArrayList<Order> OrderList) throws IOException {
    //OrderList.add (new Order());
    return OrderList;
  }

  public static ArrayList<User> readCustomerDatabaseFromFile() throws IOException{
    ArrayList<User> UserList = new ArrayList<>();

    Path UserList_path = Paths.get("User.csv");
    try {
      List<String> lines = Files.readAllLines(UserList_path);
      Collections.sort(lines);

      for (int i = 0; i < lines.size(); i++) { //0 is from ArrayList
        // split a line by comma
        String[] items = lines.get(i).split(",");
        // items[0] is username, items[1] is password, items[2] is userID
        int userID = Integer.parseInt(items[2]);
        UserList.add (new User(items[0], items[1], userID ));
      }
    }catch (IOException e) {
        System.out.println("File " + UserList_path + " is not found!");
      }return UserList;
    }

  public static void saveCustomerDatabaseToFile(ArrayList<User> UserList) throws IOException {
    // read menu.csv into a list of lines.
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < UserList.size(); i++) {
      sb.append (UserList.get(i).toCSVString() + "\n");
    }
    Files.write(Paths.get("User.csv"), sb.toString().getBytes());
  }

} //end of Database
