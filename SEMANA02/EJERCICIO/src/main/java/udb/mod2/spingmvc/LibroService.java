package udb.mod2.spingmvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import udb.mod2.springmvc.entidades.Libro;

@Service
public class LibroService {

	public LibroService() {
		// TODO Auto-generated constructor stub
	}

	public List<Libro> lstLibros(){
		List<Libro> libros=new ArrayList<>();
		libros.add(new Libro("asb232", "Java 8", "Deitel", "10 ed"));
		libros.add(new Libro("asb232", "La guia definitiva de Java", "HERBERT SCHILDT", "8 ed"));
		libros.add(new Libro("asb245", "PROGRAMACIÓN ORIENTADA A OBJETOS CON JAVA. UNA INTRODUCCIÓN PRÁCTICA USANDO BLUEJ", "DAVID J. BARNES MICHAEL KÖLLING", "10 ed"));
		libros.add(new Libro("asb298", "Aprender PHP, MySQL y JavaScrip", "Robin Nixon", "10 ed"));
		return libros;
	}
}
