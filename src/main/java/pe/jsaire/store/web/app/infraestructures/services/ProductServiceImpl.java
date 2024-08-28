package pe.jsaire.store.web.app.infraestructures.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pe.jsaire.store.web.app.api.models.request.ProductRequest;

import pe.jsaire.store.web.app.api.models.response.ProductResponse;
import pe.jsaire.store.web.app.domain.entities.Category;
import pe.jsaire.store.web.app.domain.entities.Product;
import pe.jsaire.store.web.app.domain.repositories.CategoryRepository;
import pe.jsaire.store.web.app.domain.repositories.ProductRepository;
import pe.jsaire.store.web.app.infraestructures.abstract_services.ProductService;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public ProductResponse findById(Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        return entityToResponse(product);
    }

    @Override
    public ProductResponse save(ProductRequest request) {
        Category category = categoryRepository.findById(request.getIdCategory()).orElseThrow();

        Product productPersist = Product.builder()
                .code(request.getCode())
                .name(request.getName())
                .price(request.getPrice())
                .stock(request.getStock())
                .description(request.getDescription())
                .enabled(request.isEnabled())
                .category(category)
                .build();
        return entityToResponse(productRepository.save(productPersist));
    }

    @Override
    public ProductResponse update(ProductRequest request, Long id) {
        Category category = categoryRepository.findById(request.getIdCategory()).orElseThrow();
        Product productUpdate = productRepository.findById(id).orElseThrow();

        productUpdate.setCode(request.getCode());
        productUpdate.setName(request.getName());
        productUpdate.setPrice(request.getPrice());
        productUpdate.setStock(request.getStock());
        productUpdate.setDescription(request.getDescription());
        productUpdate.setCategory(category);
        productUpdate.setEnabled(request.isEnabled());

        Product updatedProduct = productRepository.save(productUpdate);
        return entityToResponse(updatedProduct);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }


    private ProductResponse entityToResponse(Product product) {
        ProductResponse productResponse = new ProductResponse();
        BeanUtils.copyProperties(product, productResponse);
        productResponse.setId(product.getIdProduct());
        productResponse.setIdCategory(product.getCategory().getIdCategory());
        return productResponse;
    }
}
