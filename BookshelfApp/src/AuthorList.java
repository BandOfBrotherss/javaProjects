import java.util.ArrayList;

public class AuthorList {
	
	private ArrayList<Author> authors = new ArrayList<Author>();

	public AuthorList(){
		
	}
	public ArrayList<Author> getAuthors() {
		return authors;
	}

	public void setAuthor(Author author) {
		authors.add(author);
	}
	
	
}
