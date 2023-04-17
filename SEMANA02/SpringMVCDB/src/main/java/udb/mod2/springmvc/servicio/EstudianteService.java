package udb.mod2.springmvc.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import udb.mod2.springmvc.entidades.Estudiante;
import udb.mod2.springmvc.repositorio.EstudianteRepositoryPlantilla;

@Service
public class EstudianteService {
	@Autowired
	EstudianteRepositoryPlantilla repositorio;

	@Transactional
	public void insertarVarios(Estudiante e1, Estudiante e2) {
		repositorio.insertar(e1);
		repositorio.insertar(e2);
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Estudiante> buscarTodos() {
		return repositorio.buscarTodos();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void insertar(Estudiante estudiante) {
		repositorio.insertar(estudiante);
	}

	@Transactional
	public void borrar(Estudiante estudiante) {
		repositorio.borrar(estudiante);
	}

	@Transactional
	public void actualizar(Estudiante estudiante) {
		repositorio.actualizar(estudiante);
	}

	@Transactional
	public Estudiante buscarUnEstudiante(int codigo) {
		return repositorio.buscarUnEstudiante(codigo);
	}

	@Transactional
	public List<Estudiante> buscarByNombre(String nombre) {
		return repositorio.buscarByNombre(nombre);
	}
}