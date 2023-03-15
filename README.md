# Library Management System
In this assignment, you will create an object-oriented Java program that can manage a library. The program should allow users to search for books, borrow and return books, and manage the library inventory. The program should be designed using object-oriented programming principles.
# Implementation
## BOOK
-String name
-String author
-Int year
-String ISBN
+getName()
+getAuthor()
+Int getYear()
+String getISBN()
+setName(String name)
+setAuthor(String author)
+setYear(int year)
+setISBN(String ISBN)
+update_name(String name)
+update_author(String author)
+update_year(int year)
+update_ISBN(String ISBN)
## USER
-ArrayList<Book> user_book
-String username
-String password
+getUsername()
+setUsername(String username)
+getPassword()
+setPassword(String password)
+User(String username, String password)
+boolean vaild_user(String username,String password)
+rentBook(Book book)
+returnBook(Book rented_book)
+boolean in_rented_book(Book rented)
## LIBRARIAN
-String username
-String password
+Librarian(String username, String password)
+String getUsername()
+setUsername(String username)
+String getPassword()
+setPassword(String password)
+boolean valid_librarian(String username,String password)
## LIBRARY
+addBook(String name, String author, int year, String ISBN)
+removeBook(String name, String author, int year, String ISBN)
+searchBook(String name, String ISBN)
+searchBook(String name, int year)
+updateBookName(String name, String ISBN)
+updateBookAuthor(String author, String ISBN)
+updateBookYear(int year, String ISBN)
+doesBookExist(String name)
+doesBookOnGarbage(String ISBN)
+increaseBook(String ISBN)
+decreaseBook(String ISBN)
+addUser(String username, String password)
+removeUser(String username, String password)
+searchUser(String username)
+updateUserUsername(String username1, String username2, String passwrod)
+updateUserPassword(String username, String password1, String passwrod2)
+findUser(String username)
+boolean doesUserExist(String username)
+boolean doesUserPasswrodCorrect(String passwrod)
+addLibrarian(String librarianname, String password)
+removeLibrarian(String librarianname, String password)
+Librarian searchLibrarian(String username)
+updateLibrarianName(String name1, String name2, String password)
+updateLibrarianPassword(String name, String password1, String password2)
+findLibrarian(String username)
+boolean doesLibrarianExist(String librarianname)
+boolean doesLibrarianPasswordCorrect(String passwrod)
# TEST
- I run code and send a lot of diffrence input and see all of tasks accepted
