package pe.store.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Area")
public class Area implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_area")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer areaId;

    @Column(name = "nombre_area")
    private String nombre;

    @Column(name = "estado_area")
    private String estado;

    public Area(){
        super();
    }

    public Area(Integer areaId, String nombre, String estado) {
        super();
        this.areaId = areaId;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Area(Integer areaId) {
        super();
        this.areaId = areaId;
    }

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
}
