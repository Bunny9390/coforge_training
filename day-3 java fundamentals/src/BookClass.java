public class BookClass {

	int bookId;
	String title;
	String author;
	double price;

	BookClass(int bookId, String title, String author, double price) {
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.price = price;
	}

	void display() {
		System.out.println("Book ID : " + bookId);
		System.out.println("Title   : " + title);
		System.out.println("Author  : " + author);
		System.out.println("Price   : " + price);
	}

	public static void main(String[] args) {

		BookClass b = new BookClass(101, "Java", "bunny", 450);

		b.display();
	}
}