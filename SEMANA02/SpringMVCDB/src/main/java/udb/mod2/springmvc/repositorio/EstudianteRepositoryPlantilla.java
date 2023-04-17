	package udb.mod2.springmvc.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import udb.mod2.springmvc.entidades.Estudiante;

@Repository
public class EstudianteRepositoryPlantilla {
	@PersistenceContext
	private EntityManager em;

	public List<Estudiante> buscarTodos(){
		TypedQuery<Estudiante> consultaJPA = em.createQuery("select f from Estudiante f",Estudiante.class);
		return consultaJPA.getResultList();
	}
	
	public List<Estudiante> buscarByNombre(String nombre){
		TypedQuery<Estudiante> consultaJPA = em.createQuery("select f from Estudiante f where f.nombre like '%"+nombre+"%'",Estudiante.class);
		return consultaJPA.getResultList();
	}

	@Transactional
	public void insertar(Estudiante estudiante) {
		em.persist(estudiante);
	}

	@Transactional
	public void borrar(Estudiante estudiante) {
//actualiza y luego elimina
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
}
