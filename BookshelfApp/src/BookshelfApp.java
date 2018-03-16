import java.io.IOException;

public class BookshelfApp {
	public static void main(String[] args) throws IOException {
		BookShelf bookShelf = new BookShelf();
		AuthorList authorList = new AuthorList();
		DataAccessLayer data_access = new DataAccessLayer();
		data_access.readAuthors(bookShelf, authorList);
		BookShelfMenu bookShelfMenu = new BookShelfMenu();
		bookShelfMenu.init(bookShelf, authorList);

	}
}
