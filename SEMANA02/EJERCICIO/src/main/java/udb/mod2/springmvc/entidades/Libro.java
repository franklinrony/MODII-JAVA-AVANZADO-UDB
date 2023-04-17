package udb.mod2.springmvc.entidades;

public class Libro {
	private String isbn;
	private  String tituto;
	private  String autor;
	private  String edicion;
	public Libro() {
		// TODO Auto-generated constructor stub
	}
	public Libro(String isbn, String tituto, String autor, String edicion) {
		super();
		this.isbn = isbn;
		this.tituto = tituto;
		this.autor = autor;
		this.edicion = edicion;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTituto() {
		return tituto;
	}
	public void setTituto(String tituto) {
		this.tituto = tituto;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEdicion() {
		return edicion;
	}
	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}

}
