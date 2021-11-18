package pe.store.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rol")
public class EntityRol implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_rol")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRol;

    @Column(name = "nombre_rol")
    private String nombreRol;

    // Tipo de relacion Unidirecional de Usuario Cliente a ESTADO
    @ManyToOne
    @JoinColumn(name = "id_estado_in_rol")
    private EntityEstado estado;

    public EntityRol() {
    }

    public EntityRol(Integer idRol, String nombreRol) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
    }

    public EntityRol(Integer idRol, String nombreRol, EntityEstado estado) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
        this.estado = estado;
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

    public EntityEstado getEstado() {
        return estado;
    }

    public void setEstado(EntityEstado estado) {
        this.estado = estado;
    }
}
