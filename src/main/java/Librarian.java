public class Librarian {
    /*
        * The librarian should have a username and a password
        * The librarian should be able to search users, librarians and books
        * The librarian should be able to add\removeupdate user add\removeupdate_
        _ librarian and add\removeupdate book
         */
    private String username,password;
    public Librarian(String username, String password) {
        this.username = username;
        this.password = password;
    }

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

    public boolean valid_librarian(String username,String password) {
        if (this.username.equals(username) && this.password.equals(password)){
            return true;
        }
        else {
            return false;
        }
    }
}
