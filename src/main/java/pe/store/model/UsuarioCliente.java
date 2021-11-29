package pe.store.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@ApiModel(description = "Contiene toda la informacion relativa de los usuarios de la empresa MabeliStore")
@Entity
@Table(name = "usuario_cliente")
public class UsuarioCliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_usu_cli")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes="Identificador unico de Usuario Cliente", required = true)
    private Integer idUsuCli;

    @Column(name = "nombre_usu_cli", nullable = false, length = 100)
    private String nombreUsuCli;

    @Column(name = "password_usu_cli", nullable = false, length = 100)
    private String passwordUsuCli;

    @Column(name = "estado_usu_cli", nullable = false, length = 1)
    private String estado;

    @JsonBackReference(value = "rolID")
    @ManyToOne
    @JoinColumn(name = "id_rol",nullable = false,
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_rol) references rol(id_rol)"))
    private Rol rolID;

    @JsonBackReference(value = "cliente")
    @OneToOne(mappedBy = "usuarioCliente") //Atributo opcional que sirve para indicar el nombre de la propiedad relacionada en la clase
    private Cliente cliente;

    // contructor sobrecargado
    public UsuarioCliente() {
    }

    public UsuarioCliente(Integer idUsuCli, String nombreUsuCli, String passwordUsuCli) {
        this.idUsuCli = idUsuCli;
        this.nombreUsuCli = nombreUsuCli;
        this.passwordUsuCli = passwordUsuCli;
    }

    public UsuarioCliente(Integer idUsuCli, String nombreUsuCli, String passwordUsuCli, String estado) {
        this.idUsuCli = idUsuCli;
        this.nombreUsuCli = nombreUsuCli;
        this.passwordUsuCli = passwordUsuCli;
        this.estado = estado;
    }

    public UsuarioCliente(String nombreUsuCli, String passwordUsuCli, String estado, Rol rolID) {
        this.nombreUsuCli = nombreUsuCli;
        this.passwordUsuCli = passwordUsuCli;
        this.estado = estado;
        this.rolID = rolID;
    }

    // GETTERS AND SETTERS
    public Integer getIdUsuCli() {
        return idUsuCli;
    }

    public void setIdUsuCli(Integer idUsuCli) {
        this.idUsuCli = idUsuCli;
    }

    public String getNombreUsuCli() {
        return nombreUsuCli;
    }

    public void setNombreUsuCli(String nombreUsuCli) {
        this.nombreUsuCli = nombreUsuCli;
    }

    public String getPasswordUsuCli() {
        return passwordUsuCli;
    }

    public void setPasswordUsuCli(String passwordUsuCli) {
        this.passwordUsuCli = passwordUsuCli;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Rol getRolID() {
        return rolID;
    }

    public void setRolID(Rol rolID) {
        this.rolID = rolID;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
