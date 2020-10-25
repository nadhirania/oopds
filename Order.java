public class Order {

  private int orderID = 0;
  private int status;
  private String fm;
  private static int counter = 0;

  public Order() {
    orderID = counter;
    counter++;
  }

  public Order(String fm){
    this.fm = fm;
  }

  public Order(int orderID, int status, String fm){
    this.orderID = orderID;
    this.status = status;
    this.fm = fm;
  }

  public int getOrderID(){
    return orderID;
  }

  public int getStatus(){
    return status;
  }

  public String getFm(){
    return fm;
  }

  public void setOrderID(int newOrderID){
    this.orderID = newOrderID;
  }

  public void setStatus(int newStatus){
    this.status = newStatus;
  }

  public void setFm(String newFm){
    this.fm = newFm;
  }

  public String toString(){
    return "id: " + orderID + " status: " + status + " name: " + fm;
  }

  public String toCSVString() {
    return orderID + "," + status + "," + fm;
  }
}
