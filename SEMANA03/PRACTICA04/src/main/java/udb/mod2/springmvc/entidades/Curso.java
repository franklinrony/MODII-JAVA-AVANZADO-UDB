package udb.mod2.springmvc.entidades;

public class Curso {
private Integer codigo;
private String nombre;
private String modalidad;

	public Curso() {
		// TODO Auto-generated constructor stub
	}

	public Curso(Integer codigo, String nombre, String modalidad) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.modalidad = modalidad;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

}
