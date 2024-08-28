package pe.jsaire.store.web.app.api.controllers;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.jsaire.store.web.app.api.models.request.ProductRequest;
import pe.jsaire.store.web.app.api.models.response.ProductResponse;
import pe.jsaire.store.web.app.infraestructures.abstract_services.ProductService;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;


    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Long id) {
        ProductResponse productResponse = productService.findById(id);
        return ResponseEntity.ok().body(productResponse);
    }

    @PostMapping
    public ResponseEntity<ProductResponse> save(@RequestBody ProductRequest productRequest) {
        ProductResponse productResponse = productService.save(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(@PathVariable Long id, @RequestBody ProductRequest productRequest) {
        ProductResponse productResponse = productService.update(productRequest, id);
        return ResponseEntity.ok().body(productResponse);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
