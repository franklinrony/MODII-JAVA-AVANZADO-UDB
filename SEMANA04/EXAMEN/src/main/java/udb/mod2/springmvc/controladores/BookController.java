package udb.mod2.springmvc.controladores;

import java.io.IOException;
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

import udb.mod2.springmvc.entidades.Book;
import udb.mod2.springmvc.servicio.LibroService;

@Controller
public class BookController {
	@Autowired
	LibroService libroService;
	
	public BookController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("/")
	public String principal(Model modelo) {
		listarLibros(modelo);
		return "listaLibros";
	}

	@RequestMapping("/listaLibros")
	private String listarLibros(Model modelo) {
		// TODO Auto-generated method stub
		List<Book> lista=libroService.buscarTodos();
		modelo.addAttribute("libro", new Book());
		modelo.addAttribute("listaLibros", lista);
		return "listaLibros";
	}

	@RequestMapping("/formularioNuevoLibro")
	public String formularioNuevoLibro(Model modelo) {
	modelo.addAttribute("libro", new Book());
	return "formularioNuevoLibro";
	}
	

	@RequestMapping("/formularioInsertarLibro")
	public String formularioInsertarLibro(Model modelo,
	@ModelAttribute Book libro) {
	libroService.insertar(libro);
	return listarLibros(modelo);
	}
	
	
	@RequestMapping("/borrarLibro")
	public String borrarLibro(@RequestParam("codigo") int idBook,
	Model modelo) {
	libroService.borrar(new Book(idBook));
	return listarLibros(modelo);
	}
	
	@RequestMapping("formularioEditarLibro")
	public @ResponseBody String formularioEditarLibro(@RequestParam("codigo") int
	idBook,Model modelo) throws IOException {
	//generar estudiante con los datos devueltos en la busqueda
	ObjectMapper mapper = new ObjectMapper();
	String resp = "";
	Book libro =libroService.buscarUnLibro(idBook); 
	try {
	resp = mapper.writeValueAsString(libro);
	System.out.println(resp);
	} catch (JsonProcessingException e) {
	}
	//modelo.addAttribute("estudiante",servicio.buscarUnEstudiante(codigo));
	return resp;
	}
	
	@RequestMapping("/formularioGuardarLibro")
	public String formularioGuardarLibroe(Model modelo, @ModelAttribute
	Book libro) {
		libroService.actualizar(libro);
	return listarLibros(modelo);
	}
	
	@RequestMapping("/listaLibrosByNombre")
	public @ResponseBody String listaLibrosByNombre(@RequestParam("term") String
	titulo) {
	List<Book> lista = libroService.buscarByNombre(titulo);
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
}
