package pe.jsaire.store.web.app.infraestructures.abstract_services;

import pe.jsaire.store.web.app.api.models.request.ProductRequest;
import pe.jsaire.store.web.app.api.models.response.ProductResponse;

public interface ProductService extends GenericService<ProductResponse, ProductRequest, Long> {
}
