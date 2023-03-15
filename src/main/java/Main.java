import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /*
    * make a functional library app using oop
    * run the main program in Main.java and code the oop part in other classes
    * don't forget to add at least 1 librarian to the library to make it functionable.
    * *  *** don't limit yourself to our template ***
     */
    static Library new_library = new Library();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        runMenu();
    }
    static boolean flag = true;
    public static void runMenu() {
        new_library.addLibrarian("Hooman", "Parsaei");
        new_library.addLibrarian("Amirhossein","Karami");
        new_library.addUser("a","b");
        new_library.addBook("a","a",2022,"1");
        while (flag) {
            System.out.println("----------HELLO---------");
            System.out.println("---WELCOME TO HOOMAN LIBRARY---");
            System.out.println("-----PLS CHOOSE ONE OF THEM-----");
            System.out.println("1-User Login");
            System.out.println("2-Librarian Login");
            System.out.println("3-Signup");
            int switch_case = input.nextInt();
            if (switch_case == 1) {
                System.out.print("Username:");
                input.nextLine();
                String username = input.next();
                System.out.print("Password:");
                String password = input.next();
                if (new_library.doesUserExist(username)) {
                    if (new_library.doesUserPasswrodCorrect(password)) {
                        System.out.println("Welcome To Your Account " + username);
                        user_menu();
                        int inp = input.nextInt();
                        switch (inp) {
                            case 1 -> {
                                System.out.println("PLS ENTER BOOK NAME");
                                String rent_name = input.next();
                                if (new_library.doesBookExist(rent_name)) {
                                    System.out.println("PLS ENTER YEAR");
                                    int year = input.nextInt();
                                    Book book = new_library.searchBook(rent_name, year);
                                    if (new_library.doesBookOnGarbage(book.getISBN())) {
                                        new_library.decreaseBook(book.getISBN());
                                        new_library.searchUser(username).rentBook(book);
                                        System.out.println("YOU RENT BOOK SUCCESSFULLY");
                                    } else {
                                        System.out.println("NO ANY BOOK ON CARBAGE");
                                    }
                                } else {
                                    System.out.println("THAT BOOK IS NOT VALID");
                                }
                            }
                            case 2 -> {
                                System.out.println("PLS ENTER BOOK NAME YOU WANT TO RETURN: ");
                                ArrayList<Book> b = new_library.searchUser(username).users_book_rented();
                                for (Book book : b) {
                                    System.out.println(book);
                                }
                                int num = input.nextInt();
                                new_library.increaseBook(b.get(num).getISBN());
                                new_library.searchUser(username).rentBook(b.get(num));
                                System.out.println("THANK YOU FOR YOUR USAGE");
                            }
                            case 3 -> {
                                return;
                            }
                        }
                    } else {
                        System.out.println("Your Password Is Wrong");
                        System.out.println("PLS Try Again");
                    }
                }
            } else if (switch_case == 2) {
                System.out.print("\nUsername:");
                input.nextLine();
                String username = input.next();
                System.out.print("Password:");
                String password = input.next();
                if (new_library.doesLibrarianExist(username)) {
                    if (new_library.doesLibrarianPasswordCorrect(password)) {
                        System.out.println("Welcome To Your Account " + username);
                        librarian_menu();
                        int inp = input.nextInt();
                        switch (inp) {
                            case 1 -> add_book_menu();
                            case 2 -> remove_book_menu();
                            case 3 -> search_book_menu();
                            case 4 -> update_book_menu();
                            case 5 -> add_user_menu();
                            case 6 -> remove_user_menu();
                            case 7 -> search_user_menu();
                            case 8 -> update_user_menu();
                            case 9 -> add_librarian_menu();
                            case 10 -> remove_librarian_menu();
                            case 11 -> update_librarian_menu();
                            case 12 -> {
                                return;
                            }
                        }
                    }
                }
            } else if (switch_case == 3) {
                sign_up_menu();
            }
            else if (switch_case == 4) {
                flag = false;
            }
        }
    }





    //case 1
    private static void add_book_menu() {
        System.out.print("PLS ENTER BOOK NAME:");
        String add_name = input.next();
        System.out.print("PLS ENTER BOOK AUTHOR:");
        String add_author = input.next();
        System.out.print("PLS ENTER BOOK YEAR:");
        int add_publish_year = input.nextInt();
        System.out.print("PLS ENTER BOOK ISBN:");
        input.nextLine();
        String add_ISBN = input.nextLine();
        if (!new_library.doesBookExist(add_name)) {
            new_library.addBook(add_name, add_author, add_publish_year, add_ISBN);
            System.out.println("BOOK ADDED SUCCESSFULY");
        }
        else {
            System.out.println("BOOK IS EXISTS");
        }
    }
    //case 2
    private static void remove_book_menu() {
        System.out.print("PLS ENTER BOOK NAME:");
        String remove_name = input.next();
        System.out.print("PLS ENTER BOOK AUTHOR:");
        String remove_author = input.next();
        System.out.print("PLS ENTER BOOK YEAR:");
        int remove_publish_year = input.nextInt();
        System.out.print("PLS ENTER BOOK ISBN:");
        input.nextLine();
        String remove_ISBN = input.nextLine();
        if (new_library.doesBookExist(remove_name)) {
            Book remove = new_library.searchBook(remove_name, remove_ISBN);
            new_library.removeBook(remove_name, remove_author, remove_publish_year, remove_ISBN);
            System.out.println("BOOK REMOVED SUCCESSFULLY");
        } else {
            System.out.println("THAT BOOK IS NOT EXISTS");
        }
    }
    //case 3
    private static void search_book_menu() {
        System.out.print("PLS ENTER BOOK NAME:");
        String search_name = input.next();
        System.out.print("PLS ENTER BOOK ISBN:");
        String search_ISBN = input.next();
        if (new_library.doesBookExist(search_name)) {
            System.out.println(new_library.searchBook(search_name, search_ISBN));
        } else {
            System.out.println("THAT BOOK IS NOT EXISTS");
        }
    }
    //case 4
    private static void update_book_menu() {
        System.out.print("PLS ENTER BOOK NAME:");
        String update_name = input.next();
        System.out.print("PLS ENTER BOOK AUTHOR:");
        String update_author = input.next();
        System.out.print("PLS ENTER BOOK YEAR:");
        int update_publish_year = input.nextInt();
        System.out.print("PLS ENTER BOOK ISBN:");
        String update_ISBN = input.next();
        System.out.println("CHOOSE ONE OF THEM: ");
        System.out.println("1-UPDATE NAME OF BOOK");
        System.out.println("2-UPDATE AUTHOR OF BOOK");
        System.out.println("3-UPDATE YEAR OF BOOK");
        input.nextLine();
        int choose = input.nextInt();
        switch (choose) {
            case 1 -> {
                if (new_library.doesBookExist(update_name)) {
                    System.out.println("PLS ENTER NEW NAME OF BOOK:");
                    input.nextLine();
                    String new_name = input.nextLine();
                    new_library.updateBookName(new_name, update_ISBN);
                }
            }
            case 2 -> {
                if (new_library.doesBookExist(update_name)) {
                    System.out.println("PLS ENTER NEW AUTHOR OF BOOK:");
                    input.nextLine();
                    String new_author = input.nextLine();
                    new_library.updateBookAuthor(new_author, update_ISBN);
                }
            }
            case 3 -> {
                if (new_library.doesBookExist(update_name)) {
                    System.out.println("PLS ENTER NEW YEAR OF BOOK:");
                    input.nextLine();
                    int new_year = input.nextInt();
                    new_library.updateBookYear(new_year, update_ISBN);
                }
            }
        }
    }
    //case 5
    private static void add_user_menu() {
        System.out.print("PLS ENTER USERNAME:");
        String add_user_linrarian = input.next();
        input.nextLine();
        System.out.print("PLS ENTER PASSWORD:");
        String add_password_librarian = input.next();
        if (new_library.doesUserExist(add_user_linrarian)) {
            System.out.println("THIS USER IS EXISTS NOW");
        } else {
            new_library.addUser(add_user_linrarian, add_password_librarian);
            System.out.println("USER CREATED SUCCESSFULLY");
        }
    }
    //case 6
    private static void remove_user_menu() {
        System.out.println("PLS ENTER USERNAME:");
        String remove_user_linrarian = input.next();
        System.out.println("PLS ENTER PASSWORD:");
        String remove_password_librarian = input.next();
        if (new_library.doesUserExist(remove_user_linrarian)) {
            new_library.removeUser(remove_user_linrarian, remove_password_librarian);
            System.out.println("USER REMOVED SUCCESSFULLY");
        } else {
            System.out.println("THIS USER IS NOT EXISTS NOW");
        }
    }
    //case 7
    private static void search_user_menu() {
        System.out.print("PLS ENTER USERNAME:");
        String search_user_linrarian = input.next();
        if (new_library.doesUserExist(search_user_linrarian)) {
            System.out.println(new_library.searchUser(search_user_linrarian));
        } else {
            System.out.println("THIS USER IS NOT EXISTS NOW");
        }
    }
    //case 8
    private static void update_user_menu() {
        System.out.print("PLS ENTER USERNAME:");
        String update_user_linrarian = input.next();

        System.out.print("PLS ENTER PASSWORD:");
        String update_password_librarian = input.next();
        if (new_library.doesUserExist(update_user_linrarian)) {
            System.out.println("PLS CHOOSE ON OF THEM:");
            System.out.println("1-UPADTE NAME OF USER");
            System.out.println("2-UPDATE PASSWORD OF USER");
            input.nextLine();
            int c1 = input.nextInt();
            switch (c1) {
                case 1 -> {
                    System.out.print("PLS ENTER NEW USERNAME:");
                    input.nextLine();
                    String new_username = input.nextLine();
                    new_library.updateUserUsername(update_user_linrarian, new_username, update_password_librarian);
                    System.out.println("THE NAME HAS CHANGED SUCCESSFULLY");
                }
                case 2 -> {
                    System.out.print("PLS ENTER NEW PAASWORD:");
                    input.nextLine();
                    String new_password = input.nextLine();
                    new_library.updateUserPassword(update_user_linrarian, update_password_librarian, new_password);
                    System.out.println("THE PASSWORD HAS CHANGED SUCCESSFULLY");
                }
            }
        } else {
            System.out.println("THIS USER IS NOT EXISTS NOW");
        }
    }
    //case 9
    private static void add_librarian_menu() {
        System.out.print("PLS ENTER LIBRARIAN NAME:");
        String add_linrarian = input.next();
        System.out.print("PLS ENTER PASSWORD:");
        String add_passwordlibrarian_librarian = input.next();
        if (!new_library.doesLibrarianExist(add_linrarian)) {
            new_library.addLibrarian(add_linrarian, add_passwordlibrarian_librarian);
            System.out.println("LIBRARIAN CREATED SUCCESSFULLY");
        } else {
            System.out.println("LIBRARIAN IS EXISTS NOW");
        }
    }
    //case 10
    private static void remove_librarian_menu() {
        System.out.print("PLS ENTER LIBRARIAN NAME:");
        String remove_linrarian = input.next();
        System.out.print("PLS ENTER PASSWORD:");
        String remove_passwordlibrarian_librarian = input.next();
        if (new_library.doesLibrarianExist(remove_linrarian)) {
            new_library.removeLibrarian(remove_linrarian,remove_passwordlibrarian_librarian);
            System.out.println("LIBRARIAN REMOVED SUCCESSFULLY");
        } else {
            System.out.println("LIBRARIAN IS NOT EXISTS NOW");
        }
    }
    //case 11
    private static void update_librarian_menu() {
        System.out.print("PLS ENTER LIBRARIAN NAME:");
        String update_linrarian = input.next();
        System.out.print("PLS ENTER PASSWORD:");
        String update_passwordlibrarian_librarian = input.next();
        if (new_library.doesLibrarianExist(update_linrarian)) {
            System.out.println("PLS CHOOSE ON OF THEM: ");
            System.out.println("1-UPADTE NAME OF LIBRARIAN");
            System.out.println("2-UPDATE PASSWORD OF LIBRARIAN");
            int c2 = input.nextInt();
            switch (c2) {
                case 1 -> {
                    System.out.print("PLS ENTER NEW NAME:");
                    input.nextLine();
                    String new_username = input.next();
                    new_library.updateLibrarianName(update_linrarian, new_username, update_passwordlibrarian_librarian);
                    System.out.println("THE NAME HAS CHANGED SUCCESSFULLY");
                }
                case 2 -> {
                    System.out.print("PLS ENTER NEW PAASWORD:");
                    input.nextLine();
                    String new_password = input.next();
                    new_library.updateLibrarianPassword(update_linrarian, update_passwordlibrarian_librarian, new_password);
                    System.out.println("THE PASSWORD HAS CHANGED SUCCESSFULLY");
                }
            }
        } else {
            System.out.println("LIBRARIAN IS NOT EXISTS NOW");
        }
        return;
    }


    public static void sign_up_menu(){
        System.out.println("PLS Enter Your Username:");
        input.nextLine();
        String username = input.nextLine();
        System.out.println("PLS Enter Your Password:");
        String password = input.nextLine();
        if (!new_library.doesUserExist(username)){
            new_library.addUser(username,password);
            System.out.println("USER ADDED SUCCESSFULLY");
        }
        else{
            System.out.println("This Username Had Used Before");
            System.out.println("PLS Enter New Username");
        }
    }


    public static void librarian_menu(){
        System.out.println("1-Add Book");
        System.out.println("2-Remove Book");
        System.out.println("3-Search Book");
        System.out.println("4-Update Book");
        System.out.println("5-Add User");
        System.out.println("6-Remove User");
        System.out.println("7-Search User");
        System.out.println("8-Update User");
        System.out.println("9-Add Librarian");
        System.out.println("10-Remove Librarian");
        System.out.println("11-Update Librarian");
        System.out.println("12-Logout");
    }


    public static void user_menu(){
        System.out.println("1-Rent Book");
        System.out.println("2-Return Book");
        System.out.println("3-Logout");
    }
}
