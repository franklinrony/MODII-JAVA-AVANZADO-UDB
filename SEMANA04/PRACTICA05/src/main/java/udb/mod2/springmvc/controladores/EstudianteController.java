package udb.mod2.springmvc.controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import udb.mod2.springmvc.dtos.CursoDTO;
import udb.mod2.springmvc.entidades.Curso;
import udb.mod2.springmvc.entidades.Docente;
import udb.mod2.springmvc.entidades.Estudiante;
import udb.mod2.springmvc.servicio.EstudianteService;

@Controller
public class EstudianteController {
	@Autowired
	EstudianteService servicio;
	@RequestMapping("/")
	public String menuApp(Model modelo) {
	listarEstudiante(modelo);
	return "listaEstudiantes";
	}
	@RequestMapping("/listaEstudiantes")
	public String listarEstudiante(Model modelo) {
	List<Estudiante> lista = servicio.buscarTodos();
	modelo.addAttribute("estudiante", new Estudiante());
	modelo.addAttribute("listaEstudiantes", lista);
	return "listaEstudiantes";
	}
	
	@RequestMapping("/formularioNuevoEstudiante")
	public String formularioNuevoEstudiante(Model modelo) {
	modelo.addAttribute("estudiante", new Estudiante());
	return "formularioNuevoEstudiante";
	}
	@RequestMapping("/formularioInsertarEstudiante")
	public String formularioInsertarEstudiante(Model modelo,
	@ModelAttribute Estudiante estudiante) {
	servicio.insertar(estudiante);
	return listarEstudiante(modelo);
	}
	@RequestMapping("/borrarEstudiante")
	public String borrarEstudiante(@RequestParam("codigo") int codigo,
	Model modelo) {
	servicio.borrar(new Estudiante(codigo));
	return listarEstudiante(modelo);
	}
	
	@RequestMapping("formularioEditarEstudiante")
	public @ResponseBody String formularioEditarEstudiante(@RequestParam("codigo") int
	codigo,Model modelo) throws IOException {
	//generar estudiante con los datos devueltos en la busqueda
	ObjectMapper mapper = new ObjectMapper();
	String resp = "";
	Estudiante estudiante = servicio.buscarUnEstudiante(codigo);
	try {
	resp = mapper.writeValueAsString(estudiante);
	System.out.println(resp);
	} catch (JsonProcessingException e) {
	}
	//modelo.addAttribute("estudiante",servicio.buscarUnEstudiante(codigo));
	return resp;
	}
	
	@RequestMapping("/formularioGuardarEstudiante")
	public String formularioGuardarEstudiante(Model modelo, @ModelAttribute
	Estudiante estudiante) {
	servicio.actualizar(estudiante);
	return listarEstudiante(modelo);
	}
	
	@RequestMapping("/listaEstudiantesByNombre")
	public @ResponseBody String listaEstudiantesByNombre(@RequestParam("term") String
	nombre) {
	List<Estudiante> lista = servicio.buscarByNombre(nombre);
	ObjectMapper mapper = new ObjectMapper();
	String resp="";
	try {
	resp = mapper.writeValueAsString(lista);
	System.out.println(resp);
	} catch (Exception e) {
	// TODO: handle exception
	}
	return resp;
	}
	
	@ModelAttribute("docentes")
	public List<Docente> docentes() {
	return servicio.buscarDocentes();
	}
	
	@RequestMapping("/pruebaAjax")
	public String formularioGuardarEstudiante() {	
	return "practicasAjax";
	}
	
	@RequestMapping("/listaCursosByNombre")
	public @ResponseBody String listaCursosByNombre(@RequestParam("idDocente") Integer
	idDocente) throws IOException {
	Docente doc = servicio.obtenerDocente(idDocente);
	List<CursoDTO> lista = new ArrayList<CursoDTO>();
	System.out.println(doc);
	for (Curso curso : doc.getLstCursos()) {
	curso.setIdDocente(doc);
	lista.add(new CursoDTO(curso.getIdCurso(),curso.getCurso()));
	}
	ObjectMapper mapper = new ObjectMapper();
	String resp="";
	try {
	resp = mapper.writeValueAsString(lista);
	System.out.println(resp);
	} catch (Exception e) {
	// TODO: handle exception
	System.out.println(e.getMessage());
	}
	return resp;
	}
}
