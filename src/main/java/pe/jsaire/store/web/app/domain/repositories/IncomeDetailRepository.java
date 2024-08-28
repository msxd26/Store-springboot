package pe.jsaire.store.web.app.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.jsaire.store.web.app.domain.entities.IncomeDetail;

import java.util.UUID;

public interface IncomeDetailRepository extends JpaRepository<IncomeDetail, UUID> {
}
