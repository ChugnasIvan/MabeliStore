package pe.store.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "rol")
public class Rol {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_rol")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter // dependencia lombok -> genera los getters y setters
    private Integer id_rol;

    @Column(name = "nombre_rol")
    @Getter @Setter
    private String nombre_rol;

    @Column(name = "estado_rol")
    @Getter @Setter
    private Boolean estado_rol;

    public Rol() {
    }

    public Rol(Integer id_rol, String nombre_rol, Boolean estado_rol) {
        this.id_rol = id_rol;
        this.nombre_rol = nombre_rol;
        this.estado_rol = estado_rol;
    }
}
