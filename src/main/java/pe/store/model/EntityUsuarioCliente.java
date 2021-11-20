package pe.store.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuario_cliente")
public class EntityUsuarioCliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_usu_cli")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuCli;

    @Column(name = "nombre_usu_cli")
    private String nombreUsuCli;

    @Column(name = "password_usu_cli")
    private String passwordUsuCli;

    // Tipo de relacion Unidirecional de Usuario Cliente a ESTADO
    @ManyToOne
    @JoinColumn(name = "id_estado_in_cli")
    private EntityEstado estado;




    // contructor sobrecargado
    public EntityUsuarioCliente() {
    }

    public EntityUsuarioCliente(Integer idUsuCli, String nombreUsuCli, String passwordUsuCli) {
        this.idUsuCli = idUsuCli;
        this.nombreUsuCli = nombreUsuCli;
        this.passwordUsuCli = passwordUsuCli;
    }

    public EntityUsuarioCliente(Integer idUsuCli, String nombreUsuCli, String passwordUsuCli, EntityEstado estado) {
        this.idUsuCli = idUsuCli;
        this.nombreUsuCli = nombreUsuCli;
        this.passwordUsuCli = passwordUsuCli;
        this.estado = estado;
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

    public EntityEstado getEstado() {
        return estado;
    }

    public void setEstado(EntityEstado estado) {
        this.estado = estado;
    }

}
