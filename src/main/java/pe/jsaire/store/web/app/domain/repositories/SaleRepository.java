package pe.jsaire.store.web.app.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import pe.jsaire.store.web.app.domain.entities.Sale;

public interface SaleRepository extends CrudRepository<Sale, Long> {
}
