// Library class for Assignment 4
class Library {
    Book[] books = new Book[20];
    int count = 0;

    void addBook(Book book) {
        if (count < books.length) {
            books[count] = book;
            count++;
            System.out.println("Book added: " + book.title);
        } else {
            System.out.println("Library is full.");
        }
    }

    void searchBook(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].title.equalsIgnoreCase(title)) {
                System.out.println("Book found: " + books[i].title);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    void issueBook(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].title.equalsIgnoreCase(title)) {
                if (!books[i].issued) {
                    books[i].issued = true;
                    System.out.println("Book issued: " + books[i].title);
                } else {
                    System.out.println("Book is already issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    void returnBook(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].title.equalsIgnoreCase(title)) {
                if (books[i].issued) {
                    books[i].issued = false;
                    System.out.println("Book returned: " + books[i].title);
                } else {
                    System.out.println("Book is already available.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    void displayBooks() {
        System.out.println("Available books in library:");
        for (int i = 0; i < count; i++) {
            if (!books[i].issued) {
                books[i].displayBook();
                System.out.println();
            }
        }
    }
}
