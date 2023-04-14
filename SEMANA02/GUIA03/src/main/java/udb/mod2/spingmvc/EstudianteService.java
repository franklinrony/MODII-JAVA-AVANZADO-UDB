package udb.mod2.spingmvc;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;

import udb.mod2.springmvc.entidades.Estudiante;

@Service
public class EstudianteService {

		
	public List<Estudiante> listarEstudiantes(){
		List<Estudiante> lst=new ArrayList<Estudiante>();
		lst.add(new Estudiante(1,"Carlos Humberto","Martinez",9.80,67.59));
		lst.add(new Estudiante(2,"Jose Ramirez","Palacios",8.80,77.00));
		lst.add(new Estudiante(3,"Marina Geraldina","lopez",9.60,87.45));
		lst.add(new Estudiante(4,"Francisco ALejnadro","Rosales",9.10,97.89));
		lst.add(new Estudiante(5,"Iliana Margarita","Flamenco",9.70,78.65));
		lst.add(new Estudiante (6,"Nancy Jeannete","Perez",9.50,67.59));
		lst.add(new Estudiante(7,"Raul Nicolas","Ruiz",7.80,1009.90));
		return lst;
	}

}
