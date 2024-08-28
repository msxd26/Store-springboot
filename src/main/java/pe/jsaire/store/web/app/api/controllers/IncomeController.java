package pe.jsaire.store.web.app.api.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.jsaire.store.web.app.api.models.request.IncomeRequest;
import pe.jsaire.store.web.app.api.models.response.IncomeResponse;
import pe.jsaire.store.web.app.infraestructures.abstract_services.IncomeService;

@RestController
@RequestMapping("/income")
@AllArgsConstructor
public class IncomeController {

    private final IncomeService incomeService;


    @GetMapping("/{id}")
    public ResponseEntity<IncomeResponse> findById(@PathVariable Long id) {
        IncomeResponse incomeResponse = incomeService.findById(id);
        return ResponseEntity.ok(incomeResponse);
    }

    @PostMapping
    public ResponseEntity<IncomeResponse> save(@RequestBody IncomeRequest incomeRequest) {
        IncomeResponse incomeResponse = incomeService.save(incomeRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(incomeResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IncomeResponse> update(@PathVariable Long id, @RequestBody IncomeRequest incomeRequest) {
        IncomeResponse incomeResponse = incomeService.update(incomeRequest, id);
        return ResponseEntity.ok(incomeResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        incomeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
