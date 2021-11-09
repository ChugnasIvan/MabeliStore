package pe.store.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@ApiModel(description = "Contiene toda la informacion relativa de lus usuarios de los empleados")
@Entity
@Table(name = "usuario_empleado")
public class UsuarioEmpleado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_usu_emp")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes="Identificador unico de usuario", required = true)
    private Integer usuEmpId;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "password", nullable = false, length = 10)
    private String password;

    @Column(name = "estado", nullable = false, length = 1)
    private String estado;

    //@JsonManagedReference
    //
    //@JsonIgnore
    @JsonBackReference(value = "empleado")
    @OneToOne(mappedBy = "usuario") //Atributo opcional que sirve para indicar el nombre de la propiedad relacionada en la clase
    private Empleado empleado;

    public Integer getUsuEmpId() {
        return usuEmpId;
    }

    public void setUsuEmpId(Integer usuEmpId) {
        this.usuEmpId = usuEmpId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    //
    public UsuarioEmpleado() {}

    public UsuarioEmpleado(Integer usuEmpId) {
        this.usuEmpId = usuEmpId;
    }

    public UsuarioEmpleado(String nombre, String password, String estado) {
        this.nombre = nombre;
        this.password = password;
        this.estado = estado;
    }

    public UsuarioEmpleado(String nombre, String password, String estado, Empleado empleado) {
        this.nombre = nombre;
        this.password = password;
        this.estado = estado;
        this.empleado = empleado;
    }
}
