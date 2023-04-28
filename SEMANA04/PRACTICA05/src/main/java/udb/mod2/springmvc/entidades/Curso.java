package udb.mod2.springmvc.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Curso {
@Id
private Integer idCurso;
private String curso;
@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE,
CascadeType.DETACH, CascadeType.REFRESH})
@JoinColumn(name = "iddocente",referencedColumnName = "idDocente")
private Docente idDocente;
// Métodos Getter y Setter mas constructores

public Curso(Integer idCurso, String curso, Docente idDocente) {
	super();
	this.idCurso = idCurso;
	this.curso = curso;
	this.idDocente = idDocente;
}
public Curso() {
	super();
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
public Docente getIdDocente() {
	return idDocente;
}
public void setIdDocente(Docente idDocente) {
	this.idDocente = idDocente;
}

}