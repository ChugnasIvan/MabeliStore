package pe.store.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "Contiene toda la informacion relativa de los clientes de la empresa MabeliStore")
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_cli")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes="Identificador unico de Cliente", required = true)
    private Integer idCliente;

    @Column(name = "nombre_cli", nullable = false, length = 50)
    private String nombreCli;

    @Column(name = "ape_pat_cli", nullable = false, length = 50)
    private String apePatCli;

    @Column(name = "ape_mat_cli", nullable = false, length = 50)
    private String apeMatCli;

    @Column(name = "fech_nac_cli", nullable = false)
    private Date fechNacCli;

    /*@Column(name = "tip_doc_cli", nullable = false, length = 11)
    private String tipDocCli;*/
    @JsonBackReference(value = "tipoDocumento_Cliente")
    @ManyToOne
    @JoinColumn(name = "id_tipodoc",nullable = false,
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_tipodoc) references Tipodocumento(id_tipodoc)"))
    private TipoDocumento tipoDocumento;

    @Column(name = "num_doc_cli", nullable = false, length = 15)
    private String numDocCli;

    @Column(name = "genero_cli", nullable = false, length = 9)
    private String genCli;

    @Column(name = "dir_cli", nullable = false, length = 120)
    private String dirCli;

    @Column(name = "num_cel_cli", nullable = false, length = 9)
    private String numCelCli;

    @Column(name = "email_cli", nullable = false, length = 100)
    private String emailCli;

    @Column(name = "estado", nullable = false, length = 1)
    private String estado;

    @JsonBackReference(value = "distrito")
    @ManyToOne
    @JoinColumn(name = "id_dis",nullable = false,
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_dis) references distrito(id_dis)"))
    private Distrito distrito;

    @JsonBackReference(value = "usuario_cliente")
    @OneToOne
    @JoinColumn(name = "id_usu_cli",nullable = false, unique = true,
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_usu_cli) references usuario_cliente(id_usu_cli)"))
    private UsuarioCliente usuarioCliente;

    public Cliente() {
    }

    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(String nombreCli, String apePatCli, String apeMatCli, Date fechNacCli, TipoDocumento tipoDocumento, String numDocCli, String genCli, String dirCli, String numCelCli, String emailCli, String estado, UsuarioCliente usuarioCliente) {
        this.nombreCli = nombreCli;
        this.apePatCli = apePatCli;
        this.apeMatCli = apeMatCli;
        this.fechNacCli = fechNacCli;
        this.tipoDocumento = tipoDocumento;
        this.numDocCli = numDocCli;
        this.genCli = genCli;
        this.dirCli = dirCli;
        this.numCelCli = numCelCli;
        this.emailCli = emailCli;
        this.estado = estado;
        this.usuarioCliente = usuarioCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCli() {
        return nombreCli;
    }

    public void setNombreCli(String nombreCli) {
        this.nombreCli = nombreCli;
    }

    public String getApePatCli() {
        return apePatCli;
    }

    public void setApePatCli(String apePatCli) {
        this.apePatCli = apePatCli;
    }

    public String getApeMatCli() {
        return apeMatCli;
    }

    public void setApeMatCli(String apeMatCli) {
        this.apeMatCli = apeMatCli;
    }

    public Date getFechNacCli() {
        return fechNacCli;
    }

    public void setFechNacCli(Date fechNacCli) {
        this.fechNacCli = fechNacCli;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumDocCli() {
        return numDocCli;
    }

    public void setNumDocCli(String numDocCli) {
        this.numDocCli = numDocCli;
    }

    public String getGenCli() {
        return genCli;
    }

    public void setGenCli(String genCli) {
        this.genCli = genCli;
    }

    public String getDirCli() {
        return dirCli;
    }

    public void setDirCli(String dirCli) {
        this.dirCli = dirCli;
    }

    public String getNumCelCli() {
        return numCelCli;
    }

    public void setNumCelCli(String numCelCli) {
        this.numCelCli = numCelCli;
    }

    public String getEmailCli() {
        return emailCli;
    }

    public void setEmailCli(String emailCli) {
        this.emailCli = emailCli;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public UsuarioCliente getUsuarioCliente() {
        return usuarioCliente;
    }

    public void setUsuarioCliente(UsuarioCliente usuarioCliente) {
        this.usuarioCliente = usuarioCliente;
    }
}
