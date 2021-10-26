package pe.store.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter // dependencia lombok -> genera los getters y setters
    private Integer id_usuario;

    @ManyToOne
    private Rol rol;

    @Column(name = "nombre_usuario")
    @Getter @Setter // dependencia lombok -> genera los getters y setters
    private String nombre_usuario;

    @Column(name = "password")
    @Getter @Setter // dependencia lombok -> genera los getters y setters
    private String password;

    @Column(name = "estado_usuario")
    @Getter @Setter // dependencia lombok -> genera los getters y setters
    private boolean estado_usuario;

    public Usuario() {
    }

    public Usuario(Integer id_usuario, Rol rol, String nombre_usuario, String password, boolean estado_usuario) {
        this.id_usuario = id_usuario;
        this.rol = rol;
        this.nombre_usuario = nombre_usuario;
        this.password = password;
        this.estado_usuario = estado_usuario;
    }
}
