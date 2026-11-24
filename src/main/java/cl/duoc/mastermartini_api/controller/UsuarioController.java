package cl.duoc.mastermartini_api.controller;

import cl.duoc.mastermartini_api.model.UsuarioEntity;
import cl.duoc.mastermartini_api.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<UsuarioEntity> listarUsuarios() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<UsuarioEntity> registrarUsuario(@RequestBody UsuarioEntity usuario) {
        usuario.setId(null);
        UsuarioEntity guardado = repository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioEntity> actualizarUsuario(
            @PathVariable Integer id,
            @RequestBody UsuarioEntity datos
    ) {
        return repository.findById(id)
                .map(existente -> {
                    existente.setTipoPerfil(datos.getTipoPerfil());
                    existente.setNombre(datos.getNombre());
                    existente.setCorreo(datos.getCorreo());
                    existente.setTelefono(datos.getTelefono());
                    existente.setDireccion(datos.getDireccion());
                    existente.setRutEmpresa(datos.getRutEmpresa());
                    existente.setTipoNegocio(datos.getTipoNegocio());
                    existente.setTamanoNegocio(datos.getTamanoNegocio());
                    existente.setPreferenciasContenido(datos.getPreferenciasContenido());
                    existente.setAceptaTerminos(datos.getAceptaTerminos());
                    return ResponseEntity.ok(repository.save(existente));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}