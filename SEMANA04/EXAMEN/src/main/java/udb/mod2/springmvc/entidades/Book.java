package udb.mod2.springmvc.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	@Column(name = "IdBook")
	private Integer idBook;
	@Column(name = "Title")
	private String title;
	@Column(name="Author")
	private String author;
	@Column(name="Genre")
	private String genre;
	@Column(name = "Stock")
	private Integer stock;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(Integer idBook) {
		super();
		this.idBook = idBook;
	}

	public Book(Integer idBook, String title, String author, String genre, Integer stock) {
		super();
		this.idBook = idBook;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.stock = stock;
	}

	public Integer getIdBook() {
		return idBook;
	}

	public void setIdBook(Integer idBook) {
		this.idBook = idBook;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

}
