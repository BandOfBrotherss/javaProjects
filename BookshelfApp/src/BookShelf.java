import java.util.ArrayList;

public class BookShelf {

	private ArrayList<Book> book_shelf = new ArrayList<Book>();

	public BookShelf() {

	}

	public ArrayList<Book> getBook_shelf() {
		return book_shelf;
	}

	public void setBook_shelf(Book book) {
		book_shelf.add(book);
	}

}
