import java.util.ArrayList;
import java.util.regex.Pattern;

public class Book {
	private String title;
	private String ISBN;
	private Genre genre;
	private int publishing_year;
	private String publisher;
	private double price;
	private ArrayList<Author> authors = new ArrayList<Author>();

	public Book(String title, String ISBN, Genre genre, int publishing_year, String publisher, double price) {
		setTitle(title);
		setISBN(ISBN);
		setGenre(genre);
		setPublishing_year(String.valueOf(publishing_year));
		setPublisher(publisher);
		setPrice(String.valueOf(price));

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getISBN() {
		return ISBN;
	}

	public boolean setISBN(String iSBN) {
		if (Pattern.matches(
				"^(?:ISBN(?:-13)?:? )?(?=[0-9]{13}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)97[89][- ]?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9]$",
				iSBN)) {
			this.ISBN = iSBN;
			return true;
		} else {
			return false;
		}

	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;

	}

	public int getPublishing_year() {
		return publishing_year;
	}

	public boolean setPublishing_year(String publishing_year) {
		if (Pattern.matches("[0-9]+",publishing_year)) {
			this.publishing_year = Integer.valueOf(publishing_year);
			return true;
		} else {
			return false;
		}
	}

	public String getPublisher() {
		return publisher;
	}

	public boolean setPublisher(String publisher) {
		if (Pattern.matches("[ A-Za-z]+", publisher)) {
			this.publisher = publisher;
			return true;
		} else {
			return false;
		}
	}

	public double getPrice() {
		return price;
	}

	public boolean setPrice(String price) {
		if (Pattern.matches("[.,0-9]+", price)) {
			this.price = Double.valueOf(price);
			return true;
		} else {
			return false;
		}
	}

	public ArrayList<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Author author) {
		authors.add(author);
	}
}