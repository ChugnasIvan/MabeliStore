package pe.store.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "cliente")
public class EntityCliente implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_cli")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    @Column(name = "nombre_cli", nullable = false, length = 50)
    private String nombreCli;

    @Column(name = "ape_pat_cli", nullable = false, length = 50)
    private String apePatCli;

    @Column(name = "ape_mat_cli", nullable = false, length = 50)
    private String apeMatCli;

    @Column(name = "fech_nac_cli", nullable = false)
    private Date fechNacCli;

    @Column(name = "tip_doc_cli", nullable = false, length = 11)
    private String tipDocCli;

    @Column(name = "num_doc_cli", nullable = false, length = 15)
    private String numDocCli;

    @Column(name = "genero_cli", nullable = false, length = 9)
    private String genCli;

    @Column(name = "dir_cli", nullable = false, length = 120)
    private String dirCli;

    @Column(name = "num_cel_cli", nullable = false, length = 9)
    private Integer numCelCli;



}
