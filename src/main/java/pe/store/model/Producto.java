package pe.store.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "productos")
@ApiModel(description = "Contiene toda la informacion relativa de los Productos de la empresa MabeliStore")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_prod")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes="Identificador unico de Producto", required = true)
    private Integer prodId;

    @Column(name = "nombre_prod", nullable = false, length = 100)
    private String nombre;

    @Column(name = "precio_prod", nullable = false)
    private int precio;

    @Column(name = "peso_prod", nullable = false)
    private int peso;

    @Column(name = "stock_prod", nullable = false)
    private int stock;

    @Column(name = "estado_prod", nullable = false, length = 1)
    private String estado;

    @JsonBackReference(value = "modelo")
    @ManyToOne
    @JoinColumn(name = "id_modelo",nullable = false,
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_modelo) references modelo(id_modelo)"))
    private Modelo modelo;

    @JsonBackReference(value = "categoria")
    @ManyToOne
    @JoinColumn(name = "id_cate",nullable = false,
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_cate) references categoria(id_cate)"))
    private Categoria categoria;

    public Producto() {
    }

    public Producto(Integer prodId) {
        this.prodId = prodId;
    }

    public Producto(String nombre, int precio, int peso, int stock, String estado, Modelo modelo, Categoria categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.peso = peso;
        this.stock = stock;
        this.estado = estado;
        this.modelo = modelo;
        this.categoria = categoria;
    }

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
