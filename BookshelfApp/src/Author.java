import java.util.ArrayList;
import java.util.regex.Pattern;

public class Author {

	private String name;
	private int birth_year;
	private String birth_place;
	private ArrayList<Book> books = new ArrayList<Book>();

	public Author(String name, int birth_year, String birth_place) {
		setName(name);
		setBirth_year(birth_year);
		setBirth_place(birth_place);

	}

	public String getName() {
		return name;
	}

	public boolean setName(String name) {
		if (Pattern.matches("[ A-Za-z]+", name)) {
			this.name = name;
			return true;
		} else {
			return false;
		}
	}

	public int getBirth_year() {
		return birth_year;
	}

	public boolean setBirth_year(int birth_year) {
		if (Pattern.matches("[0-9]+", String.valueOf(birth_year))) {
			this.birth_year = birth_year;
			return true;
		} else {
			return false;
		}
	}

	public String getBirth_place() {
		return birth_place;
	}

	public boolean setBirth_place(String birth_place) {
		if (Pattern.matches("[ A-Za-z]+",birth_place)) {
			this.birth_place = birth_place;
			return true;
		} else {
			return false;
		}
	}

	public ArrayList<Book> getBooks() {
		return books;
	}

	public void setBooks(Book book) {
		books.add(book);
	}

}
