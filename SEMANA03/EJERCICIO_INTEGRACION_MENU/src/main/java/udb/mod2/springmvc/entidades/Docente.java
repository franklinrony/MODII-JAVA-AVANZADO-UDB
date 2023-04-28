package udb.mod2.springmvc.entidades;

public class Docente {

	private String nombre;
	private String correo;
	private String rol;
	
	public Docente() {
		// TODO Auto-generated constructor stub
	}

	public Docente(String nombre, String correo, String rol) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.rol = rol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	
}
