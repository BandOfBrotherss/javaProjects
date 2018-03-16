import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class DataAccessLayer {
	String author_name;
	int birth_year;
	String birth_place;

	String title;
	String ISBN;
	Genre genre;
	int publishing_year;
	String publisher;
	double price;

	public DataAccessLayer() {
	}

	public void readAuthors(BookShelf bookShelf, AuthorList authorList) throws IOException {

		Path author_file = Paths.get("src/authors.dat");
		Path book_file = Paths.get("src/books.dat");
		Scanner books_scanner = new Scanner(book_file);
		Scanner author_scanner = new Scanner(author_file);
		while (author_scanner.hasNextLine() && books_scanner.hasNextLine()) {

			String author_informations = author_scanner.nextLine();
			String book_informations = books_scanner.nextLine();
			String[] author_info = author_informations.split(",");
			author_name = author_info[0].trim();
			System.out.println(author_name);
			birth_year = Integer.parseInt(author_info[1]);
			birth_place = author_info[2];
			String[] book_info = book_informations.split(",");
			title = book_info[0];
			ISBN = book_info[1];
			genre = Genre.valueOf(book_info[2].toUpperCase());
			publishing_year = Integer.parseInt(book_info[3]);
			publisher = book_info[4];
			price = Double.parseDouble(book_info[5]);
			Author author = new Author(author_name, birth_year, birth_place);
			authorList.setAuthor(author);
			Book book = new Book(title, ISBN, genre, publishing_year, publisher, price);
			book.setAuthors(author);
			author.setBooks(book);
			bookShelf.setBook_shelf(book);
		}
		books_scanner.close();
		author_scanner.close();
	}

}
