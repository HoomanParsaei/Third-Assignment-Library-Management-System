import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Library {
    /*
    * The library should have a list of books.
    * The library should have a map of books ISBNs which is linked to the amount of book
    -> (for example: harry potter -> 4 means there are currently 4 harry potter books)
    * The library should have a list of users and a list of librarians.
     */

    //book related functions
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();
    ArrayList<Librarian> librarians = new ArrayList<>();
    HashMap<String, Integer> save_ISBN = new HashMap<>();

    public void addBook(String name, String author, int year, String ISBN) {
        Book new_book = new Book(name, author, year, ISBN);
        books.add(new_book);
        increaseBook(ISBN);
    }

    public void removeBook(String name, String author, int year, String ISBN) {
        Book remove_book = new Book(name, author, year, ISBN);
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equals(name) && books.get(i).getAuthor().equals(author) && books.get(i).getYear() == year && Objects.equals(books.get(i).getISBN(), ISBN)) {
                books.remove(remove_book);
                save_ISBN.remove(ISBN);
                break;
            }
        }
    }

    public Book searchBook(String name, String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN) && book.getName().equals(name)) {
                return book;
            }
        }
        return null;
    }

    public Book searchBook(String name, int year) {
        for (Book book : books) {
            if (book.getName().equals(name) && book.getYear() == year) {
                return book;
            }
        }
        return null;
    }

    public void updateBookName(String name, String ISBN) {
        for (Book ob : books) {
            if (ob.getISBN().equals(ISBN)) {
                ob.setName(name);
            }
        }
    }

    public void updateBookAuthor(String author, String ISBN) {
        for (Book ob : books) {
            if (ob.getISBN().equals(ISBN)) {
                ob.setAuthor(author);
            }
        }
    }

    public void updateBookYear(int year, String ISBN) {
        for (Book ob : books) {
            if (ob.getISBN().equals(ISBN)) {
                ob.setYear(year);
            }
        }
    }

    public boolean doesBookExist(String name) {
        for (Book ob : books) {
            if (ob.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean doesBookOnGarbage(String ISBN) {
        return save_ISBN.get(ISBN) >= 0;
    }

    public void increaseBook(String ISBN) {
        if (!save_ISBN.containsKey(ISBN)) {

            save_ISBN.put(ISBN, 1);
        } else {

            save_ISBN.replace(ISBN, save_ISBN.get(ISBN) + 1);
        }
        System.out.println("Amount of book has been successfully increased");
    }

    public void decreaseBook(String ISBN) {
        save_ISBN.replace(ISBN, save_ISBN.get(ISBN) - 1);
        System.out.println("Amount of book has been successfully decreased");
    }

    //user related functions

    public void addUser(String username, String password) {
        User new_user = new User(username, password);
        users.add(new_user);
    }

    public void removeUser(String username, String password) {
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getUsername().equals(username) && users.get(i).getPassword().equals(password)){
                users.remove(i);
                break;
            }
        }
    }

    public User searchUser(String username) {
        for (User ob : users) {
            if (ob.getUsername().equals(username)) {
                return ob;
            }
        }
        return null;
    }

    public void updateUserUsername(String username1, String username2, String passwrod) {
        for (User ob : users) {
            if (ob.getUsername().equals(username1) && ob.getPassword().equals(passwrod)) {
                ob.setUsername(username2);
            }
        }
    }

    public void updateUserPassword(String username, String password1, String passwrod2) {
        for (User ob : users) {
            if (ob.getUsername().equals(username) && ob.getPassword().equals(password1)) {
                ob.setPassword(password1);
            }
        }
    }
    public int findUser(String username){
        for (int i=0;i<users.size();i++){
            if (users.get(i).getUsername().equals(username)){
                return i;
            }
        }
        return -1;
    }
    public boolean doesUserExist(String username) {
        return findUser(username)>=0;
    }

    public boolean doesUserPasswrodCorrect(String passwrod) {
        for (User ob : users) {
            if (ob.getPassword().equals(passwrod)) {
                return true;
            }
        }
        return false;
    }
    //librarian related functions

    public void addLibrarian(String librarianname, String password) {
        Librarian new_librarian = new Librarian(librarianname, password);
        this.librarians.add(new_librarian);
    }

    public void removeLibrarian(String librarianname, String password) {
        for(int i = 0; i < librarians.size(); i++){
            if(librarians.get(i).getUsername().equals(librarianname) && librarians.get(i).getPassword().equals(password)){
                librarians.remove(i);
                break;
            }
        }
    }

    public Librarian searchLibrarian(String username) {
        for (Librarian ob : librarians) {
            if (ob.getUsername().equals(username)) {
                return ob;
            }
        }
        return null;
    }

    public void updateLibrarianName(String name1, String name2, String password) {
        for (Librarian ob : librarians) {
            if (ob.getUsername().equals(name1) && ob.getPassword().equals(password)) {
                ob.setUsername(name2);
            }
        }
    }

    public void updateLibrarianPassword(String name, String password1, String password2) {
        for (Librarian ob : librarians) {
            if (ob.getUsername().equals(name) && ob.getPassword().equals(password1)) {
                ob.setPassword(password2);
            }
        }
    }

    public int findLibrarian(String username){
        for (int i=0;i<librarians.size();i++){
            if (librarians.get(i).getUsername().equals(username)){
                return i;
            }
        }
        return -1;
    }
    public boolean doesLibrarianExist(String librarianname) {
        return findLibrarian(librarianname)>=0;
    }

    public boolean doesLibrarianPasswordCorrect(String passwrod) {
        for (Librarian ob : librarians) {
            if (ob.getPassword().equals(passwrod))
                return true;
        }
        return false;
    }


}
