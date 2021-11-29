package pe.store.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@ApiModel(description = "Contiene toda la informacion relativa de los pedidos de la empresa MabeliStore")
@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_pedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes="Identificador unico de Pedido", required = true)
    private Integer pedidoId;

    @Column(name = "direccion_envio", nullable = false, length = 100)
    private String direccionEnvio;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "estado", nullable = false, length = 1)
    private String estado;

    @Column(name = "total")
    private Double total;

    @JsonBackReference(value = "usuarioCliente_pedido")
    @ManyToOne
    @JoinColumn(name = "id_usu_cli",nullable = false,
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_usu_cli) references usuario_cliente(id_usu_cli)"))
    private UsuarioCliente usuarioCliente;

    @JsonManagedReference(value = "itemsDetallePedido_Pedido")
    @JsonIgnore
    @OneToMany(mappedBy = "pedido",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    private Collection<DetallePedido> itemsDetallePedido = new ArrayList<>() ;

    public Pedido() {
    }

    public Pedido(Integer pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Pedido(String direccionEnvio, Date fecha, String estado, Double total, UsuarioCliente usuarioCliente) {
        this.direccionEnvio = direccionEnvio;
        this.fecha = fecha;
        this.estado = estado;
        this.total = total;
        this.usuarioCliente = usuarioCliente;
    }

    public Integer getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Integer pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public UsuarioCliente getUsuarioCliente() {
        return usuarioCliente;
    }

    public void setUsuarioCliente(UsuarioCliente usuarioCliente) {
        this.usuarioCliente = usuarioCliente;
    }
}
