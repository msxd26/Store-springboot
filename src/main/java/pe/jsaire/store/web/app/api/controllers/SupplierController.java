package pe.jsaire.store.web.app.api.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.jsaire.store.web.app.api.models.request.SupplierRequest;
import pe.jsaire.store.web.app.api.models.response.SupplierResponse;
import pe.jsaire.store.web.app.infraestructures.abstract_services.SupplierService;

@RestController
@RequestMapping("/supplier")
@AllArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;

    @GetMapping("/{id}")
    public ResponseEntity<SupplierResponse> findById(@PathVariable Long id) {
        SupplierResponse supplierResponse = supplierService.findById(id);
        return ResponseEntity.ok().body(supplierResponse);
    }

    @PostMapping
    public ResponseEntity<SupplierResponse> save(@RequestBody SupplierRequest supplierRequest) {
        SupplierResponse supplierResponse = supplierService.save(supplierRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(supplierResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierResponse> update(@PathVariable Long id, @RequestBody SupplierRequest supplierRequest) {
        SupplierResponse supplierUpdate = supplierService.update(supplierRequest, id);
        return ResponseEntity.ok().body(supplierUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        supplierService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
