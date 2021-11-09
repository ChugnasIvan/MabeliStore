package pe.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@ApiModel(description = "Contiene toda la informacion relativa de las areas de la empresa MabeliStore")
@Entity
@Table(name = "Area")
public class Area implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_area")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes="Identificador unico de Area", required = true)
    private Integer areaId;

    @Column(name = "nombre_area", nullable = false, length = 100)
    private String nombre;

    @Column(name = "estado_area", nullable = false, length = 1)
    private String estado;

    //mapeamos un forignKey
    //@OneToOne(mappedBy = "areaID", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JsonManagedReference(value = "itemsCargo_Area")
    @JsonIgnore
    @OneToMany(mappedBy = "areaID",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    private Collection<Cargo> itemsCargo = new ArrayList<>() ;

    public Area(){
        super();
    }

    public Area(Integer areaId) {
        super();
        this.areaId = areaId;
    }

    public Area(Integer areaId, String nombre, String estado) {
        this.areaId = areaId;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Area(String nombre, String estado, Cargo cargoID) {//
        this.nombre = nombre;
        this.estado = estado;
        //this.cargoID = cargoID;
    }

    public Area(Integer areaId, String nombre, String estado, Collection<Cargo> itemsCargo) {
        this.areaId = areaId;
        this.nombre = nombre;
        this.estado = estado;
        this.itemsCargo = itemsCargo;
    }

    public Area(Area area) {
        this(area.getAreaId(), area.getNombre(), area.getEstado());
    }

    //GETTER & SETTER
    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
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

    public Collection<Cargo> getItemsCargo() {
        return itemsCargo;
    }

    public void setItemsCargo(Collection<Cargo> itemsCargo) {
        this.itemsCargo = itemsCargo;
    }

}
