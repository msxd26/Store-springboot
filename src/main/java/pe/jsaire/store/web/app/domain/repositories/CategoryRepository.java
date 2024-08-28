package pe.jsaire.store.web.app.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import pe.jsaire.store.web.app.domain.entities.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
