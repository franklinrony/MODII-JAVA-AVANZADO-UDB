package udb.mod2.springmvc.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Docente {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="iddocente")
private Integer idDocente;
private String docente;
@OneToMany(fetch = FetchType.EAGER, mappedBy = "idDocente",
cascade = {CascadeType.PERSIST, CascadeType.MERGE,
CascadeType.DETACH, CascadeType.REFRESH})
private List<Curso> lstCursos;
// Métodos Getter y Setter mas constructores

public Integer getIdDocente() {
	return idDocente;
}

public Docente() {
	super();
}

public Docente(Integer idDocente, String docente, List<Curso> lstCursos) {
	super();
	this.idDocente = idDocente;
	this.docente = docente;
	this.lstCursos = lstCursos;
}
public void setIdDocente(Integer idDocente) {
	this.idDocente = idDocente;
}
public String getDocente() {
	return docente;
}
public void setDocente(String docente) {
	this.docente = docente;
}
public List<Curso> getLstCursos() {
	return lstCursos;
}
public void setLstCursos(List<Curso> lstCursos) {
	this.lstCursos = lstCursos;
}

}