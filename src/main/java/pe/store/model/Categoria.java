package pe.store.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "categoria")
@ApiModel(description = "Contiene toda la informacion relativa de las categorias de los Productos")
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_cate")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes="Identificador unico de Categoria", required = true)
    private Integer cateId;

    @Column(name = "nombre_cate", nullable = false, length = 100)
    private String nombre;

    @Column(name = "estado_cate", nullable = false, length = 1)
    private String estado;

    @JsonManagedReference
    @OneToMany(mappedBy = "categoria",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    private Collection<Producto> itemsProductos = new ArrayList<>() ;

    public Categoria() {
    }

    public Categoria(Integer cateId) {
        this.cateId = cateId;
    }

    public Categoria(String nombre, String estado, Collection<Producto> itemsProductos) {
        this.nombre = nombre;
        this.estado = estado;
        this.itemsProductos = itemsProductos;
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
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

    public Collection<Producto> getItemsProductos() {
        return itemsProductos;
    }

    public void setItemsProductos(Collection<Producto> itemsProductos) {
        this.itemsProductos = itemsProductos;
    }
}

