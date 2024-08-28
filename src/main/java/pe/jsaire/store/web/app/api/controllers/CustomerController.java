package pe.jsaire.store.web.app.api.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.jsaire.store.web.app.api.models.request.CustomerRequest;
import pe.jsaire.store.web.app.api.models.response.CustomerResponse;
import pe.jsaire.store.web.app.infraestructures.abstract_services.CustomerService;

@RestController
@AllArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> read (@PathVariable Long id) {
        CustomerResponse customer = customerService.findById(id);
        return ResponseEntity.ok(customer);
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> create (@RequestBody CustomerRequest customerRequest) {
        CustomerResponse customerResponse = customerService.save(customerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> update (@PathVariable Long id, @RequestBody CustomerRequest customerRequest) {
        CustomerResponse customer = customerService.update(customerRequest, id);
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id) {
         customerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }





}
