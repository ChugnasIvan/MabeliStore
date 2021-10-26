package pe.store.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "talleres")
public class Taller implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "taller_id")
	private Integer tallerId;
	
	@Column(length = 100)
	private String nombre;
	
	@Column
	private Double costo;
	
	@ManyToOne
	@JoinColumn(name = "instructor_id",nullable = false,
    foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(instructor_id) references instructores(instructor_id)"))
	private Instructor instructor; // coincide con el nombre del mappedBy en la entidad fuerte!!!
	
	public Taller() {
		// TODO Auto-generated constructor stub
	}

	public Taller(String nombre, Double costo, Instructor instructor) {
		super();
		this.nombre = nombre;
		this.costo = costo;
		this.instructor = instructor;
	}

	public Taller(String nombre, Double costo) {
		super();
		this.nombre = nombre;
		this.costo = costo;
	}

	public Integer getTallerId() {
		return tallerId;
	}

	public void setTallerId(Integer tallerId) {
		this.tallerId = tallerId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	
	

}
