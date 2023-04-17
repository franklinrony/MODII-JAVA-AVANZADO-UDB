package udb.mod2.springmvc.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import udb.mod2.spingmvc.EstudianteService;
import udb.mod2.springmvc.entidades.Curso;
import udb.mod2.springmvc.entidades.Docente;
import udb.mod2.springmvc.entidades.Estudiante;

@Controller
public class EstudianteController {
	@Autowired
	EstudianteService servicio;
	Estudiante est= new Estudiante();
	List<String> cabeceras = new ArrayList<String>();
	List<String> modalidades = new ArrayList<String>();
	List<String> materias = new ArrayList<String>();
	List<Estudiante> inscritos=new ArrayList<Estudiante>();
	
	@ModelAttribute("generos")
	public List<String> generos() {
	return Arrays.asList("Masculino","Femenino");
	}
	@ModelAttribute("lstInscritos")
	public List<Estudiante> estRegistrados(){
	return inscritos;
	}
	@ModelAttribute("materias")
	public List<String> lstMaterias(){
	return Arrays.asList("MATEMATICAS","INGLES","CIENCIAS");
	}
	@ModelAttribute("modalidades")
	public List<String> lstModalidades(){
	return Arrays.asList("PRESENCIAL","VIRTUAL","SEMIPRESENCIAL");
	}
	
	
	@RequestMapping(path="/")
	public String menuApp() {
	return "menu";
	}
	
	@RequestMapping(path="/listaEstudiantes")
	public String ListarEstudiantes(Model modelo) {
		List<Estudiante> lstEst=servicio.listarEstudiantes();
		modelo.addAttribute("listaEstudiantes",lstEst);
		return "listaEstudiantes";
	}
	
	@RequestMapping("/practicaMensajes")
	public String menuApp(Model modelo) {
		modelo.addAttribute("mensaje", "utilizando SpringMVC");
		modelo.addAttribute("docente", "Carlos Lemus");
		modelo.addAttribute("correo","carlos.lemus@docente.udb.edu.sv");
		modelo.addAttribute("fecha",new Date());
		return "practicaMensajes.html";
	}
	
	@RequestMapping("/condiciones")
	public String practicaCondicionales(Model modelo){
		List<Docente> docentes=new ArrayList<>();
		docentes.add(new Docente("JOSE","JOSE.MARTINEZ@UDB.EDU.SV","CORDINADOR"));
		docentes.add(new Docente("MARIO","MARIO.GAMEZ@UDB.EDU.SV","CORDINADOR"));
		docentes.add(new Docente("RENE","RENE.LOPEZ@UDB.EDU.SV","DOCENTE"));
		docentes.add(new Docente("EDUDARDO","EDUARDO.PEREZ@UDB.EDU.SV","INVITADO"));
		modelo.addAttribute("docenteLogin",docentes.get(0).getNombre());
		modelo.addAttribute("docenteLoginRol",docentes.get(0).getRol());
		modelo.addAttribute("lstDocentes",docentes);
		return "condiciones";
	}
	@RequestMapping("/registro")
	public String registro(Model modelo,@ModelAttribute Estudiante estudiante) {
	estudiante=est;
	inscritos.clear();
	return "registros";
	}
	//limpia estudiante
	@RequestMapping("/inscritos")
	public String cursos(@ModelAttribute Estudiante estudiante) {
	estudiante=est;
	return "registros";
	}
	@RequestMapping(value="/registros",params= {"registrarEst"})
	public String registrarEstudiantes(@ModelAttribute Estudiante estudiante,
	final BindingResult bindingResult) {
	inscritos.add(estudiante);
	return "redirect:/inscritos";
	}
	@RequestMapping(value="/registros",params = {"addRow"})
	public String addRow(@ModelAttribute Estudiante estudiante, final
	BindingResult bindingResult) {
	estudiante.getLstCursos().add(new Curso());
	return "registros";
	}
	@RequestMapping(value="/registros",params = {"removeRow"})
	public String removeRow(@ModelAttribute Estudiante estudiante,final
	BindingResult bindingResult, final HttpServletRequest req) {
	final Integer rowId = Integer.valueOf(req.getParameter("removeRow"));
	estudiante.getLstCursos().remove(rowId.intValue());
	return "registros";
	}
}
