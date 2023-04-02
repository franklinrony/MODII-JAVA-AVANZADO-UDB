package udb.mod2.springmvc;

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

import udb.mod2.springmvc.entidades.Curso;
import udb.mod2.springmvc.entidades.Estudiante;


@Controller
public class EstudianteController {
	@Autowired
	EstudianteService servicio;
	Estudiante est= new Estudiante();
	List<String> cabeceras = new ArrayList<String>();
	List<String> modalidades = new ArrayList<String>();
	List<String> materias = new ArrayList<String>();
	List<Estudiante> inscritos=new ArrayList<Estudiante>();;
		
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
	
	@RequestMapping("/")
	public String menuApp(Model modelo) {		
		return ListarEstudiantes(modelo);
	}
	
	@RequestMapping("/listaEstudiantes")
	public String ListarEstudiantes(Model modelo) {
		List<Estudiante> lstEst=servicio.listarEstudiantes();
		modelo.addAttribute("listaEstudiantes",lstEst);
		return "/listaEstudiantes";
	}
	
	@RequestMapping("/cursos")
	public String cursos(@ModelAttribute Estudiante estudiante) {	
		estudiante=est;
		return "/tablaDinamica";
	}
	
	@RequestMapping(value="/tablaDinamica",params= {"registrarEst"})
	public String registrarEstudiantes(@ModelAttribute Estudiante estudiante, final BindingResult bindingResult) {
		inscritos.add(estudiante);		
		return "redirect:/cursos";
	}
	
	@RequestMapping(value="/tablaDinamica",params = {"addRow"})
	public String addRow(@ModelAttribute Estudiante estudiante, final BindingResult bindingResult) {	
		estudiante.getLstCursos().add(new Curso());				
		return "/tablaDinamica";		
	}
	
	
	@RequestMapping(value="/tablaDinamica",params = {"removeRow"})
	public String removeRow(@ModelAttribute Estudiante estudiante,final BindingResult bindingResult, final HttpServletRequest req) {
		final Integer rowId = Integer.valueOf(req.getParameter("removeRow"));
		estudiante.getLstCursos().remove(rowId.intValue());
		return "/tablaDinamica";		
	}
	
	@RequestMapping("/practicaCondicionales")
	public String practicaCondicionales(Model modelo) {
		List<Docente> docentes = new ArrayList<Docente>();
		docentes.add(new Docente("JOSE","JOSE.MARTINES@UDB.EDU.SV","CORDINADOR"));
		docentes.add(new Docente("MARIO","MARIO.GAMEZ@UDB.EDU.SV","CORDINADOR"));
		docentes.add(new Docente("RENE","RENE.LOPEZ@UDB.EDU.SV","DOCENTE"));
		docentes.add(new Docente("EDUARDO","EDUARDO.PEREZ@UTEC.EDU.SV","INVITADO"));
		modelo.addAttribute("docenteLogin",docentes.get(0).getNombre());
		modelo.addAttribute("docenteLoginRol",docentes.get(0).getRol());
		modelo.addAttribute("lstDocentes",docentes);
		return "/practicaCondicionales";
		
	}
	
	
	
	@RequestMapping("/practicaThymeleaf")	
	public String practicaThymeleaf(Model modelo) {
		modelo.addAttribute("mensaje","utilizando SpringMVC");
		modelo.addAttribute("docente","Carlos Lemus");
		modelo.addAttribute("correo","carlos.lemus@docente.udb.edu.sv");		
		modelo.addAttribute("fecha",  new Date());
		return "/practicaThymeleaf";
	}
	
	@RequestMapping("/radioButtons")
	public String desplegarRadioButoons(Model modelo) {
		List<String> colors= new ArrayList<String>();
		colors.add("ROJO");
		colors.add("AMARILLO");
		colors.add("VERDE");
		colors.add("AZUL");		
		modelo.addAttribute("allSampleColors",colors);
		modelo.addAttribute("sampleCheckboxes", new SampleCheckboxes());
		return ("/radioButtons");
	}
	
	@RequestMapping("/sampleCheckboxes")
	public String sampleCheckboxes(@ModelAttribute SampleCheckboxes simple,Model modelo) {
		for(String color: simple.getColors()) {
			System.out.println(color);
		}
		modelo.addAttribute("colorSelected",simple.getColors());
		modelo.addAttribute("first",simple.getFirst());
		modelo.addAttribute("second",simple.getSecond());
		return "/sampleCheckboxes";
	}
		
}



