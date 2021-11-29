package pe.store.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@ApiModel(description = "Contiene toda la informacion relativa de los detalles de pedido de la empresa MabeliStore")
@Entity
@Table(name = "detalle_pedido")
public class DetallePedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_det_pedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes="Identificador unico de DetallePedido", required = true)
    private Integer detPedidoId;

    @JsonBackReference(value = "pedido_detallePedido")
    @ManyToOne
    @JoinColumn(name = "id_pedido",nullable = false,
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_pedido) references pedido(id_pedido)"))
    private Pedido pedido;

    @JsonBackReference(value = "producto_detallePedido")
    @ManyToOne
    @JoinColumn(name = "id_prod",nullable = false,
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_prod) references productos(id_prod)"))
    private Producto producto;

    @Column(name = "precio", nullable = false)
    private Double precio;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "subtotal")
    private Double subtotal;

    public DetallePedido(Pedido pedido, Producto producto, Double precio, int cantidad, Double subtotal) {
        this.pedido = pedido;
        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public DetallePedido() {
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = this.precio * this.cantidad;
    }
}
