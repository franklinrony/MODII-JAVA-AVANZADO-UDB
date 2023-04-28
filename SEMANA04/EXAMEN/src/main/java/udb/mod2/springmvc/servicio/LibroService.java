package udb.mod2.springmvc.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import udb.mod2.springmvc.entidades.Book;
import udb.mod2.springmvc.repositorio.LibroRepositoryPlantilla;

@Service
public class LibroService {
	@Autowired 
	LibroRepositoryPlantilla repositorio;
	

	public LibroService() {
		// TODO Auto-generated constructor stub
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Book> buscarTodos(){
		return repositorio.buscarTodos();
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void insertar(Book book) {
	repositorio.insertar(book);
	}
	
	@Transactional
	public void borrar(Book book) {
	repositorio.borrar(book);
	}
	
	@Transactional
	public void actualizar(Book book) {
	repositorio.actualizar(book);
	}
	
	@Transactional
	public Book buscarUnLibro(int codigo) {
	return repositorio.buscarUnLibro(codigo);
	}
	
	@Transactional
	public List<Book> buscarByNombre(String nombre) {
	return repositorio.buscarByNombre(nombre);
	}
	
}
