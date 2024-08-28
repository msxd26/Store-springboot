package pe.jsaire.store.web.app.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.jsaire.store.web.app.domain.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
