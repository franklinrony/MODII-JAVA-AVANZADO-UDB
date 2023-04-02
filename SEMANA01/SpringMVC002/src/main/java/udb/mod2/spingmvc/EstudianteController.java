package udb.mod2.spingmvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EstudianteController {
	@Autowired
	EstudianteService servicio;
	
	@RequestMapping(path="/")
	public String menuApp(Model modelo) {
		System.out.println("Entra metodo");
		return ListarEstudiantes(modelo);
	}
	
	@RequestMapping(path="/listaEstudiantes")
	public String ListarEstudiantes(Model modelo) {
		List<Estudiante> lstEst=servicio.listarEstudiantes();
		modelo.addAttribute("listaEstudiantes",lstEst);
		return "listaEstudiantes";
	}

}
