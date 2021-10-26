package pe.store.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tecnologias")
public class Tecnologia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "tecnologia_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tecnologiaId;
	
	@Column(length = 100)
	private String nombre;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fregistro;
	
	@ManyToMany(mappedBy = "itemsTecnologia",cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private Set<Instructor> itemsInstructor = new HashSet<>();
	
	public Tecnologia() {
		// TODO Auto-generated constructor stub
	}

	public Tecnologia(String nombre, Date fregistro) {
		super();
		this.nombre = nombre;
		this.fregistro = fregistro;
	}

	public Tecnologia(String nombre, Date fregistro, Set<Instructor> itemsInstructor) {
		super();
		this.nombre = nombre;
		this.fregistro = fregistro;
		this.itemsInstructor = itemsInstructor;
	}

	public Integer getTecnologiaId() {
		return tecnologiaId;
	}

	public void setTecnologiaId(Integer tecnologiaId) {
		this.tecnologiaId = tecnologiaId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFregistro() {
		return fregistro;
	}

	public void setFregistro(Date fregistro) {
		this.fregistro = fregistro;
	}

	public Set<Instructor> getItemsInstructor() {
		return itemsInstructor;
	}

	public void setItemsInstructor(Set<Instructor> itemsInstructor) {
		this.itemsInstructor = itemsInstructor;
	}
	
	@PrePersist
	public void prePersist()
	{
		this.fregistro = new Date();
	}
	

}
