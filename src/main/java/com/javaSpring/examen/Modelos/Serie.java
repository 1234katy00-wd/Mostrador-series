package com.javaSpring.examen.Modelos;

import org.hibernate.validator.constraints.URL;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name= "series")
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Por favor proporciona un título.")
    @Size(min =5, message = "El título debe tener al menos 5 caracteres.")
    private String titulo;

    @Positive(message = "la fecha debe ser un número positivo.")
    @NotNull(message = "Por favor proporciona una fecha.")
    private Integer year;

    @Size(min = 10, message = "La descripción debe tener al menos 10 caracteres.")
    @NotBlank(message = "Por favor proporciona una descripción.")
    private String descripcion;

    @URL(message = "No es una URL válida.")
    @NotBlank(message = "Por favor proporciona una URL.")
    private String imagen;

    @Positive(message ="La cantidad debe ser positiva." )
    @NotNull(message = "Por favor proporciona una cantidad.")
    private int cantidad;

    @Positive(message = "El precio debe ser un número positivo.")
    private Double precio;

    //Relacion
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario comprador;

    public Serie() {
    }

    public Serie(Long id, String titulo, Integer year, String descripcion, String imagen, int cantidad,
            Double precio) {
        this.id = id;
        this.titulo = titulo;
        this.year = year;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setComprador(Usuario comprador) {
        this.comprador = comprador;
    }
    
    public Usuario getComprador() {
        return comprador;
    }
    
    public String getPrecioFormateado(){
        if(this.precio == null){
            return "0";
        }
        java.text.DecimalFormat pf = new java.text.DecimalFormat("#,###");
        java.text.DecimalFormatSymbols symbols = new java.text.DecimalFormatSymbols();
    
        symbols.setGroupingSeparator('.');
        pf.setDecimalFormatSymbols(symbols);

        return pf.format(this.precio);
    }

    
    
}
