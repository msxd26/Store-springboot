package pe.jsaire.store.web.app.infraestructures.abstract_services;


import pe.jsaire.store.web.app.api.models.request.CustomerRequest;
import pe.jsaire.store.web.app.api.models.response.CustomerResponse;

public interface CustomerService  extends GenericService<CustomerResponse, CustomerRequest, Long> {
}
