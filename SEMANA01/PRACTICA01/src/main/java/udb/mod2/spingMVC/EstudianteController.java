package udb.mod2.spingMVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EstudianteController {
	@RequestMapping("/")
	public String menuApp() {
		return "listaEstudiantes";
	}
	@Autowired
	public EstudianteController() {
		// TODO Auto-generated constructor stub
		
	}

}
