package udb.mod2.springmvc.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import udb.mod2.springmvc.entidades.Docente;
import udb.mod2.springmvc.entidades.Estudiante;
@Repository
public class EstudianteRepositoryPlantilla {
	@PersistenceContext EntityManager em;
	
	public EstudianteRepositoryPlantilla() {	
		
	}
	
	public List<Estudiante>buscarTodos(){
		TypedQuery<Estudiante> consultaJPA=em.createQuery("SELECT f FROM Estudiante f",Estudiante.class);
		return consultaJPA.getResultList();
	}
	public List<Estudiante> buscarByNombre(String nombre){
		TypedQuery<Estudiante> consultaJPA = em.createQuery(
		"select f from Estudiante f where f.nombre like '%"+nombre+"%'",Estudiante.class);
		return consultaJPA.getResultList();
	}
	
	@Transactional
	public void insertar(Estudiante estudiante) {
		em.persist(estudiante);
	}
	
	@Transactional
	public void borrar(Estudiante estudiante) {
		em.remove(em.merge(estudiante));
	}
	
	@Transactional
	public void actualizar(Estudiante estudiante) {
		em.merge(estudiante);
	}
	
	@Transactional
	public Estudiante buscarUnEstudiante(int codigo) {
	return em.find(Estudiante.class, codigo);
	}
	
	@Transactional
	public Docente buscarDocente(Integer idDocente){
	Docente docenteSelected=null;
	TypedQuery<Docente> query = em.createQuery("select d from Docente d	where d.idDocente=:idDocente",Docente.class);
	query.setParameter("idDocente", idDocente);
	docenteSelected = query.getResultList().get(0);
	return docenteSelected;
	}
	
	@Transactional
	public List<Docente> buscarDocentes(){
	TypedQuery<Docente> docentesJPA = em.createQuery("select d	from Docente d",Docente.class);
	return docentesJPA.getResultList();
	}
}
