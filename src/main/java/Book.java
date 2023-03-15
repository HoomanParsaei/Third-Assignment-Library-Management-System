public class Book {
    //Book should contain name,author,year of publish and ISBN
    private String name;
    private String author;
    private int year;
    private String ISBN;
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    private void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void update_name(String name){
        this.name = name;
    }
    public void update_author(String author){
        this.author = author;
    }
    public void update_year(int year){
        this.year = year;
    }
    public void update_ISBN(String ISBN){
        this.ISBN = ISBN;
    }
    public Book(String name, String author, int year, String ISBN) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.ISBN = ISBN;
    }
}
