package udb.mod2.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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

	@RequestMapping("/formularioGuardarEstudiante")
	public String formularioGuardarEstudiante(Model modelo, @ModelAttribute Estudiante estudiante) {
		servicio.actualizar(estudiante);
		return listarEstudiante(modelo);
	}
}