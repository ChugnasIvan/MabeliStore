package pe.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@ApiModel(description = "Contiene la informacion relativa de los Tipos de Documentos")
@Entity
@Table(name = "Tipodocumento")
public class TipoDocumento  implements Serializable {

    @Id
    @Column(name = "id_tipodoc")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes="Identificador unico de Tipo Documento", required = true)
    private Integer id_tipoDoc;

    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;

    @Column(name = "estado", nullable = false, length = 1)
    private String estado;

    @JsonManagedReference(value = "itemsEmpleado_TipoDoc")
    @JsonIgnore
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
