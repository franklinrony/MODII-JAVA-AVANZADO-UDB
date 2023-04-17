package udb.mod2.springmvc.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import udb.mod2.spingmvc.EmpleadoService;
import udb.mod2.spingmvc.EstudianteService;
import udb.mod2.spingmvc.LibroService;
import udb.mod2.springmvc.entidades.Empleado;
import udb.mod2.springmvc.entidades.EncabezadoPrestamo;
import udb.mod2.springmvc.entidades.Estudiante;
import udb.mod2.springmvc.entidades.Libro;

@Controller
public class PrestamoController {
	@Autowired
	LibroService servicio;
	@Autowired
	EstudianteService estServicio;
	@Autowired
	EmpleadoService emplService;
	 List<EncabezadoPrestamo> prestamos=new ArrayList<>();
	 EncabezadoPrestamo prestamo=new EncabezadoPrestamo();
	public PrestamoController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(path="/principal")
	public String menuApp() {
		System.out.println("Entra metodo");
	return "principal";
	}
	
	@RequestMapping("/prestamo")
	public String ListarLibros(Model modelo) {
		modelo.addAttribute("prestamoModel", new EncabezadoPrestamo());
		/*
		 * List<Libro> libros=servicio.lstLibros();
		 * modelo.addAttribute("listaLibros",libros); List<Estudiante>
		 * lstEst=estServicio.listarEstudiantes();
		 * modelo.addAttribute("listaEstudiantes",lstEst); List<Empleado>
		 * lstEmp=emplService.lstEmpleados();
		 * modelo.addAttribute("listaEmpleados",lstEmp);
		 */
		return "prestamos.html";
	}
	
	@RequestMapping(value="/registroPrestamo",params= {"registrarEst"})
	public String registrarPrestamo(@ModelAttribute EncabezadoPrestamo prestamoModel,
	final BindingResult bindingResult) {
		prestamos.add(prestamo);
	return "redirect:/inscritos";
	}
	
	@ModelAttribute("lstPrestamos")
	public List<EncabezadoPrestamo> prestamoLibros(){
	return prestamos;
	}
	
}
