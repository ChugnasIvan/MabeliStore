package pe.store.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@ApiModel(description = "Contiene toda la informacion relativa de los modelos de los productos")
@Entity
@Table(name = "modelo")
public class Modelo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_modelo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes="Identificador unico del Modelo", required = true)
    private Integer modeloId;

    @Column(name = "nombre_modelo", nullable = false, length = 100)
    private String nombre;

    @Column(name = "estado_modelo", nullable = false, length = 1)
    private String estado;

    @JsonBackReference(value = "marcaID")
    @ManyToOne
    @JoinColumn(name = "id_marca",nullable = false,
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_marca) references marca(id_marca)"))
    private Marca marcaID;

    @JsonManagedReference(value = "itemsProductos_Modelo")
    @JsonIgnore
    @OneToMany(mappedBy = "modelo",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    private Collection<Producto> itemsProductos = new ArrayList<>() ;

    //
    public Modelo() {
    }

    public Modelo(Integer modeloId) {
        this.modeloId = modeloId;
    }

    public Modelo(String nombre, String estado, Marca marcaID) {
        this.nombre = nombre;
        this.estado = estado;
        this.marcaID = marcaID;
    }

    public Modelo(Integer modeloId, String nombre, String estado, Marca marcaID, Collection<Producto> itemsProductos) {
        this.modeloId = modeloId;
        this.nombre = nombre;
        this.estado = estado;
        this.marcaID = marcaID;
        this.itemsProductos = itemsProductos;
    }

    public Integer getModeloId() {
        return modeloId;
    }

    public void setModeloId(Integer modeloId) {
        this.modeloId = modeloId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Marca getMarcaID() {
        return marcaID;
    }

    public void setMarcaID(Marca marcaID) {
        this.marcaID = marcaID;
    }

    public Collection<Producto> getItemsProductos() {
        return itemsProductos;
    }

    public void setItemsProductos(Collection<Producto> itemsProductos) {
        this.itemsProductos = itemsProductos;
    }
}
