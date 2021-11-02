package pe.store.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "Distrito")
public class Distrito implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_dis")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDis;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado")
    private String estado;

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
