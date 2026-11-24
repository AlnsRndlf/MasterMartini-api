package cl.duoc.mastermartini_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios_clientes")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tipo_perfil", nullable = false, length = 30)
    private String tipoPerfil;

    @Column(nullable = false, length = 120)
    private String nombre;

    @Column(nullable = false, length = 120)
    private String correo;

    @Column(nullable = false, length = 30)
    private String telefono;

    @Column(nullable = false, length = 200)
    private String direccion;

    @Column(name = "rut_empresa", nullable = false, length = 20)
    private String rutEmpresa;

    @Column(name = "tipo_negocio", nullable = false, length = 80)
    private String tipoNegocio;

    @Column(name = "tamano_negocio", nullable = false, length = 80)
    private String tamanoNegocio;

    @Column(name = "preferencias_contenido", nullable = false, length = 300)
    private String preferenciasContenido;

    @Column(name = "acepta_terminos", nullable = false)
    private Boolean aceptaTerminos = true;

    public UsuarioEntity() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTipoPerfil() { return tipoPerfil; }
    public void setTipoPerfil(String tipoPerfil) { this.tipoPerfil = tipoPerfil; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getRutEmpresa() { return rutEmpresa; }
    public void setRutEmpresa(String rutEmpresa) { this.rutEmpresa = rutEmpresa; }

    public String getTipoNegocio() { return tipoNegocio; }
    public void setTipoNegocio(String tipoNegocio) { this.tipoNegocio = tipoNegocio; }

    public String getTamanoNegocio() { return tamanoNegocio; }
    public void setTamanoNegocio(String tamanoNegocio) { this.tamanoNegocio = tamanoNegocio; }

    public String getPreferenciasContenido() { return preferenciasContenido; }
    public void setPreferenciasContenido(String preferenciasContenido) { this.preferenciasContenido = preferenciasContenido; }

    public Boolean getAceptaTerminos() { return aceptaTerminos; }
    public void setAceptaTerminos(Boolean aceptaTerminos) { this.aceptaTerminos = aceptaTerminos; }
}