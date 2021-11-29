package pe.store.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@ApiModel(description = "Contiene toda la informacion relativa de los cargos de la empresa MabeliStore")
@Entity
@Table(name = "Cargo")
public class Cargo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_cargo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes="Identificador unico de Cargo", required = true)
    private Integer cargoId;

    @Column(name = "nombre_cargo", nullable = false, length = 100)
    private String nombre;

    @Column(name = "estado_cargo", nullable = false, length = 1)
    private String estado;

    // Que columna en la tabla Cargo tiene la FK
    /*@OneToOne(cascade = {CascadeType.ALL})//para que cree las areas que no han sido creadas
    @JoinColumn(name = "id_area", nullable = false)*/

    @JsonBackReference(value = "areaID")
    @ManyToOne
    @JoinColumn(name = "id_area",nullable = false,
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_area) references area(id_area)"))
    private Area areaID;

    @JsonManagedReference(value = "itemsEmpleados_Cargo")
    @JsonIgnore
    @OneToMany(mappedBy = "cargo",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    private Collection<Empleado> itemsEmpleados = new ArrayList<>() ;

    //
    public Cargo() {  }

    public Cargo(Integer cargoId) {
        this.cargoId = cargoId;
    }

    public Cargo(Integer cargoId, String nombre, String estado) {
        this.cargoId = cargoId;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Cargo(String nombre, String estado, Area areaID) {
        this.nombre = nombre;
        this.estado = estado;
        this.areaID = areaID;
    }

    public Cargo(String nombre, String estado, Area areaID, Collection<Empleado> itemsEmpleados) {
        this.nombre = nombre;
        this.estado = estado;
        this.areaID = areaID;
        this.itemsEmpleados = itemsEmpleados;
    }

    //
    public Integer getCargoId() {
        return cargoId;
    }

    public void setCargoId(Integer cargoId) {
        this.cargoId = cargoId;
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

    public Area getAreaID() {
        return areaID;
    }

    public void setAreaID(Area areaID) {
        this.areaID = areaID;
    }

    public Collection<Empleado> getItemsEmpleados() {
        return itemsEmpleados;
    }

    public void setItemsEmpleados(Collection<Empleado> itemsEmpleados) {
        this.itemsEmpleados = itemsEmpleados;
    }
}
