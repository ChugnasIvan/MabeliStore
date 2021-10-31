package pe.store.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "Tipodocumento")
public class TipoDocumento  implements Serializable {

    @Id
    @Column(name = "id_tipodoc")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tipoDoc;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado")
    private String estado;

    @OneToMany(mappedBy = "tipoDocumento",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    private Collection<Empleado> itemsEmpleado = new ArrayList<>() ;

    //
    public Integer getId_tipoDoc() {
        return id_tipoDoc;
    }

    public void setId_tipoDoc(Integer id_tipoDoc) {
        this.id_tipoDoc = id_tipoDoc;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public TipoDocumento() {}

    public TipoDocumento(Integer id_tipoDoc) {
        this.id_tipoDoc = id_tipoDoc;
    }

    public TipoDocumento(String descripcion, String estado) {
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public TipoDocumento(String descripcion, String estado, Collection<Empleado> itemsEmpleado) {
        this.descripcion = descripcion;
        this.estado = estado;
        this.itemsEmpleado = itemsEmpleado;
    }

    public Collection<Empleado> getItemsEmpleado() {
        return itemsEmpleado;
    }

    public void setItemsEmpleado(Collection<Empleado> itemsEmpleado) {
        this.itemsEmpleado = itemsEmpleado;
    }
}
