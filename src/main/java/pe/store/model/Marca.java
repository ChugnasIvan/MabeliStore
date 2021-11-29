package pe.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@ApiModel(description = "Contiene toda la informacion relativa de las marcas de los Productos")
@Entity
@Table(name = "marca")
public class Marca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_marca")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes="Identificador unico de marca", required = true)
    private Integer marcaId;

    @Column(name = "nombre_marca", nullable = false, length = 100)
    private String nombre;

    @Column(name = "estado_marca", nullable = false, length = 1)
    private String estado;

    @JsonManagedReference(value = "itemsModelo_Marca")
    @JsonIgnore
    @OneToMany(mappedBy = "marcaID",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    private Collection<Modelo> itemsModelo = new ArrayList<>() ;

    //
    public Integer getMarcaId() {
        return marcaId;
    }

    public void setMarcaId(Integer marcaId) {
        this.marcaId = marcaId;
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

    public Collection<Modelo> getItemsModelo() {
        return itemsModelo;
    }

    public void setItemsModelo(Collection<Modelo> itemsModelo) {
        this.itemsModelo = itemsModelo;
    }

    //
    public Marca(){}

    public Marca(Integer marcaId) {
        this.marcaId = marcaId;
    }

    public Marca(String nombre, String estado) {
        this.nombre = nombre;
        this.estado = estado;
    }

    public Marca(String nombre, String estado, Collection<Modelo> itemsModelo) {
        this.nombre = nombre;
        this.estado = estado;
        this.itemsModelo = itemsModelo;
    }

}
