package cl.duoc.mastermartini_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "contenidos_tecnicos")
public class ContenidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String titulo;

    @Column(nullable = false, length = 50)
    private String tipo;

    @Column(nullable = false, length = 80)
    private String categoria;

    @Column(name = "insumo_martini", nullable = false, length = 150)
    private String insumoMartini;

    @Column(nullable = false, length = 50)
    private String duracion;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String pasos;

    @Column(name = "imagen_uri", length = 500)
    private String imagenUri;

    public ContenidoEntity() {}

    public ContenidoEntity(String titulo, String tipo, String categoria,
                           String insumoMartini, String duracion, String pasos, String imagenUri) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.categoria = categoria;
        this.insumoMartini = insumoMartini;
        this.duracion = duracion;
        this.pasos = pasos;
        this.imagenUri = imagenUri;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getInsumoMartini() { return insumoMartini; }
    public void setInsumoMartini(String insumoMartini) { this.insumoMartini = insumoMartini; }

    public String getDuracion() { return duracion; }
    public void setDuracion(String duracion) { this.duracion = duracion; }

    public String getPasos() { return pasos; }
    public void setPasos(String pasos) { this.pasos = pasos; }

    public String getImagenUri() { return imagenUri; }
    public void setImagenUri(String imagenUri) { this.imagenUri = imagenUri; }
}