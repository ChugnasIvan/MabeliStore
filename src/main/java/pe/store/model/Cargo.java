package pe.store.model;

import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "Cargo")
public class Cargo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_cargo")
    private Integer cargoId;

    @Column(name = "nombre_cargo", nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_area", insertable = false, updatable = false)
    private Area area;

    public int getCargoId() {
        return cargoId;
    }

    public void setCargoId(int cargoId) {
        this.cargoId = cargoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
