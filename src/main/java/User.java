import java.util.ArrayList;

public class User {
    //User should have a list of books
    //User should have a username and a password
    private ArrayList<Book> user_book = new ArrayList<Book>();
    private String username,password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.user_book = new ArrayList<Book>();
    }

    public boolean vaild_user(String username,String password){
        if (this.username.equals(username) && this.password.equals(password)){
            return true;
        }
        else {
            return false;
        }
    }
    public void rentBook(Book book){
        user_book.add(book);
    }

    public void returnBook(Book rented_book){
        for(int i = 0; i < user_book.size(); i++){
            if(user_book.get(i).equals(rented_book)){
                user_book.remove(i);
                break;
            }
        }
    }

    public boolean in_rented_book(Book rented){
        for (Book index : user_book){
            return index.equals(rented);
        }
        return false;
    }

    public ArrayList<Book> users_book_rented(){
        return users_book_rented();
    }
}
