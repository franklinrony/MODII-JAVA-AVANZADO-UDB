package udb.mod2.springmvc.entidades;

import java.util.Date;
import java.util.List;

public class EncabezadoPrestamo {
	private Integer numeroPrestamo;
	private Date FechaPrestamo;
	private Empleado empleado;
	private Estudiante estudiante;
	private List<Libro> libros;
	private Date FechaEntrega;
	
	public EncabezadoPrestamo() {
		// TODO Auto-generated constructor stub
	}

		
	

	public EncabezadoPrestamo(Integer numeroPrestamo, Date fechaPrestamo, Empleado empleado, Estudiante estudiante,
			List<Libro> libros, Date fechaEntrega) {
		super();
		this.numeroPrestamo = numeroPrestamo;
		FechaPrestamo = fechaPrestamo;
		this.empleado = empleado;
		this.estudiante = estudiante;
		this.libros = libros;
		FechaEntrega = fechaEntrega;
	}





	public List<Libro> getLibros() {
		return libros;
	}





	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}





	public Integer getNumeroPrestamo() {
		return numeroPrestamo;
	}

	public void setNumeroPrestamo(Integer numeroPrestamo) {
		this.numeroPrestamo = numeroPrestamo;
	}

	public Date getFechaPrestamo() {
		return FechaPrestamo;
	}

	public void setFechaPrestamo(Date fechaPrestamo) {
		FechaPrestamo = fechaPrestamo;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}



	public Date getFechaEntrega() {
		return FechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		FechaEntrega = fechaEntrega;
	}

	

}
