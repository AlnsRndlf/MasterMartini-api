package cl.duoc.mastermartini_api.repository;

import cl.duoc.mastermartini_api.model.ContenidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ContenidoRepository extends JpaRepository<ContenidoEntity, Integer> {
    List<ContenidoEntity> findAllByOrderByIdDesc();
}