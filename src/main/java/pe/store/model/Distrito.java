package pe.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@ApiModel(description = "Contiene toda la informacion relativa de los distritos")
@Entity
@Table(name = "Distrito")
public class Distrito implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_dis")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes="Identificador unico de Distrito", required = true)
    private Integer idDis;

    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;

    @Column(name = "estado", nullable = false, length = 1)
    private String estado;

    @JsonManagedReference(value = "itemsEmpleados_Distrito")
    @JsonIgnore
    @OneToMany(mappedBy = "distrito",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    private Collection<Empleado> itemsEmpleados = new ArrayList<>() ;


    //
    public Distrito() {}

    public Distrito(Integer idDis) {
        this.idDis = idDis;
    }

    public Distrito(String descripcion, String estado) {
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Distrito(String descripcion, String estado, Collection<Empleado> itemsEmpleados) {
        this.descripcion = descripcion;
        this.estado = estado;
        this.itemsEmpleados = itemsEmpleados;
    }

    //
    public Integer getIdDis() {
        return idDis;
    }

    public void setIdDis(Integer idDis) {
        this.idDis = idDis;
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

    public Collection<Empleado> getItemsEmpleados() {
        return itemsEmpleados;
    }

    public void setItemsEmpleados(Collection<Empleado> itemsEmpleados) {
        this.itemsEmpleados = itemsEmpleados;
    }
}
