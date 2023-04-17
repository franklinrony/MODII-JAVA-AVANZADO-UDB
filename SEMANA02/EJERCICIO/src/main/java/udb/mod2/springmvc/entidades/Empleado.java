package udb.mod2.springmvc.entidades;

public class Empleado {
	String codigo;
	String nombres;
	String apellidos;
	
	public Empleado() {
		// TODO Auto-generated constructor stub		
	}

	public Empleado(String codigo, String nombres, String apellidos) {
		super();
		this.codigo = codigo;
		this.nombres = nombres;
		this.apellidos = apellidos;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

}
