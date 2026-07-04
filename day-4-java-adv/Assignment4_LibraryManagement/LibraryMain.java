// Main class for Assignment 4
public class LibraryMain {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book(1, "Java Basics", "Alice");
        Book book2 = new Book(2, "OOP Concepts", "Bob");
        Book book3 = new Book(3, "Database Fundamentals", "Carol");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.searchBook("OOP Concepts");
        library.issueBook("Java Basics");
        library.returnBook("Java Basics");
        library.displayBooks();
    }
}
