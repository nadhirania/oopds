public class User {

  private String username;
  private String password;
  private int userID;

  public User(){}

  public User(String username, String password, int userID){
    this.username = username;
    this.password = password;
    this.userID = userID;
  }

  public String getUsername(){
    return username;
  }

  public String getPassword(){
    return password;
  }

  public int getUserID(){
    return userID;
  }

  public void setUsername(String newUsername){
    this.username = newUsername;
  }

  public void setPassword(String newPassword){
    this.password = newPassword;
  }

  public void setUserID(int newUserID){
    this.userID = newUserID;
  }

  //public String toString(){
  //  return "username: " + username + " password: " + password + " userID: " + userID;
  //}

  public String toCSVString() {
    return username + "," + password + "," + userID;
  }

}
