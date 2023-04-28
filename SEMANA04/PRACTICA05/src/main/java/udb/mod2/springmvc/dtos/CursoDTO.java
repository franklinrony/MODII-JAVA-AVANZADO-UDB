package udb.mod2.springmvc.dtos;

public class CursoDTO {
	private Integer idCurso;
	private String curso;
	
	public CursoDTO() {
		// TODO Auto-generated constructor stub
	}

	public CursoDTO(Integer idCurso, String curso) {
		super();
		this.idCurso = idCurso;
		this.curso = curso;
	}

	public Integer getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

}
