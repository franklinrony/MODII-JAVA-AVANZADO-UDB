package udb.mod2.spingmvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import udb.mod2.springmvc.entidades.Empleado;

@Service
public class EmpleadoService {

	public EmpleadoService() {
		// TODO Auto-generated constructor stub
	}
public List<Empleado>lstEmpleados(){
	List<Empleado>empleados=new ArrayList<>();
	empleados.add(new Empleado("01", "Juan", "Perez"));
	empleados.add(new Empleado("02", "Jose", "Lopez"));
	empleados.add(new Empleado("03","Maria","Rosales"));
	return empleados;
}
}
