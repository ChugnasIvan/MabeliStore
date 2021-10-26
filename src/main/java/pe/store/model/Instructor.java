package pe.store.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;



@Entity
@Table(name = "instructores")
public class Instructor implements Serializable {

	// jvm : persistirlo en algun storage : disco

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "instructor_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer instructorId; // instructor_id (snake_case) No lo hae en automatico.

	@Column(name = "nombre")
	private String nombre;

	@Column(length = 50)
	private String apellido;

	@Column(length = 15)
	private String password;

	@Column(unique = true,nullable = false)
	private String email;

	@Temporal(TemporalType.DATE)
	private Date fregistro;
	
	@OneToOne(mappedBy = "instructor" ) // mappedBy en la clase entidad que mapea la tabla donde no existe la FK
	private Conyuge conyuge; // Relacion agregacion 

	@OneToMany(mappedBy = "instructor") // mappedBy en la clase entidad que mapea la tabla donde no existe la FK
	private Collection<Taller> itemsTaller = new ArrayList<Taller>();
	
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE} )
	//mapear tabla intermedia que rompe relacion
	@JoinTable(name = "instructores_tecnologias",
	           joinColumns = @JoinColumn(name = "instructor_id",nullable = false,
	   	            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(instructor_id) references instructores(instructor_id)")),
	           inverseJoinColumns = @JoinColumn(name = "tecnologia_id",nullable = false,
	   	            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(tecnologia_id) references tecnologias(tecnologia_id)")))
	private Set<Tecnologia> itemsTecnologia = new HashSet<>();
	   
	public Instructor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Instructor(Integer instructorId, String nombre, String apellido, String password, String email,
			Date fregistro) {
		super();
		this.instructorId = instructorId;
		this.nombre = nombre;
		this.apellido = apellido;
		this.password = password;
		this.email = email;
		this.fregistro = fregistro;
	}
	
	
	public Instructor(String nombre, String apellido, String password, String email, Date fregistro, Conyuge conyuge) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.password = password;
		this.email = email;
		this.fregistro = fregistro;
		this.conyuge = conyuge;
	}

	
	
	public Instructor(String nombre, String apellido, String password, String email, Date fregistro, Conyuge conyuge,
			Collection<Taller> itemsTaller) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.password = password;
		this.email = email;
		this.fregistro = fregistro;
		this.conyuge = conyuge;
		this.itemsTaller = itemsTaller;
	}

	
	
	public Instructor(String nombre, String apellido, String password, String email, Date fregistro, Conyuge conyuge,
			Collection<Taller> itemsTaller, Set<Tecnologia> itemsTecnologia) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.password = password;
		this.email = email;
		this.fregistro = fregistro;
		this.conyuge = conyuge;
		this.itemsTaller = itemsTaller;
		this.itemsTecnologia = itemsTecnologia;
	}

	// constructor recursivo

	public Instructor(Instructor instructor) {
		this(instructor.getInstructorId(), instructor.getNombre(), instructor.getApellido(), instructor.getPassword(),
				instructor.getEmail(), instructor.getFregistro());
	}

	public Integer getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(Integer instructorId) {
		this.instructorId = instructorId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFregistro() {
		return fregistro;
	}

	public void setFregistro(Date fregistro) {
		this.fregistro = fregistro;
	}
	
	
	
	public Conyuge getConyuge() {
		return conyuge;
	}

	public void setConyuge(Conyuge conyuge) {
		this.conyuge = conyuge;
	}
	
	

	public Collection<Taller> getItemsTaller() {
		return itemsTaller;
	}

	public void setItemsTaller(Collection<Taller> itemsTaller) {
		this.itemsTaller = itemsTaller;
	}
	
	

	public Set<Tecnologia> getItemsTecnologia() {
		return itemsTecnologia;
	}

	public void setItemsTecnologia(Set<Tecnologia> itemsTecnologia) {
		this.itemsTecnologia = itemsTecnologia;
	}

	@PrePersist
	public void prePersit()
	{
		this.fregistro = new Date();
	}

}
