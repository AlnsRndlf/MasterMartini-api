package cl.duoc.mastermartini_api.controller;

import cl.duoc.mastermartini_api.model.ContenidoEntity;
import cl.duoc.mastermartini_api.repository.ContenidoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contenidos")
@CrossOrigin(origins = "*")
public class ContenidoController {

    private final ContenidoRepository repository;

    public ContenidoController(ContenidoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ContenidoEntity> obtenerTodos() {
        return repository.findAllByOrderByIdDesc();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContenidoEntity> obtenerPorId(@PathVariable Integer id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ContenidoEntity> crear(@RequestBody ContenidoEntity contenido) {
        contenido.setId(null);
        ContenidoEntity guardado = repository.save(contenido);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContenidoEntity> actualizar(
            @PathVariable Integer id,
            @RequestBody ContenidoEntity datos
    ) {
        return repository.findById(id)
                .map(existente -> {
                    existente.setTitulo(datos.getTitulo());
                    existente.setTipo(datos.getTipo());
                    existente.setCategoria(datos.getCategoria());
                    existente.setInsumoMartini(datos.getInsumoMartini());
                    existente.setDuracion(datos.getDuracion());
                    existente.setPasos(datos.getPasos());
                    existente.setImagenUri(datos.getImagenUri());
                    return ResponseEntity.ok(repository.save(existente));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}