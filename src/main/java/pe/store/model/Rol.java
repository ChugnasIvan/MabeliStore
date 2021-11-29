package pe.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@ApiModel(description = "Contiene toda la informacion relativa de los roles de la empresa MabeliStore")
@Entity
@Table(name = "rol")
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_rol")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes="Identificador unico de Rol", required = true)
    private Integer idRol;

    @Column(name = "nombre_rol", nullable = false, length = 50)
    private String nombreRol;

    @Column(name = "estado_rol", nullable = false, length = 1)
    private String estado;

    @JsonManagedReference(value = "itemsUsuarioCliente")
    @JsonIgnore
    @OneToMany(mappedBy = "rolID",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    private Collection<UsuarioCliente> itemsUsuarioCliente = new ArrayList<>() ;

    //
    public Rol() {
    }

    public Rol(Integer idRol, String nombreRol) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
    }

    public Rol(Integer idRol, String nombreRol, String estado) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
        this.estado = estado;
    }

    public Rol(String nombreRol, String estado, Collection<UsuarioCliente> itemsUsuarioCliente) {
        this.nombreRol = nombreRol;
        this.estado = estado;
        this.itemsUsuarioCliente = itemsUsuarioCliente;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
