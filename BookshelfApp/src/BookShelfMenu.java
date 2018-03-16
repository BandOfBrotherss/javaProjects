import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BookShelfMenu {
	public BookShelfMenu() {

	}

	public void init(BookShelf bookShelf, AuthorList authorList) {
		Scanner keyboard = new Scanner(System.in);
		Scanner values = new Scanner(System.in);
		boolean check = true;
		while (check) {
			System.out.println("------Menu------");
			System.out.println("1.Add book to bookshelf");
			System.out.println("2.Remove book from bookshelf");
			System.out.println("3.Search book by genre");
			System.out.println("4.Search book by publishing year");
			System.out.println("5.Search book by author name");
			System.out.println("6.Search book by price");
			System.out.println("7.Calculate total price of books in the bookshelf");
			System.out.println("8.Calculate total price of books by author");
			System.out.println("-----------------");
			System.out.println("Enter 0 to exit !");
			int input = keyboard.nextInt();
			switch (input) {
			case 0:
				check = false;
				break;
			case 1:
				addBook(bookShelf, authorList);
				break;
			case 2:
				System.out.println("Enter the ISBN number of book that you want to remove : ");
				String ISBN = values.next();
				
				if (!Pattern.matches(
						"^(?:ISBN(?:-13)?:? )?(?=[0-9]{13}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)97[89][- ]?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9]$",
						ISBN)) {
					while (!Pattern.matches(
							"^(?:ISBN(?:-13)?:? )?(?=[0-9]{13}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)97[89][- ]?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9]$",
							ISBN)) {
						System.out.println("Invalid ISBN number.Please try again :");
						ISBN = values.nextLine();
					}
					
				}
				removeBook(ISBN, bookShelf, authorList);
				break;
			case 3:
				System.out.println("Please enter genre : ");
				String genre = values.nextLine().toUpperCase();
				boolean flag = contains(genre);
				if (flag) {
					searchByGenre(Genre.valueOf(genre), bookShelf);
				}
				if (!flag) {
					while (!flag) {
						System.out.println("Invalid genre. Please try again");
						genre = values.next().toUpperCase();
						flag = contains(genre);
					}
					searchByGenre(Genre.valueOf(genre), bookShelf);

				}

				break;
			case 4:
				System.out.println("Please enter the publishing year :");
				int publishing_year = values.nextInt();
				if (!Pattern.matches("[0-9]+", String.valueOf(publishing_year))) {
					System.out.println("Invalid publishing year. Please try again :");
				} else
					;
				searchBy_publishingYear(publishing_year, bookShelf);
				break;
			case 5:
				System.out.println("please enter the author name :");
				String name = values.nextLine();
				if (!Pattern.matches("[ A-Za-z]+", name)) {
					System.out.println("Invalid author name. Please try again");
				} else{
					
				searchByAuthor(name, authorList);}
				break;
			case 6:
				System.out.println("please enter the price :");
				double price = values.nextDouble();
				if (!Pattern.matches("[.,0-9]+", String.valueOf(price))) {
					System.out.println("Invalid price. Please try again");
				} else {
					searchByPrice(price, bookShelf);
				}
				break;
			case 7:
				calculateTotalPriceofBooksin_bookshelf(bookShelf);
				break;
			case 8:
				System.out.println("Please enter the author name :");
				String author_name = values.nextLine();
				if (!Pattern.matches("[ A-Za-z]+", author_name)) {
					while (!Pattern.matches("[ A-Za-z]+", author_name))
						System.out.println("Invalid name. please try again.");
					author_name = values.nextLine();
				}
				calculateTotalPriceofAuthor_books(author_name, authorList);
				break;

			}
		}
	}

	public void addBook(BookShelf bookshelf, AuthorList author_list) {

		ArrayList<Book> book_shelf = bookshelf.getBook_shelf();
		ArrayList<Author> authors_list = author_list.getAuthors();

		Book new_book = new Book("", "", Genre.ADVENTURE, 1900, "", 10.0);
		Author new_author = new Author("", 1900, "");

		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter the title of the book.");
		String title = keyboard.nextLine();
		boolean flag = false;
		for (Book book : book_shelf) {

			if (title == book.getTitle()) {
				System.out.println("This book is already in bookshelf");
				flag = true;
			}
		}
		if (!flag) {
			new_book.setTitle(title);
			System.out.println("Please enter the ISBN number of the book");
			String ISBN = keyboard.next();
			if (new_book.setISBN(ISBN) == false) {
				while (new_book.setISBN(ISBN) == false) {
					System.out.println("Inavlid ISBN number.Please try again :");
					ISBN = keyboard.next();
					new_book.setISBN(ISBN);
				}
			}
			System.out.println("Please enter the genre of the book");
			String type = keyboard.next().toUpperCase();
			boolean check = contains(type);
			if(check){
				new_book.setGenre(Genre.valueOf(type));
			}else{
				while(!check){
					System.out.println("Invalid enum. Please try again :");
					type=keyboard.next().toUpperCase();
					check=contains(type);
				}
				new_book.setGenre(Genre.valueOf(type));
			}
			
			
		
			System.out.println("Please enter the publishing year of the book");
			String publishing_year = keyboard.next();
			if (new_book.setPublishing_year(publishing_year) == false) {
				while (new_book.setPublishing_year(publishing_year) == false) {
					System.out.println("Invalid publishing year.Please try again :");
					publishing_year = keyboard.next();
					new_book.setPublishing_year(publishing_year);
				}
			}
			System.out.println("Please enter the publisher of the book");
			String publisher = keyboard.next();
			if (new_book.setPublisher(publisher)) {
				while (new_book.setPublisher(publisher) == false) {
					System.out.println("Invalid publisher.Please try again :");
					publisher = keyboard.next();
					new_book.setPublisher(publisher);
				}
			}
			System.out.println("Please enter the price of the book");
			String price = keyboard.next();
			if (new_book.setPrice(price) == false) {
				while (new_book.setPrice(price) == false) {
					System.out.println("Invalid price.Please try again :");
					price = keyboard.next();
					new_book.setPrice(price);
				}
			}
			boolean control = false;
			while (control==false) {
				System.out.println("Please enter the name of the book's author.");
				Scanner sc = new Scanner(System.in);
				String name = sc.nextLine();
				for (Author author : authors_list) {
					if (name == author.getName()) {
						author.setBooks(new_book);
						new_book.setAuthors(author);
						book_shelf.add(new_book);
					} else {
						
						System.out.println("Please enter the name of author");
						String name_of_new_author = sc.nextLine();
						if (new_author.setName(name_of_new_author) == false) {
							while (!new_author.setName(name_of_new_author)) {
								System.out.println("Invalid name. Please try again :");
								name_of_new_author = sc.nextLine();
								new_author.setName(name_of_new_author);
							}
						}
						System.out.println("Please enter the birth year of the author");
						int birth_year_of_new_author = keyboard.nextInt();
						if (new_author.setBirth_year(birth_year_of_new_author) == false) {
							while (new_author.setBirth_year(birth_year_of_new_author) == false) {
								System.out.println("Invalid birth year.Please try again :");
								birth_year_of_new_author = keyboard.nextInt();
								new_author.setBirth_year(birth_year_of_new_author);
							}
						}
						System.out.println("Please enter the birth place of the author");
						String birt_place_of_new_author = sc.nextLine();
						if (new_author.setBirth_place(birt_place_of_new_author) == false) {
							while (new_author.setBirth_place(birt_place_of_new_author) == false) {
								System.out.println("Invalid birth place.Please try again :");
								birt_place_of_new_author = sc.nextLine();
								new_author.setBirth_place(birt_place_of_new_author);
							}
						}
						new_author.setBooks(new_book);
						new_book.setAuthors(new_author);
						break;
						
						
						
						
					}	
						
					}
					System.out.println("Another author ?(y or n)");
					String s = sc.nextLine().trim();
					if(s.equals("y")){
						continue;
					}else if(s.equals("n")){
						System.out.println("grdi");
						break;
					}	
					
				
				
				
			}
			book_shelf.add(new_book);
		}
	}

	public void removeBook(String ISBN, BookShelf bookshelf, AuthorList authorlist) {
		Iterator<Book> book_iterator = bookshelf.getBook_shelf().iterator();
		Iterator<Author> author_iterator = authorlist.getAuthors().iterator();
		boolean flag = false;
		while (book_iterator.hasNext()) {
			Book book = book_iterator.next();
			if (book.getISBN().equals(ISBN)) {
				ArrayList<Author> authors = book.getAuthors();
				for (Author author : authors) {
					if (author.getBooks().size() == 1) {
						while (author_iterator.hasNext()) {
							if (author_iterator.equals(author)) {
								author_iterator.remove();
							} else {
								author_iterator.next();
							}
						}
					} else {
						while (author_iterator.hasNext()) {
							if (author_iterator.equals(author)) {
								author.getBooks().remove(book);
							} else {
								author_iterator.next();
							}
						}

						book_iterator.remove();
						flag = true;
						System.out.println("Book removed succesfully !");
						break;
					}

				}
				if (!flag) {
					System.out.println("No matching book!");
				}
			}
		}
	}

	public void searchByAuthor(String author_name, AuthorList authorlist) {
		for (Author author : authorlist.getAuthors()) {
			if (author.getName()==author_name.trim()) {
				for (Book book : author.getBooks()) {
					System.out.println("girdi1");
					System.out.println(book.getTitle());
				}
			}
		}
	}

	public void searchByGenre(Genre genre, BookShelf bookshelf) {
		for (Book book : bookshelf.getBook_shelf()) {
			if (book.getGenre().equals(genre)) {
				System.out.println(book.getTitle());
			}
		}
	}

	public void searchBy_publishingYear(int publishingYear, BookShelf bookshelf) {
		for (Book book : bookshelf.getBook_shelf()) {
			if (book.getPublishing_year() == publishingYear) {
				System.out.println(book.getTitle());
			}
		}
	}

	public void searchByPrice(double price, BookShelf bookshelf) {
		for (Book book : bookshelf.getBook_shelf()) {
			if (book.getPrice() == price) {
				System.out.println(book.getTitle());
			}
		}

	}

	public void calculateTotalPriceofBooksin_bookshelf(BookShelf bookshelf) {
		double total_price = 0;
		for (Book book : bookshelf.getBook_shelf()) {
			total_price += book.getPrice();
		}
		System.out.println("Total price of books in the bookshelf is $" + total_price);
	}

	public void calculateTotalPriceofAuthor_books(String author_name, AuthorList author_list) {
		double total_price = 0;
		for (Author author : author_list.getAuthors()) {
			if (author.getName().toUpperCase().intern() == (author_name.toUpperCase().intern())) {
				System.out.println("girdi");
				System.out.println(author.getBooks());
				for (Book book : author.getBooks()) {
					System.out.println(book.getTitle());
					total_price += book.getPrice();
					System.out.println(total_price);
				}
			}
		}
		System.out.println(author_name + "'s books' total price is $" + total_price);
	}

	public static boolean contains(String type) {
		for (Genre genre : Genre.values()) {
			if (genre.name().equals(type)) {
				return true;
			}
		}

		return false;
	}
}
