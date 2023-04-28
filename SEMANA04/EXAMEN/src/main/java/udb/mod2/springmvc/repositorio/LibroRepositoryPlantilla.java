package udb.mod2.springmvc.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import udb.mod2.springmvc.entidades.Book;

@Repository
public class LibroRepositoryPlantilla {
@PersistenceContext EntityManager em;

	public LibroRepositoryPlantilla() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Book> buscarTodos(){
		TypedQuery<Book> consultaJPA=em.createQuery("SELECT b FROM Book b", Book.class );
		return consultaJPA.getResultList();
	}
	
	public List<Book> buscarByNombre(String nombre){
		TypedQuery<Book> consultaJPA=em.createQuery("SELECT b FROM Book b WHERE b.title '%"+nombre+"%'",Book.class);
		return consultaJPA.getResultList();
	}
	
	@Transactional
	public void insertar(Book book) {
		em.persist(book);
	}
	
	@Transactional
	public void borrar(Book book) {
		em.remove(em.merge(book));
	}
	
	@Transactional
	public void actualizar(Book book) {
		em.merge(book);
	}
	
	@Transactional
	public Book buscarUnLibro(int codigo) {
	return em.find(Book.class, codigo);
	}
	

}
