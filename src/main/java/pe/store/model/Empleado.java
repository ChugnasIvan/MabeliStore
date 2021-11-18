package pe.store.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "Contiene toda la informacion relativa de empleados de la empresa MabeliStore")
@Entity
@Table(name = "Empleado")
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_emp")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes="Identificador unico de Empleado", required = true)
    private Integer empId;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "ape_paterno", nullable = false, length = 100)
    private String apePaterno;

    @Column(name = "ape_materno", nullable = false, length = 100)
    private String apeMaterno;

    @JsonBackReference(value = "tipoDocumento")
    @ManyToOne
    @JoinColumn(name = "id_tipodoc",nullable = false,
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_tipodoc) references Tipodocumento(id_tipodoc)"))
    private TipoDocumento tipoDocumento;

    @Column(name = "num_documento", nullable = false, length = 11)
    private String numDocumento;

    @Column(name = "fecha_nac")
    private Date fechaNac;

    @Column(name = "edad", nullable = false, length = 2)
    private String edad;

    @Column(name = "sexo", nullable = false, length = 10)
    private String sexo;

    @Column(name = "direccion", nullable = false, length = 100)
    private String direccion;

    @Column(name = "estado", nullable = false, length = 1)
    private String estado;

    //
    //@JsonManagedReference
    //@JsonIgnore
    @JsonBackReference(value = "usuario")
    @OneToOne
    @JoinColumn(name = "id_usu_emp",nullable = false, unique = true,
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_usu_emp) references usuario_empleado(id_usu_emp)"))
    private UsuarioEmpleado usuario;

    @JsonBackReference(value = "cargo")
    @ManyToOne
    @JoinColumn(name = "id_cargo",nullable = false,
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_cargo) references cargo(id_cargo)"))
    private Cargo cargo;

    @JsonBackReference(value = "distrito")
    @ManyToOne
    @JoinColumn(name = "id_dis",nullable = false,
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_dis) references distrito(id_dis)"))
    private Distrito distrito;

    //
    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApePaterno() {
        return apePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public UsuarioEmpleado getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEmpleado usuario) {
        this.usuario = usuario;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public Empleado() {}

    public Empleado(String nombre, String apePaterno, String apeMaterno, TipoDocumento tipoDocumento, String numDocumento, Date fechaNac, String edad, String sexo, String direccion, String estado, UsuarioEmpleado usuario, Cargo cargo, Distrito distrito) {
        this.nombre = nombre;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
        this.fechaNac = fechaNac;
        this.edad = edad;
        this.sexo = sexo;
        this.direccion = direccion;
        this.estado = estado;
        this.usuario = usuario;
        this.cargo = cargo;
        this.distrito = distrito;
    }
}
