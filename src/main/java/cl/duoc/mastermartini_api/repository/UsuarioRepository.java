package cl.duoc.mastermartini_api.repository;

import cl.duoc.mastermartini_api.model.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
}