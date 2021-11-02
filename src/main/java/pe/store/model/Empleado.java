package pe.store.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Empleado")
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_emp")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "ape_paterno")
    private String apePaterno;

    @Column(name = "ape_materno")
    private String apeMaterno;

    @ManyToOne
    @JoinColumn(name = "id_tipodoc",nullable = false,
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_tipodoc) references Tipodocumento(id_tipodoc)"))
    private TipoDocumento tipoDocumento;

    @Column(name = "num_documento")
    private String numDocumento;

    @Column(name = "fecha_nac")
    private Date fechaNac;

    @Column(name = "edad")
    private String edad;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "estado")
    private String estado;

    @OneToOne
    @JoinColumn(name = "id_usu_emp",nullable = false, unique = true,
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_usu_emp) references usuario_empleado(id_usu_emp)"))
    private UsuarioEmpleado usuario;

    @ManyToOne
    @JoinColumn(name = "id_cargo",nullable = false,
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_cargo) references cargo(id_cargo)"))
    private Cargo cargo;

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
